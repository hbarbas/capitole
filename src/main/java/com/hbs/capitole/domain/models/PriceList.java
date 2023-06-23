package com.hbs.capitole.domain.models;

import java.util.Objects;

public class PriceList {
    private final Long id;
    private final String name;

    private PriceList( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private Long id;
        private String name;

        public PriceList.Builder id( Long id ) {
            this.id = id;
            return this;
        }

        public PriceList.Builder name( String name ) {
            this.name = name;
            return this;
        }

        public PriceList build() {
            return new PriceList( id, name );
        }
    }

    @Override
    public String toString() {
        return "PriceList{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) {
            return true;
        }
        if( ! ( o instanceof PriceList priceList ) ) {
            return false;
        }
        return Objects.equals( getId(), priceList.getId() ) && Objects.equals( getName(), priceList.getName() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getId(), getName() );
    }
}
