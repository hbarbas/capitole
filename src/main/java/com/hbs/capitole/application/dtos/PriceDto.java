package com.hbs.capitole.application.dtos;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceDto {
    private Long productId;
    private Long brandId;
    private String priceList;
    private String startDate;
    private String endDate;
    private BigDecimal cost;

    public PriceDto() {
    }

    public PriceDto( Long productId, Long brandId, String priceList, String startDate, String endDate,
        BigDecimal cost ) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId( Long productId ) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId( Long brandId ) {
        this.brandId = brandId;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList( String priceList ) {
        this.priceList = priceList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate( String startDate ) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate( String endDate ) {
        this.endDate = endDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost( BigDecimal cost ) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "PriceDto{" +
            "productId=" + productId +
            ", brandId=" + brandId +
            ", priceList='" + priceList + '\'' +
            ", startDate='" + startDate + '\'' +
            ", endDate='" + endDate + '\'' +
            ", cost=" + cost +
            '}';
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) {
            return true;
        }
        if( ! ( o instanceof PriceDto priceDto ) ) {
            return false;
        }
        return Objects.equals( getProductId(), priceDto.getProductId() ) &&
            Objects.equals( getBrandId(), priceDto.getBrandId() ) &&
            Objects.equals( getPriceList(), priceDto.getPriceList() ) &&
            Objects.equals( getStartDate(), priceDto.getStartDate() ) &&
            Objects.equals( getEndDate(), priceDto.getEndDate() ) &&
            Objects.equals( getCost(), priceDto.getCost() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getProductId(), getBrandId(), getPriceList(), getStartDate(), getEndDate(), getCost() );
    }
}
