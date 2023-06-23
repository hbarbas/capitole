package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Product;
import com.hbs.capitole.infrastructure.persintence.entities.ProductEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class R2dbcProductRepositoryAdapter {
    private static final Logger log = LoggerFactory.getLogger( R2dbcProductRepositoryAdapter.class );
    private final R2dbcProductRepository r2dbcProductRepository;

    public R2dbcProductRepositoryAdapter( R2dbcProductRepository r2dbcProductRepository ) {
        this.r2dbcProductRepository = r2dbcProductRepository;
    }

    public Mono<Product> getProduct( Long productId ) {
        log.info( "Find the product, id: {}", productId );
        return r2dbcProductRepository.findById( productId ).map( ProductEntity :: toDomainModel );
    }
}
