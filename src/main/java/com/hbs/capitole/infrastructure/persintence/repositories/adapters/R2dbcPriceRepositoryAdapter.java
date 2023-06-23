package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Price;
import com.hbs.capitole.domain.ports.out.PriceRepository;
import com.hbs.capitole.infrastructure.persintence.entities.PriceEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class R2dbcPriceRepositoryAdapter implements PriceRepository {
    private static final Logger log = LoggerFactory.getLogger( R2dbcPriceRepositoryAdapter.class );
    private final R2dbcPriceRepository r2dbcPriceRepository;
    private final R2dbcBrandRepositoryAdapter r2dbcBrandRepositoryAdapter;
    private final R2dbcProductRepositoryAdapter r2dbcProductRepositoryAdapter;
    private final R2dbcCurrencyRepositoryAdapter r2dbcCurrencyRepositoryAdapter;
    private final R2dbcPriorityRepositoryAdapter r2dbcPriorityRepositoryAdapter;
    private final R2dbcPriceListRepositoryAdapter r2dbcPriceListRepositoryAdapter;

    public R2dbcPriceRepositoryAdapter( R2dbcPriceRepository r2dbcPriceRepository,
        R2dbcBrandRepositoryAdapter r2dbcBrandRepositoryAdapter,
        R2dbcProductRepositoryAdapter r2dbcProductRepositoryAdapter,
        R2dbcCurrencyRepositoryAdapter r2dbcCurrencyRepositoryAdapter,
        R2dbcPriorityRepositoryAdapter r2dbcPriorityRepositoryAdapter,
        R2dbcPriceListRepositoryAdapter r2dbcPriceListRepositoryAdapter ) {
        this.r2dbcPriceRepository = r2dbcPriceRepository;
        this.r2dbcBrandRepositoryAdapter = r2dbcBrandRepositoryAdapter;
        this.r2dbcProductRepositoryAdapter = r2dbcProductRepositoryAdapter;
        this.r2dbcCurrencyRepositoryAdapter = r2dbcCurrencyRepositoryAdapter;
        this.r2dbcPriorityRepositoryAdapter = r2dbcPriorityRepositoryAdapter;
        this.r2dbcPriceListRepositoryAdapter = r2dbcPriceListRepositoryAdapter;
    }

    @Override
    public Mono<Price> getPrice( Long brandId, Long productId, OffsetDateTime date ) {
        String dateFormat = date.format( DateTimeFormatter.ISO_OFFSET_DATE_TIME );
        log.info( "Find the price, brandId: {} productId: {} date: {} ", brandId, productId, dateFormat );
        return r2dbcPriceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityIdDesc(
                brandId, productId, date, date ).elementAt( 0 )
            .flatMap( priceEntity -> Mono.zip(
                Mono.just( priceEntity ),
                r2dbcBrandRepositoryAdapter.getBrand( priceEntity.getBrandId() ),
                r2dbcPriceListRepositoryAdapter.getPriceList( priceEntity.getPriceListId() ),
                r2dbcProductRepositoryAdapter.getProduct( priceEntity.getProductId() ),
                r2dbcPriorityRepositoryAdapter.getPriority( priceEntity.getPriorityId() ),
                r2dbcCurrencyRepositoryAdapter.getCurrency( priceEntity.getCurrencyId() )
            ) )
            .map( tuple -> PriceEntity.toDomainModel( tuple.getT1(), tuple.getT2(), tuple.getT3(), tuple.getT4(),
                tuple.getT5(), tuple.getT6() ) );
    }
}
