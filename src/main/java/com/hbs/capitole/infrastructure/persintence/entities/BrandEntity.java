package com.hbs.capitole.infrastructure.persintence.entities;

import com.hbs.capitole.domain.models.Brand;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table( "BRANDS" )
public class BrandEntity {
    @Id
    @Column( "ID" )
    private Long id;
    @Column( "NAME" )
    private String name;

    public BrandEntity() {
    }

    public BrandEntity( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public static Brand toDomainModel( BrandEntity brandEntity ) {
        return new Brand.Builder()
            .id( brandEntity.getId() )
            .name( brandEntity.getName() )
            .build();
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}

