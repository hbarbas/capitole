package com.hbs.capitole.application.mappers;

import com.hbs.capitole.application.dtos.PriceDto;
import com.hbs.capitole.domain.models.Price;

public interface PriceDtoMapper {
    PriceDto fromDomainModelToApplicationDto( Price price );
}
