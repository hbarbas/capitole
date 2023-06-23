package com.hbs.capitole.infrastructure.config;

import com.hbs.capitole.application.mappers.PriceDtoMapper;
import com.hbs.capitole.application.services.PriceService;
import com.hbs.capitole.application.usecases.PriceUseCasesImpl;
import com.hbs.capitole.domain.ports.out.PriceRepository;
import com.hbs.capitole.infrastructure.persintence.repositories.adapters.R2dbcPriceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
public class ApplicationConfig {
    @Bean
    public PriceService priceService( PriceRepository priceRepository ) {
        return new PriceService(
            new PriceUseCasesImpl( priceRepository ),
            new PriceDtoMapper() );
    }

    @Bean
    public PriceRepository priceRepository( R2dbcPriceRepositoryAdapter r2dbcPriceRepositoryAdapter ) {
        return r2dbcPriceRepositoryAdapter;
    }

    @Bean
    CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin( "*" );
        corsConfig.addAllowedHeader( "*" );
        corsConfig.addAllowedMethod( "*" );
        return new CorsWebFilter( source -> corsConfig );
    }
}
