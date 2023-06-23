package com.hbs.capitole.infrastructure.api.routes;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.application.services.PriceService;
import com.hbs.capitole.infrastructure.api.handlers.PriceHandler;
import com.hbs.capitole.utils.Fixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the RouterTest class" )
class RouterTest {
    @Mock
    PriceService priceService;
    @InjectMocks
    PriceHandler priceHandler;
    @InjectMocks
    Router router;
    WebTestClient webTestClient;

    @BeforeEach
    public void setUp() {
        webTestClient = WebTestClient.bindToRouterFunction( router.routerPrices( priceHandler ) ).build();
    }

    @Test
    @DisplayName( "Returns the price of a certain brand and product" )
    void getPriceBrandProduct() {
        PriceDto expectedPriceDto = Fixtures.getObject( PriceDto.class );
        given( priceService.getPrice( anyLong(), anyLong(), any( OffsetDateTime.class ) ) ).willReturn(
            Mono.just( expectedPriceDto ) );
        webTestClient.get()
            .uri( uriBuilder -> uriBuilder.path( "/api/v1/price/brand/{brandId}/product/{productId}" )
                .queryParam( "priceDate", "2020-06-16T10:15:30Z" )
                .build( 1, 2 ) )
            .exchange()
            .expectStatus().isOk()
            .expectBody( PriceDto.class )
            .isEqualTo( expectedPriceDto );
        then( priceService ).should( times( 1 ) ).getPrice( anyLong(), anyLong(), any( OffsetDateTime.class ) );
    }
}
