package com.hbs.capitole.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Price {
    private final Long id;
    private final Brand brand;
    private final OffsetDateTime startDate;
    private final OffsetDateTime endDate;
    private final PriceList priceList;
    private final Product product;
    private final Priority priority;
    private final BigDecimal cost;
    private final Currency currency;

    private Price( Builder builder ) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.priceList = builder.priceList;
        this.product = builder.product;
        this.priority = builder.priority;
        this.cost = builder.price;
        this.currency = builder.currency;
    }

    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public Product getProduct() {
        return product;
    }

    public Priority getPriority() {
        return priority;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static class Builder {
        private Long id;
        private Brand brand;
        private OffsetDateTime startDate;
        private OffsetDateTime endDate;
        private PriceList priceList;
        private Product product;
        private Priority priority;
        private BigDecimal price;
        private Currency currency;

        public Builder id( Long id ) {
            this.id = id;
            return this;
        }

        public Builder brand( Brand brand ) {
            this.brand = brand;
            return this;
        }

        public Builder startDate( OffsetDateTime startDate ) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate( OffsetDateTime endDate ) {
            this.endDate = endDate;
            return this;
        }

        public Builder priceList( PriceList priceList ) {
            this.priceList = priceList;
            return this;
        }

        public Builder product( Product product ) {
            this.product = product;
            return this;
        }

        public Builder priority( Priority priority ) {
            this.priority = priority;
            return this;
        }

        public Builder price( BigDecimal price ) {
            this.price = price;
            return this;
        }

        public Builder currency( Currency currency ) {
            this.currency = currency;
            return this;
        }

        public Price build() {
            return new Price( this );
        }
    }

    @Override public String toString() {
        return "Price{" +
            "id=" + id +
            ", brand=" + brand +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", priceList=" + priceList +
            ", product=" + product +
            ", priority=" + priority +
            ", cost=" + cost +
            ", currency=" + currency +
            '}';
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) {
            return true;
        }
        if( ! ( o instanceof Price price ) ) {
            return false;
        }
        return Objects.equals( getId(), price.getId() ) &&
            Objects.equals( getBrand(), price.getBrand() ) &&
            Objects.equals( getStartDate(), price.getStartDate() ) &&
            Objects.equals( getEndDate(), price.getEndDate() ) &&
            Objects.equals( getPriceList(), price.getPriceList() ) &&
            Objects.equals( getProduct(), price.getProduct() ) && getPriority() == price.getPriority() &&
            Objects.equals( getCost(), price.getCost() ) && getCurrency() == price.getCurrency();
    }

    @Override
    public int hashCode() {
        return Objects.hash( getId(), getBrand(), getStartDate(), getEndDate(), getPriceList(), getProduct(),
            getPriority(),
            getCost(), getCurrency() );
    }
}
