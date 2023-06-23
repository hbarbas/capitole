package com.hbs.capitole.application.services;

import com.hbs.capitole.application.dtos.PriceDto;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

public interface PriceService {
    Mono<PriceDto> getPrice( Long brandId, Long productId, OffsetDateTime date );
}
