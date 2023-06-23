package com.hbs.capitole.domain.ports.out;

import com.hbs.capitole.domain.models.Price;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

public interface PriceRepository {
    Mono<Price> getPrice( Long brandId, Long productId, OffsetDateTime date );
}
