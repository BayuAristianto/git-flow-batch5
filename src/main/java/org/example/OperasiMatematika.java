package org.example;

public class OperasiMatematika {
    public static void main(String[] args) {
        System.out.println("===== TEST OPERASI INTEGER =====\n");

        testPenjumlahan();
        testPengurangan();
        testPerkalian();
        testPembagian();
        //testSisaBagi();

        System.out.println("\n===== TEST INTEGER SELESAI! =====");
    }

    public static void testPenjumlahan() {
        System.out.println("TEST PENJUMLAHAN:");

        int hasil1 = BaseKalkulator.tambah(10, 5);
        System.out.println("  10 + 5 = " + hasil1);

        int hasil2 = BaseKalkulator.tambah(100, 50);
        System.out.println("  100 + 50 = " + hasil2);

        int hasil3 = BaseKalkulator.tambah(-10, 5);
        System.out.println("  -10 + 5 = " + hasil3);

        System.out.println();
    }

    public static void testPengurangan() {
        System.out.println("TEST PENGURANGAN:");

        int hasil1 = BaseKalkulator.kurang(10, 5);
        System.out.println("  10 - 5 = " + hasil1);

        int hasil2 = BaseKalkulator.kurang(100, 50);
        System.out.println("  100 - 50 = " + hasil2);

        int hasil3 = BaseKalkulator.kurang(-10, 5);
        System.out.println("  -10 - 5 = " + hasil3);

        System.out.println();
    }

    public static void testPerkalian(){
        System.out.println("TEST PERKALIAN: ");

        int hasil1 = BaseKalkulator.kali(5, 10);
        System.out.println(" 10 x 5 = " + hasil1);

        int hasil2 = BaseKalkulator.kali(12, 0);
        System.out.println(" 12 x 0 = " +hasil2);

        System.out.println();
    }

    public static void testPembagian(){
        System.out.println("TEST PEMBAGIAN: ");

        int hasil1 = BaseKalkulator.bagi(10,5);
        System.out.println(" 10 / 5 = " + hasil1);

        int hasil2 = BaseKalkulator.bagi(12,3);
        System.out.println(" 12 / 3 = " + hasil2);

        System.out.println();
    }



}
