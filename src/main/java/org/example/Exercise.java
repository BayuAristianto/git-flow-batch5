package org.example;

public class Exercise {
    public static void main(String[] args){
        System.out.println("=== TOKO BUAH PAK DADANG ===\n");

        //Test case 1 : Apel
        double total1 = hitungTotalBelanja("Apel", 25000, 2.5);
        System.out.println();
        //Test case 2 : Jeruk
        double total2 = hitungTotalBelanja("Jeruk", 20000, 3.0);
        System.out.println();
        //Test case 3 : Mangga
        double total3 = hitungTotalBelanja("Mangga", 30000, 1.5);
        System.out.println();
    }

    public static double hitungTotalBelanja(String namaBuah, int hargaPerKg, double beratKg){
        double totalHarga = hargaPerKg * beratKg;

        System.out.println("Buah: " + namaBuah);
        System.out.println("Harga per kg: " + hargaPerKg);
        System.out.println("Berat: " + beratKg + " kg");
        System.out.println("------------------------------");
        System.out.println("Total: Rp."+totalHarga);

        return totalHarga;
    }
}
