package edu.wut.dbexp.DataObject;

import java.sql.Timestamp;

public class Good {
    private String goodId;
    private Integer goodAttributes;
    private Timestamp saleDate;
    private Boolean isSale;

    public Good(String goodId, Integer goodAttributes, Timestamp saleDate, boolean isSale) {
        this.goodId = goodId;
        this.goodAttributes = goodAttributes;
        this.saleDate = saleDate;
        this.isSale = isSale;
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

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId='" + goodId + '\'' +
                ", goodAttributes=" + goodAttributes +
                ", saleDate=" + saleDate +
                ", isSale=" + isSale +
                '}';
    }
}
