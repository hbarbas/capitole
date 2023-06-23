package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Currency;
import com.hbs.capitole.infrastructure.persintence.entities.CurrencyEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcCurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class R2dbcCurrencyRepositoryAdapter {
    private static final Logger log = LoggerFactory.getLogger( R2dbcCurrencyRepositoryAdapter.class );
    private final R2dbcCurrencyRepository r2dbcCurrencyRepository;

    public R2dbcCurrencyRepositoryAdapter( R2dbcCurrencyRepository r2dbcCurrencyRepository ) {
        this.r2dbcCurrencyRepository = r2dbcCurrencyRepository;
    }

    public Mono<Currency> getCurrency( Integer currencyId ) {
        log.info( "Find the currency, id: {}", currencyId );
        return r2dbcCurrencyRepository.findById( currencyId ).map( CurrencyEntity :: toDomainModel );
    }
}
