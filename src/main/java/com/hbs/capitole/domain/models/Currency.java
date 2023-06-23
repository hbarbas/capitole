package com.hbs.capitole.domain.models;

public enum Currency {
    EUR( "Euro" ),
    USD( "Dólar estadounidense" ),
    GBP( "Libra esterlina" ),
    JPY( "Yen japonés" ),
    CAD( "Dólar canadiense" ),
    AUD( "Dólar australiano" ),
    CHF( "Franco suizo" ),
    MXN( "Peso mexicano" ),
    CNY( "Renminbi chino" ),
    BRL( "Real brasileño" );
    private final String name;

    Currency( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
