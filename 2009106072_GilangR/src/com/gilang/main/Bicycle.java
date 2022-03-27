package com.gilang.main;

public class Bicycle {
    private String name;
    private String color;
    private int distance = 0;

    public Bicycle(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Bicycle(String name, String color, int distance) {
        this(name,color);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printData(){
        System.out.println("【Info Sepeda】");
        System.out.println("Nama: "+this.name);
        System.out.println("Warna: "+this.color);
        System.out.println("Jarak: "+this.distance+"km");
    }

    public void run(int distance){
        this.distance += distance;
        System.out.println("Bergerak "+distance+"km ...");
        System.out.println("Jarak: "+this.distance+"km");
    }
}
