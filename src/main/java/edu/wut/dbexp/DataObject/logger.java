package edu.wut.dbexp.DataObject;

public class logger {
    private String goodId;
    private String userId;

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

    @Override
    public String toString() {
        return "logger{" +
                "goodId='" + goodId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
