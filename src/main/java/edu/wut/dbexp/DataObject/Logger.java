package edu.wut.dbexp.DataObject;

public class logger {
    private String goodId;
    private String userId;
    private Double price;

    public logger(String goodId, String userId, Double price) {
        this.goodId = goodId;
        this.userId = userId;
        this.price = price;
    }

    public logger() {
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "logger{" +
                "goodId='" + goodId + '\'' +
                ", userId='" + userId + '\'' +
                ", price=" + price +
                '}';
    }
}
