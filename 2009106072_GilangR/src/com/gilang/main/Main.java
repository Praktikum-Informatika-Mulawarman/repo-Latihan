package com.gilang.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        // Atur nama mobil menjadi "Ferrari" menggunakan method `setName`
        car.setName("Ferrari");

        // Atur warna dari mobil menjadi "Merah" menggunakan method `setColor`
        car.setColor("Merah");

        Bicycle bicycle = new Bicycle();
        // Atur nama dari sepeda menjadi "Bianchi" menggunakan method `setName`
        bicycle.setName("Bianchi");


        // Atur warna dari sepeda menjadi "Hijau" menggunakan method `setColor`
        bicycle.setColor("Hijau");

        System.out.println("【Info Mobil】");
        car.printData();

        System.out.println("=================");
        System.out.println("【Info Sepeda】");
        bicycle.printData();
        Scanner scanner = new Scanner(System.in);
        Bicycle bicycle = new Bicycle("Bianchi", "Hijau", 0);
        bicycle.printData();
        System.out.println("-----------------");
        System.out.print("Masukkan jarak yang akan ditempuh: ");
        bicycle.run(scanner.nextInt());
        System.out.println("=================");
        Car car = new Car("Ferrari", "Merah", 100);
        car.printData();
        System.out.println("-----------------");
        System.out.print("Masukkan jarak yang akan ditempuh: ");
        car.run(scanner.nextInt());
        System.out.println("-----------------");
        System.out.print("Masukkan jumlah isi ulang bahan bakar: ");
        car.charge(scanner.nextInt());
    }
}
