package com.hbs.capitole.domain.models;

import java.util.Objects;

public class Product {
    private final Long id;
    private final String name;

    private Product( Long id, String name ) {
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

        public Product.Builder id( Long id ) {
            this.id = id;
            return this;
        }

        public Product.Builder name( String name ) {
            this.name = name;
            return this;
        }

        public Product build() {
            return new Product( id, name );
        }
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) {
            return true;
        }
        if( ! ( o instanceof Product product ) ) {
            return false;
        }
        return Objects.equals( getId(), product.getId() ) &&
            Objects.equals( getName(), product.getName() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getId(), getName() );
    }
}
