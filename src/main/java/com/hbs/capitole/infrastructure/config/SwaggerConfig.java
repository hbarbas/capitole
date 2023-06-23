package com.hbs.capitole.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
            .info( new Info().title( "Capitole" )
                .version( "v0.0.1" ) );
    }

    @Bean
    public GroupedOpenApi priceGroupApi() {
        return GroupedOpenApi.builder()
            .group( "price" )
            .pathsToMatch( "/api/v1/price/**" )
            .build();
    }
}
