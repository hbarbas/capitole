package com.hbs.capitole.domain.models;

import java.util.Objects;

public class Brand {
    private final Long id;
    private final String name;

    private Brand( Long id, String name ) {
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

        public Builder id( Long id ) {
            this.id = id;
            return this;
        }

        public Builder name( String name ) {
            this.name = name;
            return this;
        }

        public Brand build() {
            return new Brand( id, name );
        }
    }

    @Override
    public String toString() {
        return "Brand{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) {
            return true;
        }
        if( ! ( o instanceof Brand brand ) ) {
            return false;
        }
        return Objects.equals( getId(), brand.getId() ) && Objects.equals( getName(), brand.getName() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getId(), getName() );
    }
}
