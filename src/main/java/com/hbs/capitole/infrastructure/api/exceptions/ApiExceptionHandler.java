package com.hbs.capitole.infrastructure.api.exceptions;

import com.hbs.capitole.infrastructure.api.exceptions.dtos.ApiErrorDto;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Component
@Order( Ordered.HIGHEST_PRECEDENCE )
public class ApiExceptionHandler extends AbstractErrorWebExceptionHandler {
    public ApiExceptionHandler( ErrorAttributes errorAttributes, ApplicationContext applicationContext,
        ServerCodecConfigurer serverCodecConfigurer ) {
        super( errorAttributes, new WebProperties.Resources(), applicationContext );
        super.setMessageWriters( serverCodecConfigurer.getWriters() );
        super.setMessageReaders( serverCodecConfigurer.getReaders() );
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction( ErrorAttributes errorAttributes ) {
        return RouterFunctions.route( RequestPredicates.all(), this :: renderErrorResponse );
    }

    private Mono<ServerResponse> renderErrorResponse( final ServerRequest request ) {
        Throwable error = getError( request );
        if( error instanceof ApiException apiException ) {
            return buildApiError( apiException.getStatus(), apiException.getCode(), apiException );
        }
        return buildApiError( null, null, error );
    }

    private Mono<ServerResponse> buildApiError( HttpStatus status, String code, Throwable ex ) {
        ApiErrorDto apiErrorDto = new ApiErrorDto( status, code, ex );
        return ServerResponse.status( apiErrorDto.getStatus() ).bodyValue( apiErrorDto );
    }
}
