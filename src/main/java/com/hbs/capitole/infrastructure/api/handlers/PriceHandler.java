package com.hbs.capitole.infrastructure.api.handlers;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.application.services.PriceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@Component
public class PriceHandler {
    private static final Logger log = LoggerFactory.getLogger( PriceHandler.class );
    private final PriceService priceService;

    public PriceHandler( PriceService priceService ) {
        this.priceService = priceService;
    }

    public Mono<ServerResponse> getPriceBrandProduct( ServerRequest serverRequest ) {
        log.info( "Retrieving the price of brand and product" );
        Map<String, String> pathParams = serverRequest.pathVariables();
        MultiValueMap<String, String> queryParams = serverRequest.queryParams();
        return ServerResponse.ok().body( getPrice( pathParams, queryParams ), PriceDto.class );
    }

    private Mono<PriceDto> getPrice( Map<String, String> pathParams, MultiValueMap<String, String> queryParams ) {
        String brandIdStr = pathParams.get( "brandId" );
        String productIdStr = pathParams.get( "productId" );
        String priceDateStr = queryParams.getFirst( "priceDate" );
        if( StringUtils.isEmpty( brandIdStr ) || StringUtils.isEmpty( productIdStr ) ||
            StringUtils.isEmpty( priceDateStr ) ) {
            return Mono.error( new IllegalArgumentException( "Faltan parámetros obligatorios" ) );
        }
        try {
            Long brandId = Long.valueOf( brandIdStr );
            Long productId = Long.valueOf( productIdStr );
            OffsetDateTime priceDate = OffsetDateTime.parse( priceDateStr, DateTimeFormatter.ISO_OFFSET_DATE_TIME );
            return priceService.getPrice( brandId, productId, priceDate );
        }
        catch( NumberFormatException e ) {
            return Mono.error(
                new IllegalArgumentException( "Los parámetros brandId y productId deben ser numéricos" ) );
        }
        catch( DateTimeParseException e ) {
            return Mono.error(
                new IllegalArgumentException( "El parámetro priceDate tiene un formato de fecha inválido" ) );
        }
    }
}
