package com.example.Magazine;

public class Variables {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }
    @Override
    public String toString() {
        return "Variables{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
