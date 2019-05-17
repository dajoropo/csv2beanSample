package org.example.csv2bean;

import com.opencsv.bean.CsvBindByName;

public class Bean {

    @CsvBindByName(column = "﻿A")
    private String a;

    @CsvBindByName(column = "B")
    private String b;

    @CsvBindByName(column = "C")
    private String c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Bean [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

}
