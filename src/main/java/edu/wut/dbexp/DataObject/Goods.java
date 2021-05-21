package edu.wut.dbexp.DataObject;

import java.util.Date;

/**
 * @author wenka
 * @date 2021/5/219:00
 */
public class Goods {
    private Integer goodAttributes;
    private String goodsId;
    private Integer stock;
    private String description;
    private Boolean saleStatus;
    private Date saleDate;
    private Boolean isReturnAvailable;

    public Goods(Integer goodAttributes, String goodsId, Integer stock, String description, Boolean saleStatus, Date saleDate, Boolean isReturnAvailable) {
        this.goodAttributes = goodAttributes;
        this.goodsId = goodsId;
        this.stock = stock;
        this.description = description;
        this.saleStatus = saleStatus;
        this.saleDate = saleDate;
        this.isReturnAvailable = isReturnAvailable;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodAttributes=" + goodAttributes +
                ", goodsId='" + goodsId + '\'' +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", saleStatus=" + saleStatus +
                ", saleDate=" + saleDate +
                ", isReturnAvailable=" + isReturnAvailable +
                '}';
    }

    public Integer getGoodAttributes() {
        return goodAttributes;
    }

    public void setGoodAttributes(Integer goodAttributes) {
        this.goodAttributes = goodAttributes;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getReturnAvailable() {
        return isReturnAvailable;
    }

    public void setReturnAvailable(Boolean returnAvailable) {
        isReturnAvailable = returnAvailable;
    }
}

