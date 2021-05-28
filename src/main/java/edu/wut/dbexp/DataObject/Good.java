package edu.wut.dbexp.DataObject;

import java.util.Date;

public class Good {
    private String goodId;
    private Integer goodAttributes;
    private Boolean saleStatus;
    private Date saleDate;
    private boolean isSale;
    private double originPrice;

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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
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
}
