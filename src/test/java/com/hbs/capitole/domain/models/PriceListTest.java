package com.hbs.capitole.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the PriceList class" )
class PriceListTest {
    @Test
    @DisplayName( "Check the build of the model" )
    void testPriceListBuilder() {
        // Given
        Long expectedId = 1L;
        String expectedName = "Test PriceList";
        // When
        PriceList priceList = new PriceList.Builder()
            .id( expectedId )
            .name( expectedName )
            .build();
        // Then
        assertEquals( expectedId, priceList.getId() );
        assertEquals( expectedName, priceList.getName() );
    }

    @Test
    @DisplayName( "Check the toString of the model" )
    void testPriceListToString() {
        // Given
        Long id = 1L;
        String name = "Test PriceList";
        // When
        PriceList priceList = new PriceList.Builder()
            .id( id )
            .name( name )
            .build();
        // Then
        String expectedToString = "PriceList{id=" + id + ", name='" + name + "'}";
        assertEquals( expectedToString, priceList.toString() );
    }

    @Test
    @DisplayName( "Check the equals and hashCode of the model" )
    void testPriceListEqualsAndHashCode() {
        // Given
        Long id = 1L;
        String name = "Test PriceList";
        // When
        PriceList priceList1 = new PriceList.Builder()
            .id( id )
            .name( name )
            .build();
        // Then
        PriceList priceList2 = new PriceList.Builder()
            .id( id )
            .name( name )
            .build();
        PriceList priceList3 = new PriceList.Builder()
            .id( 2L )
            .name( "Other PriceList" )
            .build();
        // Then
        assertEquals( priceList1, priceList2 );
        assertEquals( priceList1.hashCode(), priceList2.hashCode() );
        assertEquals( priceList1.hashCode(), priceList1.hashCode() );
        assertEquals( priceList2, priceList1 );
        assertEquals( priceList2.hashCode(), priceList1.hashCode() );
        assertNotEquals( priceList1, priceList3 );
        assertNotEquals( priceList1.hashCode(), priceList3.hashCode() );
    }
}

