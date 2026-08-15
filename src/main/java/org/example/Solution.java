package org.example;

public class Solution {
    // 1. Method hitungTotal dengan 1 parameter
    public static double hitungTotal(double harga) {
        // Tulis kode di sini
        return harga;
    }
    // 2. Method hitungTotal dengan 2 parameter
    public static double hitungTotal(double harga, double persentaseDiskon) {
        // Tulis kode di sini
        double hargaDiskon = harga - (harga * persentaseDiskon);
        return hargaDiskon;
    }
    // 3. Method hitungTotal dengan 3 parameter
    public static double hitungTotal(double harga, double persentaseDiskon, double ongkir) {
        // Tulis kode di sini
        double hargaOngkir = (harga - (harga * persentaseDiskon)) + ongkir;
        return hargaOngkir;
    }

    public static int hitungBiayaParkir(int lamaParkir, boolean isVIP){
        int harga = 5000;
        int hargaBerikutnya = 3000;
        int totalBiayaAkhir = harga + (lamaParkir * hargaBerikutnya);
        if (lamaParkir <= 0) {
            return -1;
        }
        if(isVIP) {
            totalBiayaAkhir = totalBiayaAkhir - 5000;
        }
        return totalBiayaAkhir;
    }

    // Method 1: Default ke Fahrenheit
    public static double konversiSuhu(double celsius) {
        // Tulis kode di sini
        double suhuFahrenheit = (celsius * 9/5) + 32;
        return suhuFahrenheit;
    }
    // Method 2: Fleksibel pilihan unit (F/K)
    public static double konversiSuhu(double celsius, String targetUnit) {
        // Tulis kode di sini
        double suhuFahrenheit = (celsius * 9/5) + 32;
        double suhuKelvin = celsius + 273.15;
        if (targetUnit.toUpperCase().equals("F")){
            return suhuFahrenheit;
        }else if (targetUnit.toUpperCase().equals("K")){
            return suhuKelvin;
        }else{
            return -999.0;
        }
    }

    public static double hitungKalori(String jenisOlahraga, int durasiMenit, double beratBadan) {
        // Tulis kode kamu di sini
        double lari = 0.14;
        double berenang = 0.10;
        double berjalan = 0.05;
        double totalKalori = 0.0;

        if(jenisOlahraga.equalsIgnoreCase("lari") && durasiMenit > 0 && beratBadan > 0){
            totalKalori = lari * durasiMenit * beratBadan;
            return totalKalori;
        } else if (jenisOlahraga.equalsIgnoreCase("berenang") && durasiMenit > 0 && beratBadan > 0) {
            totalKalori = berenang * durasiMenit * beratBadan;
            return totalKalori;
        }else if (jenisOlahraga.equalsIgnoreCase("berjalan") && durasiMenit > 0 && beratBadan > 0){
            totalKalori = berjalan * durasiMenit * beratBadan;
            return totalKalori;
        }else{
            return -1;
        }
    }



    public static void main(String[] args) {
        System.out.println("===========Harga Barang===========");
        System.out.println("Harga Barang : " + hitungTotal(10000.0));
        System.out.println("Harga Diskon Barang : " + hitungTotal(10000.0, 0.2));
        System.out.println("Harga Diskon dan Ongkir : " + hitungTotal(10000.0, 0.2, 2000));

        System.out.println("===========Harga Parkir==========");
        System.out.println("Harga Parkir : " + hitungBiayaParkir(3,false));
        System.out.println("Harga Parkir : " + hitungBiayaParkir(3,true));
        System.out.println("Harga Parkir : " + hitungBiayaParkir(0,false));

        System.out.println("===========Konversi Suhu==========");
        System.out.println("Konversi Suhu : " + konversiSuhu(25.0));
        System.out.println("Konversi ke Kelvin : " + konversiSuhu(50.0,"k"));
        System.out.println("Konversi ke Fahrenheit : " + konversiSuhu(35.0,"f"));
        System.out.println("Konversi ke Lainnya : " + konversiSuhu(20.0,"X"));

        System.out.println("===========Fitness Calories Burned==========");
        System.out.println("Kalori yang terbakar : " + hitungKalori("Lari",30,60.0));
        System.out.println("Kalori yang terbakar : " + hitungKalori("Berenang",45,70.0));
        System.out.println("Kalori yang terbakar : " + hitungKalori("Berjalan",60,60.0));
        System.out.println("Kalori yang terbakar : " + hitungKalori("Yoga",30,50.0)); // harusnya -1 (jenisOlahraga tidak terdaftar)
        System.out.println("Kalori yang terbakar : " + hitungKalori("LaRi",0,60.0)); // harusnya -1 ( durasi 0 )
        System.out.println("Kalori yang terbakar : " + hitungKalori("BeRjaLan",30,0.0)); // harusnya -1 ( bb 0)
        System.out.println("Kalori yang terbakar : " + hitungKalori("Berenang",0,0.0)); // harusnya -1 (durasi & bb 0
        System.out.println("Kalori yang terbakar : " + hitungKalori("Yoga",25,65.0)); // harusnya -1 (jenisOlahraga tidak terdaftar)


    }


}
