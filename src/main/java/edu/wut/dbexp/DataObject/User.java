package edu.wut.dbexp.DataObject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wenka
 * @date 2021/5/219:04
 */
public class User {
    private String id;
    private String userName;
    private int vipStatus;
    private double balance;
    private String phoneNumber;
    private int gender;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", vipStatus=" + vipStatus +
                ", balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                '}';
    }

    public User(String id, String userName, int vipStatus, double balance, String phoneNumber, int gender) {
        this.id = id;
        this.userName = userName;
        this.vipStatus = vipStatus;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(int vipStatus) {
        this.vipStatus = vipStatus;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getGender() { return gender;}

    public void setGender(int gender) { this.gender = gender; }
}



