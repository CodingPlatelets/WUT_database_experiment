package edu.wut.dbexp.DataObject;

import java.util.Date;

/**
 * @author wenka
 * @date 2021/5/219:00
 */
public class Goods {
    private Integer goodAttributes;
    private String id;
    private Integer stock;
    private String description;
    private Date inStockDate;

    public Goods(Integer goodAttributes, String id, Integer stock, String description, Date inStockDate) {
        this.goodAttributes = goodAttributes;
        this.id = id;
        this.stock = stock;
        this.description = description;
        this.inStockDate = inStockDate;
    }

    public Integer getGoodAttributes() {
        return goodAttributes;
    }

    public void setGoodAttributes(Integer goodAttributes) {
        this.goodAttributes = goodAttributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getInStockDate() {
        return inStockDate;
    }

    public void setInStockDate(Date inStockDate) {
        this.inStockDate = inStockDate;
    }
}

