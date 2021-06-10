package edu.wut.dbexp.DataObject;

import java.util.Date;
import java.sql.Timestamp;

public class Good {
    private String goodId;
    private Integer goodAttributes;
    private Timestamp saleDate;
    private Boolean isSale;
    private Boolean canRefund;
    private Double salePrice;

    public Good(String goodId, Integer goodAttributes, Timestamp saleDate, Boolean isSale, Boolean canRefund, Double salePrice) {
        this.goodId = goodId;
        this.goodAttributes = goodAttributes;
        this.saleDate = saleDate;
        this.isSale = isSale;
        this.canRefund = canRefund;
        this.salePrice = salePrice;
    }

    public Good() {
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodAttributes() {
        return goodAttributes;
    }

    public void setGoodAttributes(Integer goodAttributes) {
        this.goodAttributes = goodAttributes;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public Boolean getIsSale() {
        return isSale;
    }

    public void setIsSale(Boolean sale) {
        isSale = sale;
    }

    public Boolean getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Boolean canRefund) {
        this.canRefund = canRefund;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId='" + goodId + '\'' +
                ", goodAttributes=" + goodAttributes +
                ", saleDate=" + saleDate +
                ", isSale=" + isSale +
                ", canRefund=" + canRefund +
                ", salePrice=" + salePrice +
                '}';
    }
}
