package com.hbs.capitole.infrastructure.persintence.entities;

import com.hbs.capitole.domain.models.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table( "PRODUCTS" )
public class ProductEntity {
    @Id
    @Column( "ID" )
    private Long id;
    @Column( "NAME" )
    private String name;

    public ProductEntity() {
    }

    public ProductEntity( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public static Product toDomainModel( ProductEntity productEntity ) {
        return new Product.Builder()
            .id( productEntity.getId() )
            .name( productEntity.getName() )
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



