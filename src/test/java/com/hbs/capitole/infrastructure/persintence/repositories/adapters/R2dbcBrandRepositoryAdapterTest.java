package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Brand;
import com.hbs.capitole.infrastructure.persintence.entities.BrandEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcBrandRepository;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the R2dbcBrandRepositoryAdapterTest class" )
class R2dbcBrandRepositoryAdapterTest {
    @Mock
    private R2dbcBrandRepository r2dbcBrandRepository;
    @InjectMocks
    private R2dbcBrandRepositoryAdapter r2dbcBrandRepositoryAdapter;

    @Test
    @DisplayName( "Should return the expected brand" )
    void testGetBrand() {
        // Given
        BrandEntity brandEntity = Fixtures.getObject( BrandEntity.class );
        Brand brand = BrandEntity.toDomainModel( brandEntity );
        given( r2dbcBrandRepository.findById( anyLong() ) ).willReturn( Mono.just( brandEntity ) );
        //When
        Mono<Brand> result = r2dbcBrandRepositoryAdapter.getBrand( 1L );
        //Then
        StepVerifier.create( result )
            .expectNext( brand )
            .verifyComplete();
        verify( r2dbcBrandRepository, times( 1 ) ).findById( anyLong() );
    }
}
