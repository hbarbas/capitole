package com.hbs.capitole.domain.models;

public enum Priority {
    BAJA( "Baja" ),
    ALTA( "Alta" );
    private final String name;

    Priority( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
