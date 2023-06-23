package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.PriceList;
import com.hbs.capitole.infrastructure.persintence.entities.PriceListEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcPriceListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class R2dbcPriceListRepositoryAdapter {
    private static final Logger log = LoggerFactory.getLogger( R2dbcPriceListRepositoryAdapter.class );
    private final R2dbcPriceListRepository r2dbcPriceListRepository;

    public R2dbcPriceListRepositoryAdapter( R2dbcPriceListRepository r2dbcPriceListRepository ) {
        this.r2dbcPriceListRepository = r2dbcPriceListRepository;
    }

    public Mono<PriceList> getPriceList( Long priceListId ) {
        log.info( "Find the priceList, id: {}", priceListId );
        return r2dbcPriceListRepository.findById( priceListId ).map( PriceListEntity :: toDomainModel );
    }
}
