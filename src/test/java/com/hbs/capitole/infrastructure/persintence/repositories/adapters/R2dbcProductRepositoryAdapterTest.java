package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Product;
import com.hbs.capitole.infrastructure.persintence.entities.ProductEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcProductRepository;
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
@DisplayName( "Unit tests for the R2dbcProductRepositoryAdapter class" )
class R2dbcProductRepositoryAdapterTest {
    @Mock
    private R2dbcProductRepository r2dbcProductRepository;
    @InjectMocks
    private R2dbcProductRepositoryAdapter r2dbcProductRepositoryAdapter;

    @Test
    @DisplayName( "Should return the expected product" )
    void testGetProduct() {
        // Given
        Long productId = 1L;
        ProductEntity productEntity = Fixtures.getObject( ProductEntity.class );
        Product product = ProductEntity.toDomainModel( productEntity );
        given( r2dbcProductRepository.findById( anyLong() ) ).willReturn( Mono.just( productEntity ) );
        // When
        Mono<Product> result = r2dbcProductRepositoryAdapter.getProduct( productId );
        // Then
        StepVerifier.create( result )
            .expectNext( product )
            .verifyComplete();
        then( r2dbcProductRepository ).should( times( 1 ) ).findById( anyLong() );
    }
}
