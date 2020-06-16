package com.example.myfireapptest;

public class Request {

    private String name;
    private String mobile;
    private String address;
    private String whyNeed;
    private String radioValue;
    private String spinnerValue;
    private String amountSpinnerValue;


    //Creating Constructor


    public Request(){

    }


    public Request(String name, String mobile, String address, String whyNeed, String radioValue, String spinnerValue, String amountSpinnerValue) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.whyNeed = whyNeed;
        this.radioValue = radioValue;
        this.spinnerValue = spinnerValue;
        this.amountSpinnerValue = amountSpinnerValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWhyNeed() {
        return whyNeed;
    }

    public void setWhyNeed(String whyNeed) {
        this.whyNeed = whyNeed;
    }

    public String getRadioValue() {
        return radioValue;
    }

    public void setRadioValue(String radioValue) {
        this.radioValue = radioValue;
    }

    public String getSpinnerValue() {
        return spinnerValue;
    }

    public void setSpinnerValue(String spinnerValue) {
        this.spinnerValue = spinnerValue;
    }

    public String getAmountSpinnerValue() {
        return amountSpinnerValue;
    }

    public void setAmountSpinnerValue(String amountSpinnerValue) {
        this.amountSpinnerValue = amountSpinnerValue;
    }
}
