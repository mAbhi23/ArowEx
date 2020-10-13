package com.example.arowex;



public class Market {
    private String name;
    private String price;
    private String btntext;

    public Market(String name, String price, String btntext) {
        this.name = name;
        this.price = price;
        this.btntext = btntext;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getBtnText() {
        return btntext;
    }

    public void setName() {
        this.name = name;
    }
    public void setPrice() {
        this.price = price;
    }
    public void setBtntext() {
        this.btntext = btntext;
    }
}