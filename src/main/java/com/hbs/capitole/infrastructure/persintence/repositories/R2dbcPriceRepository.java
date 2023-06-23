package com.hbs.capitole.infrastructure.persintence.repositories;

import com.hbs.capitole.infrastructure.persintence.entities.PriceEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

@Repository
public interface R2dbcPriceRepository extends R2dbcRepository<PriceEntity, Long> {
    @Query( "SELECT * FROM prices " +
        "WHERE brand_id = :brandId " +
        "AND product_id = :productId " +
        "AND start_date <= :endDate " +
        "AND end_date >= :startDate " +
        "ORDER BY priority_id DESC " +
        "LIMIT 1" )
    Mono<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityIdDescLimit1(
        Long brandId, Long productId, OffsetDateTime startDate, OffsetDateTime endDate );
}
