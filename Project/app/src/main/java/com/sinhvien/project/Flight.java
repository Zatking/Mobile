package com.sinhvien.project;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Flight implements Serializable {
    public Flight(String code, String arrivalPlace,String departPlace, String state,  String dateDepart, Integer price,String time,String namePlane) {
        Code = code;
        ArrivalPlace = arrivalPlace;
        State = state;
        DepartPlace = departPlace;
        DateDepart = dateDepart;
        Price = price;
        Time =time;
        NamePlane=namePlane;
    }

    public Flight() {
    }

    String Code;
    String ArrivalPlace;
    String State;
    String DepartPlace;
    String DateDepart;
    String Time;

    public String getNamePlane() {
        return NamePlane;
    }

    public void setNamePlane(String namePlane) {
        NamePlane = namePlane;
    }

    String NamePlane;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    Integer Price;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getArrivalPlace() {
        return ArrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        ArrivalPlace = arrivalPlace;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getDepartPlace() {
        return DepartPlace;
    }

    public void setDepartPlace(String departPlace) {
        DepartPlace = departPlace;
    }

    public String getDateDepart() {
        return DateDepart;
    }

    public void setDateDepart(String  dateDepart) {
        DateDepart = dateDepart;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }





    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("Code",Code);
        result.put("DateDepart",DateDepart);
        result.put("DepartPlace",DepartPlace);
        result.put("ArrivalPlace",ArrivalPlace);
        result.put("State",State);

        return result;

    }
}