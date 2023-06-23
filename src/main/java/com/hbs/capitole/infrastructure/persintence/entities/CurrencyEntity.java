package com.hbs.capitole.infrastructure.persintence.entities;

import com.hbs.capitole.domain.models.Currency;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table( "CURRENCIES" )
public class CurrencyEntity {
    @Id
    @Column( "ID" )
    private Integer id;
    @Column( "NAME" )
    private String name;
    @Column( "ISO" )
    private String iso;

    public CurrencyEntity() {
    }

    public CurrencyEntity( Integer id, String name, String iso ) {
        this.id = id;
        this.name = name;
        this.iso = iso;
    }

    public static Currency toDomainModel( CurrencyEntity currencyEntity ) {
        return Currency.valueOf( currencyEntity.getIso() );
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

    public String getIso() {
        return iso;
    }

    public void setIso( String iso ) {
        this.iso = iso;
    }
}

