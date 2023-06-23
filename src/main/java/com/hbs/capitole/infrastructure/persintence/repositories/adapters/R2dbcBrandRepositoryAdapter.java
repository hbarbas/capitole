package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Brand;
import com.hbs.capitole.infrastructure.persintence.entities.BrandEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcBrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class R2dbcBrandRepositoryAdapter {
    private static final Logger log = LoggerFactory.getLogger( R2dbcBrandRepositoryAdapter.class );
    private final R2dbcBrandRepository r2dbcBrandRepository;

    public R2dbcBrandRepositoryAdapter( R2dbcBrandRepository r2dbcBrandRepository ) {
        this.r2dbcBrandRepository = r2dbcBrandRepository;
    }

    public Mono<Brand> getBrand( Long brandId ) {
        log.info( "Find the brand, id: {}", brandId );
        return r2dbcBrandRepository.findById( brandId ).map( BrandEntity :: toDomainModel );
    }
}
