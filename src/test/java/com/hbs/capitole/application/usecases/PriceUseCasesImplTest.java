package com.hbs.capitole.application.usecases;

import com.hbs.capitole.domain.models.Price;
import com.hbs.capitole.domain.ports.out.PriceRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the PriceUseCasesImpl class" )
class PriceUseCasesImplTest {
    @Mock
    private PriceRepository priceRepository;
    @InjectMocks
    private PriceUseCasesImpl priceUseCases;

    @Test
    @DisplayName( "Should return the expected price" )
    void shouldReturnExpectedPrice() {
        // Given
        Long brandId = 1L;
        Long productId = 1L;
        OffsetDateTime date = OffsetDateTime.now();
        Price expectedPrice = Fixtures.getObject( Price.class );
        given( priceRepository.getPrice( anyLong(), anyLong(), any( OffsetDateTime.class ) ) ).willReturn(
            Mono.just( expectedPrice ) );
        // When
        Mono<Price> result = priceUseCases.getPrice( brandId, productId, date );
        // Then
        StepVerifier.create( result )
            .expectNext( expectedPrice )
            .expectComplete()
            .verify();
        then( priceRepository ).should( times( 1 ) ).getPrice( anyLong(), anyLong(), any( OffsetDateTime.class ) );
    }
}
