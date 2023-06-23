package com.hbs.capitole.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the BrandTest class" )
class BrandTest {
    @Test
    @DisplayName( "Check the build of the model" )
    void testBrandBuilder() {
        // Given
        Long expectedId = 1L;
        String expectedName = "Test Brand";
        // When
        Brand brand = new Brand.Builder()
            .id( expectedId )
            .name( expectedName )
            .build();
        // Then
        assertEquals( expectedId, brand.getId() );
        assertEquals( expectedName, brand.getName() );
    }

    @Test
    @DisplayName( "Check the toString of the model" )
    void testBrandToString() {
        // Given
        Long id = 1L;
        String name = "Test Brand";
        // When
        Brand brand = new Brand.Builder()
            .id( id )
            .name( name )
            .build();
        // Then
        String expectedToString = "Brand{id=" + id + ", name='" + name + "'}";
        assertEquals( expectedToString, brand.toString() );
    }

    @Test
    @DisplayName( "Check the equals and hashCode of the model" )
    void testBrandEqualsAndHashCode() {
        // Given
        Long id = 1L;
        String name = "Test Brand";
        // When
        Brand brand1 = new Brand.Builder()
            .id( id )
            .name( name )
            .build();
        Brand brand2 = new Brand.Builder()
            .id( id )
            .name( name )
            .build();
        Brand brand3 = new Brand.Builder()
            .id( 2L )
            .name( "Other Product" )
            .build();
        // Then
        assertEquals( brand1, brand2 );
        assertEquals( brand1.hashCode(), brand2.hashCode() );
        assertEquals( brand1.hashCode(), brand1.hashCode() );
        assertEquals( brand2, brand1 );
        assertEquals( brand2.hashCode(), brand1.hashCode() );
        assertNotEquals( brand1, brand3 );
        assertNotEquals( brand1.hashCode(), brand3.hashCode() );
    }
}
