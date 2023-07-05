package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.*;
import com.hbs.capitole.infrastructure.persintence.entities.PriceEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcPriceRepository;
import com.hbs.capitole.utils.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the R2dbcPriceRepositoryAdapter class" )
class R2dbcPriceRepositoryAdapterTest {
    @Mock
    private R2dbcPriceRepository mockRepository;
    @Mock
    private R2dbcBrandRepositoryAdapter mockBrandRepositoryAdapter;
    @Mock
    private R2dbcProductRepositoryAdapter mockProductRepositoryAdapter;
    @Mock
    private R2dbcCurrencyRepositoryAdapter mockCurrencyRepositoryAdapter;
    @Mock
    private R2dbcPriorityRepositoryAdapter mockPriorityRepositoryAdapter;
    @Mock
    private R2dbcPriceListRepositoryAdapter mockPriceListRepositoryAdapter;
    @InjectMocks
    private R2dbcPriceRepositoryAdapter repositoryAdapter;

    @Test
    void testGetPrice() {
        // Given
        Long brandId = 1L;
        Long productId = 2L;
        OffsetDateTime date = OffsetDateTime.now();
        PriceEntity priceEntity = Fixtures.getObject( PriceEntity.class );
        Brand brand = Fixtures.getObject( Brand.class );
        PriceList priceList = Fixtures.getObject( PriceList.class );
        Product product = Fixtures.getObject( Product.class );
        Priority priority = Fixtures.getObject( Priority.class );
        Currency currency = Fixtures.getObject( Currency.class );
        Price price = PriceEntity.toDomainModel( priceEntity, brand, priceList, product, priority, currency );
        given(
            mockRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityIdDescLimit1(
                anyLong(), anyLong(), any( OffsetDateTime.class ), any( OffsetDateTime.class ) ) ).willReturn(
            Mono.just( priceEntity ) );
        given( mockBrandRepositoryAdapter.getBrand( anyLong() ) ).willReturn( Mono.just( brand ) );
        given( mockPriceListRepositoryAdapter.getPriceList( anyLong() ) ).willReturn( Mono.just( priceList ) );
        given( mockProductRepositoryAdapter.getProduct( anyLong() ) ).willReturn( Mono.just( product ) );
        given( mockPriorityRepositoryAdapter.getPriority( anyInt() ) ).willReturn( Mono.just( priority ) );
        given( mockCurrencyRepositoryAdapter.getCurrency( anyInt() ) ).willReturn( Mono.just( currency ) );
        // When
        Mono<Price> result = repositoryAdapter.getPrice( brandId, productId, date );
        // Then
        StepVerifier.create( result )
            .expectNext( price )
            .verifyComplete();
        then( mockRepository ).should( times( 1 ) )
            .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityIdDescLimit1(
                anyLong(), anyLong(), any( OffsetDateTime.class ), any( OffsetDateTime.class ) );
        then( mockBrandRepositoryAdapter ).should( times( 1 ) ).getBrand( anyLong() );
        then( mockPriceListRepositoryAdapter ).should( times( 1 ) ).getPriceList( anyLong() );
        then( mockProductRepositoryAdapter ).should( times( 1 ) ).getProduct( anyLong() );
        then( mockPriorityRepositoryAdapter ).should( times( 1 ) ).getPriority( anyInt() );
        then( mockCurrencyRepositoryAdapter ).should( times( 1 ) ).getCurrency( anyInt() );
    }
}
