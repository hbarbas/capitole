package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Currency;
import com.hbs.capitole.infrastructure.persintence.entities.CurrencyEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcCurrencyRepository;
import com.hbs.capitole.utils.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the R2dbcCurrencyRepositoryAdapter class" )
class R2dbcCurrencyRepositoryAdapterTest {
    @Mock
    private R2dbcCurrencyRepository r2dbcCurrencyRepository;
    @InjectMocks
    private R2dbcCurrencyRepositoryAdapter r2dbcCurrencyRepositoryAdapter;

    @Test
    @DisplayName( "Should return the expected currency" )
    void testGetCurrency() {
        // Given
        Integer currencyId = 1;
        CurrencyEntity currencyEntity = Fixtures.getObject( CurrencyEntity.class );
        currencyEntity.setIso( "EUR" );
        Currency currency = Currency.valueOf( currencyEntity.getIso() );
        given( r2dbcCurrencyRepository.findById( anyInt() ) ).willReturn( Mono.just( currencyEntity ) );
        // When
        Mono<Currency> result = r2dbcCurrencyRepositoryAdapter.getCurrency( currencyId );
        // Then
        StepVerifier.create( result )
            .expectNext( currency )
            .verifyComplete();
        verify( r2dbcCurrencyRepository, times( 1 ) ).findById( anyInt() );
    }
}
