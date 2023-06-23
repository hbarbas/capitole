package com.hbs.capitole.domain.ports.in;

import com.hbs.capitole.domain.models.Price;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

public interface PriceUseCases {
    Mono<Price> getPrice( Long brandId, Long productId, OffsetDateTime date );
}
