package edu.wut.dbexp.DataObject;

import java.sql.Timestamp;

public class Good {
    private String goodId;
    private Integer goodAttributes;
    private Boolean saleStatus;
    private Timestamp saleDate;
    private boolean isSale;
    private double originPrice;

    public Good(String goodId, Integer goodAttributes, Boolean saleStatus, Timestamp saleDate, boolean isSale, double originPrice) {
        this.goodId = goodId;
        this.goodAttributes = goodAttributes;
        this.saleStatus = saleStatus;
        this.saleDate = saleDate;
        this.isSale = isSale;
        this.originPrice = originPrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId='" + goodId + '\'' +
                ", goodAttributes=" + goodAttributes +
                ", saleStatus=" + saleStatus +
                ", saleDate=" + saleDate +
                ", isSale=" + isSale +
                ", originPrice=" + originPrice +
                '}';
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

    public Boolean getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Boolean saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public boolean getIsSale() {
        return isSale;
    }

    public void setIsSale(boolean sale) {
        isSale = sale;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public Good() {
    }
}
