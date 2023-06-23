package com.hbs.capitole.infrastructure.api.routes;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.infrastructure.api.handlers.PriceHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class Router {
    @Bean
    @RouterOperations(
        {
            @RouterOperation( path = "/api/v1/price/brand/{productId}/product/{brandId}",
                produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET,
                beanClass = PriceHandler.class, beanMethod = "getPriceBrandProduct",
                operation = @Operation( operationId = "getPriceBrandProduct",
                    summary = "Returns the price of a certain brand and product", tags = { "Brand" }, responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse( responseCode = "200",
                        description = "Successful operation",
                        content = @Content( schema = @Schema( implementation = PriceDto.class ) ) ) }, parameters = {
                    @Parameter( required = true, in = ParameterIn.PATH, name = "productId",
                        schema = @Schema( type = "number" ) ),
                    @Parameter( required = true, in = ParameterIn.PATH, name = "brandId",
                        schema = @Schema( type = "number" ) ),
                    @Parameter( required = true, in = ParameterIn.QUERY, name = "priceDate",
                        schema = @Schema( type = "string", format = "date-time", description = "Standard ISO-8601",
                            example = "2020-06-16T10:15:30Z" ) ) }
                )
            )
        } )
    public RouterFunction<ServerResponse> routerPrices( PriceHandler priceHandler ) {
        return RouterFunctions.route( GET( "/api/v1/price/brand/{productId}/product/{brandId}" ),
            priceHandler :: getPriceBrandProduct );
    }
}
