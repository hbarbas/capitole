package com.hbs.capitole.infrastructure.persintence.repositories;

import com.hbs.capitole.infrastructure.persintence.entities.PriceEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface R2dbcPriceRepository extends R2dbcRepository<PriceEntity, Integer> {
}
