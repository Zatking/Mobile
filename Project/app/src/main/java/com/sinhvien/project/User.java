package com.sinhvien.project;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String userName;
    private String email;
    private String phoneNumber;
    private String address;
    private String  sex;
    private Date birthDay;
    public User(String userName, String mail, String number, String address, String nam, String date) {
    }
    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public User(String userName, String email, String phoneNumber, String address, String sex, Date birthDay) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sex = sex;
        this.birthDay = birthDay;
    }



}
