package com.hbs.capitole.application.services;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.application.mappers.PriceDtoMapper;
import com.hbs.capitole.domain.ports.in.PriceUseCases;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

public class PriceServiceImpl implements PriceService {
    private final PriceUseCases priceUseCases;
    private final PriceDtoMapper priceDtoMapper;

    public PriceServiceImpl( PriceUseCases priceUseCases, PriceDtoMapper priceDtoMapper ) {
        this.priceUseCases = priceUseCases;
        this.priceDtoMapper = priceDtoMapper;
    }

    public Mono<PriceDto> getPrice( Long brandId, Long productId, OffsetDateTime date ) {
        return priceUseCases.getPrice( brandId, productId, date )
            .map( priceDtoMapper :: fromDomainModelToApplicationDto );
    }
}
