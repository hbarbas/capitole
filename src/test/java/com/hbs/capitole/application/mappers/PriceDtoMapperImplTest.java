package com.hbs.capitole.application.mappers;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.domain.models.Price;
import com.hbs.capitole.utils.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the PriceDtoMapperImplTest class" )
class PriceDtoMapperImplTest {
    @InjectMocks
    private PriceDtoMapperImpl priceDtoMapper;

    @Test
    @DisplayName( "Should return the built dto" )
    void shouldReturnBuildDto() {
        // Given
        Price expectedPrice = Fixtures.getObject( Price.class );
        // When
        PriceDto result = priceDtoMapper.fromDomainModel( expectedPrice );
        // Then
        assertEquals( expectedPrice.getProduct().getId(), result.getProductId() );
        assertEquals( expectedPrice.getBrand().getId(), result.getBrandId() );
        assertEquals( expectedPrice.getPriceList().getName(), result.getPriceList() );
        assertEquals( expectedPrice.getStartDate(), OffsetDateTime.parse( result.getStartDate(),
            DateTimeFormatter.ISO_OFFSET_DATE_TIME ) );
        assertEquals( expectedPrice.getEndDate(), OffsetDateTime.parse( result.getEndDate(),
            DateTimeFormatter.ISO_OFFSET_DATE_TIME ) );
        assertEquals( expectedPrice.getCost(), result.getCost() );
    }
}
