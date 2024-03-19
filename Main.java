package com.company;

public class Main {
    public static void main(String[] args) {
        // komuter tidak memiliki parameter namun nama kereta dan jumlah tiket ada di constructor.
        Kereta komuter = new Kereta();
        komuter.tambahTiket("Fadil Kotlin");
        komuter.tambahTiket("Fajar Dart");
        komuter.tambahTiket("Saiful HTML");
        komuter.tampilkanTiket();

        System.out.println();

        // KAJJ memiliki parameter nama kereta dan jumlah tiket tersedia.
        Kereta KAJJ = new Kereta("Jayabaya", 2);
        KAJJ.tambahTiket("Aang", "Malang", "Surabaya Gubeng");
        KAJJ.tambahTiket("Zuko", "Malang", "Sidoarjo");
        KAJJ.tambahTiket("Kora", "Malang", "Surabaya Pasarturi");
        KAJJ.tampilkanTiket();
    }
}
