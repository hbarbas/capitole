package com.hbs.capitole.infrastructure.persintence.repositories;

import com.hbs.capitole.infrastructure.persintence.entities.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R2dbcProductRepository extends R2dbcRepository<ProductEntity, Long> {
}
