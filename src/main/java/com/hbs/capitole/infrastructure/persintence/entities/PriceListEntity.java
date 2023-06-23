package com.hbs.capitole.infrastructure.persintence.entities;

import com.hbs.capitole.domain.models.PriceList;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table( "PRICE_LIST" )
public class PriceListEntity {
    @Id
    @Column( "ID" )
    private Long id;
    @Column( "NAME" )
    private String name;

    public PriceListEntity() {
    }

    public PriceListEntity( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public static PriceList toDomainModel( PriceListEntity priceListEntity ) {
        return new PriceList.Builder()
            .id( priceListEntity.getId() )
            .name( priceListEntity.getName() )
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

