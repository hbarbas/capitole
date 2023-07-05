package com.hbs.capitole.infrastructure.persintence.repositories.adapters;

import com.hbs.capitole.domain.models.Priority;
import com.hbs.capitole.infrastructure.persintence.entities.PriorityEntity;
import com.hbs.capitole.infrastructure.persintence.repositories.R2dbcPriorityRepository;
import com.hbs.capitole.utils.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith( MockitoExtension.class )
@DisplayName( "Unit tests for the R2dbcPriorityRepositoryAdapter class" )
class R2dbcPriorityRepositoryAdapterTest {
    @Mock
    private R2dbcPriorityRepository r2dbcPriorityRepository;
    @InjectMocks
    private R2dbcPriorityRepositoryAdapter r2dbcPriorityRepositoryAdapter;

    @Test
    @DisplayName( "Should return the expected priority" )
    void testGetPriority() {
        // Given
        Integer priorityId = 1;
        PriorityEntity priorityEntity = Fixtures.getObject( PriorityEntity.class );
        priorityEntity.setName( "ALTA" );
        Priority priority = Priority.valueOf( priorityEntity.getName() );
        given( r2dbcPriorityRepository.findById( anyInt() ) ).willReturn( Mono.just( priorityEntity ) );
        // When
        Mono<Priority> result = r2dbcPriorityRepositoryAdapter.getPriority( priorityId );
        // Then
        StepVerifier.create( result )
            .expectNext( priority )
            .verifyComplete();
        then( r2dbcPriorityRepository ).should( times( 1 ) ).findById( anyInt() );
    }
}
