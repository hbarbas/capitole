package com.hbs.capitole.application.usecases;

import com.hbs.capitole.domain.models.Price;
import com.hbs.capitole.domain.ports.in.PriceUseCases;
import com.hbs.capitole.domain.ports.out.PriceRepository;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

public class PriceUseCasesImpl implements PriceUseCases {
    private final PriceRepository priceRepository;

    public PriceUseCasesImpl( PriceRepository priceRepository ) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Mono<Price> getPrice( Long brandId, Long productId, OffsetDateTime date ) {
        return priceRepository.getPrice( brandId, productId, date );
    }
}
