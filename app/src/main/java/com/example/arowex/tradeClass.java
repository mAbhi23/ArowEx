package com.example.arowex;



public class tradeClass {
    private String t1buy;
    private String t1amount;
    private String t1price;


    public tradeClass(String t1buy, String t1amount, String t1price) {
        this.t1buy = t1buy;
        this.t1amount = t1amount;
        this.t1price = t1price;

    }

    public String getT1buy() {
        return t1buy;
    }

    public String getT1amount() {
        return t1amount;
    }

    public String getT1price() {
        return t1price;
    }

    public void setT1buy() {
        this.t1buy = t1buy;
    }
    public void setT1amount() {
        this.t1amount = t1amount;
    }
    public void setT1price() {
        this.t1price = t1price;
    }



}