package edu.wut.dbexp.DataObject;

import java.util.Date;

/**
 * @author wenka
 * @date 2021/5/219:00
 */
public class Goods {
    private Integer goodAttributes;
    private Integer stock;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodAttributes=" + goodAttributes +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }
}

