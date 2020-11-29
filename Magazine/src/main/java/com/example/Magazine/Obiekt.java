package com.example.Magazine;

public class Obiekt {
    private String marka;
    private String model;

    public Obiekt(String marka, String model){
        this.marka = marka;
        this.model = model;
    }

    public Obiekt() { }

    public String getMarka(){
        return marka;
    }
    public String getModel(){
        return model;
    }

    public void setMarka(String marka){
        this.marka = marka;
    }
    public void setModel(String model){
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
