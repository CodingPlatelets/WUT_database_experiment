package edu.wut.dbexp.DataObject;

/**
 * @author wenka
 * @date 2021/5/218:03
 */
public class Administrator {
    private String userName;
    private Integer id;
    private String phoneNumber;

    public Administrator(String userName, Integer id, String phoneNumber) {
        this.userName = userName;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

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

    @Override
    public String toString() {
        return "管理员{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

