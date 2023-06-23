package com.hbs.capitole;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.application.services.PriceService;
import com.hbs.capitole.infrastructure.api.handlers.PriceHandler;
import com.hbs.capitole.infrastructure.api.routes.Router;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
@DisplayName( "Pruebas de integración" )
class CapitoleApplicationTests {
    @Autowired
    PriceService priceService;
    @Autowired
    PriceHandler priceHandler;
    @Autowired
    Router router;
    WebTestClient webTestClient;

    @BeforeEach
    public void setUp() {
        webTestClient = WebTestClient.bindToRouterFunction( router.routerPrices( priceHandler ) ).build();
    }

    @Test
    @DisplayName( "Validating the price for brand 1 (Zara), product 35455 and date of 2020-06-14 10:00:00" )
    void getPriceBrandProduct1() {
        Long brandId = 1L;
        Long productId = 35455L;
        String date = "2020-06-14T10:00:00Z";
        PriceDto expectedPriceDto = new PriceDto( 35455L, 1L, "TARIFA1", "2020-06-14T00:00:00Z", "2020-12-31T23:59:59Z",
            BigDecimal.valueOf( 35.50 ).setScale( 2, RoundingMode.DOWN ) );
        validatePrice( brandId, productId, date, expectedPriceDto );
    }

    @Test
    @DisplayName( "Validating the price for brand 1 (Zara), product 35455 and date of 2020-06-14 16:00:00" )
    void getPriceBrandProduct2() {
        Long brandId = 1L;
        Long productId = 35455L;
        String date = "2020-06-14T16:00:00Z";
        PriceDto expectedPriceDto = new PriceDto( 35455L, 1L, "TARIFA2", "2020-06-14T15:00:00Z", "2020-06-14T18:30:00Z",
            BigDecimal.valueOf( 25.45 ).setScale( 2, RoundingMode.DOWN ) );
        validatePrice( brandId, productId, date, expectedPriceDto );
    }

    @Test
    @DisplayName( "Validating the price for brand 1 (Zara), product 35455 and date of 2020-06-14 21:00:00" )
    void getPriceBrandProduct3() {
        Long brandId = 1L;
        Long productId = 35455L;
        String date = "2020-06-14T21:00:00Z";
        PriceDto expectedPriceDto = new PriceDto( 35455L, 1L, "TARIFA1", "2020-06-14T00:00:00Z", "2020-12-31T23:59:59Z",
            BigDecimal.valueOf( 35.50 ).setScale( 2, RoundingMode.DOWN ) );
        validatePrice( brandId, productId, date, expectedPriceDto );
    }

    @Test
    @DisplayName( "Validating the price for brand 1 (Zara), product 35455 and date of 2020-06-15 10:00:00" )
    void getPriceBrandProduct4() {
        Long brandId = 1L;
        Long productId = 35455L;
        String date = "2020-06-15T10:00:00Z";
        PriceDto expectedPriceDto = new PriceDto( 35455L, 1L, "TARIFA3", "2020-06-15T00:00:00Z", "2020-06-15T11:00:00Z",
            BigDecimal.valueOf( 30.50 ).setScale( 2, RoundingMode.DOWN ) );
        validatePrice( brandId, productId, date, expectedPriceDto );
    }

    @Test
    @DisplayName( "Validating the price for brand 1 (Zara), product 35455 and date of 2020-06-16 21:00:00" )
    void getPriceBrandProduct5() {
        Long brandId = 1L;
        Long productId = 35455L;
        String date = "2020-06-16T21:00:00Z";
        PriceDto expectedPriceDto = new PriceDto( 35455L, 1L, "TARIFA4", "2020-06-15T16:00:00Z", "2020-12-31T23:59:59Z",
            BigDecimal.valueOf( 38.95 ).setScale( 2, RoundingMode.DOWN ) );
        validatePrice( brandId, productId, date, expectedPriceDto );
    }

    private void validatePrice( Long brandId, Long productId, String date, PriceDto expectedPriceDto ) {
        webTestClient.get()
            .uri( uriBuilder -> uriBuilder.path( "/api/v1/price/brand/{brandId}/product/{productId}" )
                .queryParam( "priceDate", date )
                .build( brandId, productId ) )
            .exchange()
            .expectStatus().isOk()
            .expectBody( PriceDto.class )
            .isEqualTo( expectedPriceDto );
    }
}
