package com.hbs.capitole.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the Price class" )
class PriceTest {
    @Test
    @DisplayName( "Check the build of the model" )
    void testPriceBuilder() {
        // Given
        Long expectedId = 1L;
        Brand expectedBrand = new Brand.Builder().id( 1L ).name( "Test Brand" ).build();
        OffsetDateTime expectedStartDate = OffsetDateTime.now();
        OffsetDateTime expectedEndDate = expectedStartDate.plusDays( 7 );
        PriceList expectedPriceList = new PriceList.Builder().id( 1L ).name( "Test PriceList" ).build();
        Product expectedProduct = new Product.Builder().id( 1L ).name( "Test Product" ).build();
        Priority expectedPriority = Priority.ALTA;
        BigDecimal expectedCost = BigDecimal.valueOf( 9.99 );
        Currency expectedCurrency = Currency.EUR;
        // When
        Price price = new Price.Builder()
            .id( expectedId )
            .brand( expectedBrand )
            .startDate( expectedStartDate )
            .endDate( expectedEndDate )
            .priceList( expectedPriceList )
            .product( expectedProduct )
            .priority( expectedPriority )
            .price( expectedCost )
            .currency( expectedCurrency )
            .build();
        // Then
        assertEquals( expectedId, price.getId() );
        assertEquals( expectedBrand, price.getBrand() );
        assertEquals( expectedStartDate, price.getStartDate() );
        assertEquals( expectedEndDate, price.getEndDate() );
        assertEquals( expectedPriceList, price.getPriceList() );
        assertEquals( expectedProduct, price.getProduct() );
        assertEquals( expectedPriority, price.getPriority() );
        assertEquals( expectedCost, price.getCost() );
        assertEquals( expectedCurrency, price.getCurrency() );
    }

    @Test
    @DisplayName( "Check the toString of the model" )
    void testPriceToString() {
        // Given
        Long id = 1L;
        Brand brand = new Brand.Builder().id( 1L ).name( "Test Brand" ).build();
        OffsetDateTime startDate = OffsetDateTime.now();
        OffsetDateTime endDate = startDate.plusDays( 7 );
        PriceList priceList = new PriceList.Builder().id( 1L ).name( "Test PriceList" ).build();
        Product product = new Product.Builder().id( 1L ).name( "Test Product" ).build();
        Priority priority = Priority.ALTA;
        BigDecimal cost = BigDecimal.valueOf( 9.99 );
        Currency currency = Currency.EUR;
        // When
        Price price = new Price.Builder()
            .id( id )
            .brand( brand )
            .startDate( startDate )
            .endDate( endDate )
            .priceList( priceList )
            .product( product )
            .priority( priority )
            .price( cost )
            .currency( currency )
            .build();
        // Then
        String expectedToString = "Price{id=" + id + ", brand=" + brand + ", startDate=" + startDate +
            ", endDate=" + endDate + ", priceList=" + priceList + ", product=" + product +
            ", priority=" + priority + ", cost=" + cost + ", currency=" + currency + "}";
        assertEquals( expectedToString, price.toString() );
    }

    @Test
    @DisplayName( "Check the equals and hashCode of the model" )
    void testPriceEqualsAndHashCode() {
        // Given
        Long id = 1L;
        Brand brand = new Brand.Builder().id( 1L ).name( "Test Brand" ).build();
        OffsetDateTime startDate = OffsetDateTime.now();
        OffsetDateTime endDate = startDate.plusDays( 7 );
        PriceList priceList = new PriceList.Builder().id( 1L ).name( "Test PriceList" ).build();
        Product product = new Product.Builder().id( 1L ).name( "Test Product" ).build();
        Priority priority = Priority.ALTA;
        BigDecimal cost = BigDecimal.valueOf( 9.99 );
        Currency currency = Currency.EUR;
        // When
        Price price1 = new Price.Builder()
            .id( id )
            .brand( brand )
            .startDate( startDate )
            .endDate( endDate )
            .priceList( priceList )
            .product( product )
            .priority( priority )
            .price( cost )
            .currency( currency )
            .build();
        Price price2 = new Price.Builder()
            .id( id )
            .brand( brand )
            .startDate( startDate )
            .endDate( endDate )
            .priceList( priceList )
            .product( product )
            .priority( priority )
            .price( cost )
            .currency( currency )
            .build();
        Price price3 = new Price.Builder()
            .id( 2L )
            .brand( new Brand.Builder().id( 2L ).name( "Other Brand" ).build() )
            .startDate( startDate )
            .endDate( endDate )
            .priceList( new PriceList.Builder().id( 2L ).name( "Other PriceList" ).build() )
            .product( new Product.Builder().id( 2L ).name( "Other Product" ).build() )
            .priority( Priority.BAJA )
            .price( BigDecimal.valueOf( 18.99 ) )
            .currency( Currency.CNY )
            .build();
        // Then
        assertEquals( price1, price2 );
        assertEquals( price1.hashCode(), price2.hashCode() );
        assertEquals( price1.hashCode(), price1.hashCode() );
        assertEquals( price2, price1 );
        assertEquals( price2.hashCode(), price1.hashCode() );
        assertNotEquals( price1, price3 );
        assertNotEquals( price1.hashCode(), price3.hashCode() );
    }
}

