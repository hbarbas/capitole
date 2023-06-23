package com.hbs.capitole.infrastructure.persintence.entities;

import com.hbs.capitole.domain.models.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Table( "PRICES" )
public class PriceEntity {
    @Id
    @Column( "ID" )
    private Long id;
    @Column( "BRAND_ID" )
    private Long brandId;
    @Column( "START_DATE" )
    private OffsetDateTime startDate;
    @Column( "END_DATE" )
    private OffsetDateTime endDate;
    @Column( "PRICE_LIST_ID" )
    private Long priceListId;
    @Column( "PRODUCT_ID" )
    private Long productId;
    @Column( "PRIORITY_ID" )
    private Integer priorityId;
    @Column( "COST" )
    private BigDecimal cost;
    @Column( "CURRENT_ID" )
    private Integer currencyId;

    public PriceEntity() {
    }

    public PriceEntity( Long id, Long brandId, OffsetDateTime startDate, OffsetDateTime endDate, Long priceListId,
        Long productId,
        Integer priorityId, BigDecimal cost, Integer currencyId ) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceListId = priceListId;
        this.productId = productId;
        this.priorityId = priorityId;
        this.cost = cost;
        this.currencyId = currencyId;
    }

    public static Price toDomainModel( PriceEntity priceEntity, Brand brand, PriceList priceList, Product product,
        Priority priority, Currency currency ) {
        return new Price.Builder()
            .id( priceEntity.getId() )
            .brand( brand )
            .startDate( priceEntity.getStartDate() )
            .endDate( priceEntity.getEndDate() )
            .priceList( priceList )
            .product( product )
            .priority( priority )
            .price( priceEntity.getCost() )
            .currency( currency )
            .build();
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId( Long brandId ) {
        this.brandId = brandId;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate( OffsetDateTime startDate ) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceListId() {
        return priceListId;
    }

    public void setPriceListId( Long priceListId ) {
        this.priceListId = priceListId;
    }

    public void setEndDate( OffsetDateTime endDate ) {
        this.endDate = endDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId( Long productId ) {
        this.productId = productId;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId( Integer priorityId ) {
        this.priorityId = priorityId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost( BigDecimal cost ) {
        this.cost = cost;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId( Integer currencyId ) {
        this.currencyId = currencyId;
    }
}
