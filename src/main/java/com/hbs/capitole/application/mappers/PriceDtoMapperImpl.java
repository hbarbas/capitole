package com.hbs.capitole.application.mappers;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.domain.models.Price;

import java.time.format.DateTimeFormatter;

public class PriceDtoMapperImpl implements PriceDtoMapper {
    public PriceDto fromDomainModel( Price price ) {
        return new PriceDto( price.getProduct().getId(), price.getBrand().getId(), price.getPriceList().getName(),
            price.getStartDate().format( DateTimeFormatter.ISO_OFFSET_DATE_TIME ),
            price.getEndDate().format( DateTimeFormatter.ISO_OFFSET_DATE_TIME ), price.getCost() );
    }
}
