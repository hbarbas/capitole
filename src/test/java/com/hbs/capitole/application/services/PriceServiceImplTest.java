package com.hbs.capitole.application.services;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.application.mappers.PriceDtoMapper;
import com.hbs.capitole.domain.models.Price;
import com.hbs.capitole.domain.ports.in.PriceUseCases;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the PriceServiceImplTest class" )
class PriceServiceImplTest {
    @Mock
    private PriceUseCases priceUseCases;
    @Mock
    private PriceDtoMapper priceDtoMapper;
    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    @DisplayName( "Should return the expected price" )
    void shouldReturnExpectedPrice() {
        //Given
        Long productId = 1L;
        Long brandId = 1L;
        OffsetDateTime date = OffsetDateTime.now();
        PriceDto expectedPriceDto = Fixtures.getObject( PriceDto.class );
        given( priceUseCases.getPrice( anyLong(), anyLong(), any( OffsetDateTime.class ) ) ).willReturn(
            Mono.just( Fixtures.getObject( Price.class ) ) );
        given( priceDtoMapper.fromDomainModel( any( Price.class ) ) ).willReturn(
            expectedPriceDto );
        //When
        Mono<PriceDto> result = priceService.getPrice( productId, brandId, date );
        //Then
        StepVerifier.create( result )
            .expectNext( expectedPriceDto )
            .expectComplete()
            .verify();
        then( priceUseCases ).should( times( 1 ) ).getPrice( anyLong(), anyLong(), any( OffsetDateTime.class ) );
        then( priceDtoMapper ).should( times( 1 ) ).fromDomainModel( any( Price.class ) );
    }
}
