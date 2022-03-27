package com.gilang.main;

public class Car extends Bicycle {
    private int fuel;


    public Car(String name, String color, int fuel) {
        super(name, color);
        this.fuel = fuel;
    }

    public Car(String name, String color, int distance, int fuel) {
        super(name, color, distance);
        this.fuel = fuel;
    }

    @Override
    public void printData() {
        System.out.println("【Info Mobil】");
        System.out.println("Nama: " + super.getName());
        System.out.println("Warna: " + this.getColor());
        System.out.println("Jarak: " + this.getDistance() + "km");
        System.out.println("Bahan Bakar: " + fuel + "L");
    }

    @Override
    public void run(int distance) {
        System.out.println("Bergerak " + distance + "km ...");
        if (distance >= fuel) {
            System.out.println("Bahan bakar tidak cukup");
            distance = 0;
        } else {
            fuel -= distance;
        }
        System.out.println("Jarak: " + distance + "km");
        System.out.println("Bahan Bakar: " + this.fuel + "L");
    }

    public void charge(int amount) {
        System.out.println("Menambahkan " + amount + "L ...");
        if (amount <= 0) {
            System.out.println("Tidak ada bahan bakar tertambahkan");
        } else if (amount + fuel >= 100) {
            System.out.println("Sekarang tangki penuh");
            fuel = 100;
        } else {
            fuel += amount;
        }
        System.out.println("Bahan Bakar: " + this.fuel + "L");
    }
}
