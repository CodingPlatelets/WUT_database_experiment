package edu.wut.dbexp.DataObject;

import java.util.Date;

/**
 * @author wenka
 * @date 2021/5/219:00
 */
public class Goods {
    private Integer goodAttributes;
    private Integer stock;
    private double originPrice;
    private String description;

    public Goods(Integer goodAttributes, Integer stock, double originPrice, String description) {
        this.goodAttributes = goodAttributes;
        this.stock = stock;
        this.originPrice = originPrice;
        this.description = description;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodAttributes=" + goodAttributes +
                ", stock=" + stock +
                ", originPrice=" + originPrice +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getGoodAttributes() {
        return goodAttributes;
    }

    public void setGoodAttributes(Integer goodAttributes) {
        this.goodAttributes = goodAttributes;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

