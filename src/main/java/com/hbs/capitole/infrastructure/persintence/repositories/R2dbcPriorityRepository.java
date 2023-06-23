package com.hbs.capitole.infrastructure.persintence.repositories;

import com.hbs.capitole.infrastructure.persintence.entities.PriorityEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R2dbcPriorityRepository extends R2dbcRepository<PriorityEntity, Integer> {
}
