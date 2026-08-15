package org.example;

class Mobil { //Object
    String merk; //Attribute
    int tahun; //Attribute

    void nyalakanMesin() { //Methode
        System.out.println(merk + " tahun " + tahun + " siap jalan ");
    }
}

class CetakHuruf extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Huruf: " + c);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class CetakAngka extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Angka: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class Kendaraan {

    public static void main (String[] args){
        Mobil m1 = new Mobil();
        m1.merk = "Honda";
        m1.tahun = 2022;
        m1.nyalakanMesin();

        CetakHuruf t1 = new CetakHuruf();
        CetakAngka t2 = new CetakAngka();

        t1.start(); // Jalankan thread pertama
        t2.start(); // Jalankan thread kedua

    }
}
