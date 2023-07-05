package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.PriceList;
import com.hbs.capitole.infrastructure.persintence.entities.PriceListEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcPriceListRepository;
import com.hbs.capitole.utils.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the R2dbcPriceListRepositoryAdapter class" )
class R2dbcPriceListRepositoryAdapterTest {
    @Mock
    private R2dbcPriceListRepository r2dbcPriceListRepository;
    @InjectMocks
    private R2dbcPriceListRepositoryAdapter r2dbcPriceListRepositoryAdapter;

    @Test
    @DisplayName( "Should return the expected price list" )
    void testGetPriceList() {
        // Given
        Long priceListId = 1L;
        PriceListEntity priceListEntity = Fixtures.getObject( PriceListEntity.class );
        PriceList priceList = PriceListEntity.toDomainModel( priceListEntity );
        given( r2dbcPriceListRepository.findById( anyLong() ) ).willReturn( Mono.just( priceListEntity ) );
        // When
        Mono<PriceList> result = r2dbcPriceListRepositoryAdapter.getPriceList( priceListId );
        // Then
        StepVerifier.create( result )
            .expectNext( priceList )
            .verifyComplete();
        then( r2dbcPriceListRepository ).should( times( 1 ) ).findById( anyLong() );
    }
}
