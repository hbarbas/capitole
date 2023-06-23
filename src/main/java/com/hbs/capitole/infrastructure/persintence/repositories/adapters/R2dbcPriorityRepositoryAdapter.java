package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Priority;
import com.hbs.capitole.infrastructure.persintence.entities.PriorityEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcPriorityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class R2dbcPriorityRepositoryAdapter {
    private static final Logger log = LoggerFactory.getLogger( R2dbcPriorityRepositoryAdapter.class );
    private final R2dbcPriorityRepository r2dbcPriorityRepository;

    public R2dbcPriorityRepositoryAdapter( R2dbcPriorityRepository r2dbcPriorityRepository ) {
        this.r2dbcPriorityRepository = r2dbcPriorityRepository;
    }

    public Mono<Priority> getPriority( Integer priority ) {
        log.info( "Find the priority, id: {}", priority );
        return r2dbcPriorityRepository.findById( priority ).map( PriorityEntity :: toDomainModel );
    }
}
