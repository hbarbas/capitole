package com.hbs.capitole.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the ProductTest class" )
class ProductTest {
    @Test
    @DisplayName( "Check the build of the model" )
    void testProductBuilder() {
        // Given
        Long expectedId = 1L;
        String expectedName = "Test Product";
        // When
        Product product = new Product.Builder()
            .id( expectedId )
            .name( expectedName )
            .build();
        // Then
        assertEquals( expectedId, product.getId() );
        assertEquals( expectedName, product.getName() );
    }

    @Test
    @DisplayName( "Check the toString of the model" )
    void testProductToString() {
        // Given
        Long id = 1L;
        String name = "Test Product";
        // When
        Product product = new Product.Builder()
            .id( id )
            .name( name )
            .build();
        // Then
        String expectedToString = "Product{id=" + id + ", name='" + name + "'}";
        assertEquals( expectedToString, product.toString() );
    }

    @Test
    @DisplayName( "Check the equals and hashCode of the model" )
    void testProductEqualsAndHashCode() {
        // Given
        Long id = 1L;
        String name = "Test Product";
        // When
        Product product1 = new Product.Builder()
            .id( id )
            .name( name )
            .build();
        Product product2 = new Product.Builder()
            .id( id )
            .name( name )
            .build();
        Product product3 = new Product.Builder()
            .id( 2L )
            .name( "Other Product" )
            .build();
        // Then
        assertEquals( product1, product2 );
        assertEquals( product1.hashCode(), product2.hashCode() );
        assertEquals( product1.hashCode(), product1.hashCode() );
        assertEquals( product2, product1 );
        assertEquals( product2.hashCode(), product1.hashCode() );
        assertNotEquals( product1, product3 );
        assertNotEquals( product1.hashCode(), product3.hashCode() );
    }
}
