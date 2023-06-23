package com.hbs.capitole.infrastructure.persintence.entities;

import com.hbs.capitole.domain.models.Priority;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table( "PRIORITIES" )
public class PriorityEntity {
    @Id
    @Column( "ID" )
    private Integer id;
    @Column( "NAME" )
    private String name;

    public PriorityEntity() {
    }

    public PriorityEntity( Integer id, String name ) {
        this.id = id;
        this.name = name;
    }

    public static Priority toDomainModel( PriorityEntity priorityEntity ) {
        return Priority.valueOf( priorityEntity.getName() );
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}


