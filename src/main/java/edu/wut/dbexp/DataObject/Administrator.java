package edu.wut.dbexp.DataObject;

/**
 * @author wenka
 * @date 2021/5/218:03
 */
public class Administrator {
    private String userName;
    private Integer id;
    private String phoneNumber;
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Administrator() {
    }

    public Administrator(String userName, Integer id, String phoneNumber, String userPwd) {
        this.userName = userName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userPwd = userPwd;
    }
}

