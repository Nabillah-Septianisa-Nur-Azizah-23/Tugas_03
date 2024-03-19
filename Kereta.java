package com.company;

public class Kereta {

        private String namaKereta; /* menyimpaan jenis kereta api */
        private int jumlahTiketTersedia; /* menyimpan jumlah tiket yang tersedia / sudah ditentukan */
        private final Ticket[] tiket; /*  objek dari Ticket bertipe data array untuk menyimpan informasi penumpang */

        // Constructor tanpa parameter untuk objek komuter pada Main
        public Kereta() {
            this.namaKereta = "Komuter";
            this.jumlahTiketTersedia = 3; /* jumlah tiket tersedia agar bisa menampung ketiga penumpang naik kereta */
            this.tiket = new Ticket[3]; /* ukuran sama dengan jumlahTiketTersedia */
        }

        // Constructor dengan parameter nama kereta dan jumlah tiket untuk onjek KAJJ pada Main
        public Kereta(String namaKereta, int jumlahTiketTersedia) {
            this.namaKereta = namaKereta;
            this.jumlahTiketTersedia = jumlahTiketTersedia;
            this.tiket = new Ticket[jumlahTiketTersedia];
        }

        // Menambahkan tiket untuk penumpang baru ke dalam kereta
        public void tambahTiket(String namaPenumpang) {
            if(jumlahTiketTersedia > 0) {
                tiket[jumlahTiketTersedia-1] = new Ticket(); /* objek dari Ticket masih baru dibuat */
                tiket[jumlahTiketTersedia-1].setNamaPenumpang(new String[]{namaPenumpang}); /* namaPenumpang disimpan dalam Ticket */
                jumlahTiketTersedia--; /* jumlah tiket akan berkurang 1 secara berulang */
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan");
            }
                /* Jika tiket yang tersedia sudah memasuki angka 0 */
                else {
                System.out.println("==================================================");
                System.out.println("Tiket untuk "+namaKereta+" sudah habis!");
            }
        }

        // Menambahkan tiket untuk penumpang baru ke dalam kereta, tambahan parameter asal dan tujuan
        public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
            if (jumlahTiketTersedia > 0) {
                tiket[jumlahTiketTersedia - 1] = new Ticket();
                tiket[jumlahTiketTersedia - 1].setNamaPenumpang(new String[]{namaPenumpang});
                tiket[jumlahTiketTersedia - 1].setAsal(new String[]{asal}); /* asal disimpan dalam Ticket */
                tiket[jumlahTiketTersedia - 1].setTujuan(new String[]{tujuan}); /* tujuan disimpan dalam Ticket */
                jumlahTiketTersedia--;
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia : "+getJumlahTiketTersedia());
            }
                /* jika tikett yang tersedia sudah memasuki angka 0 */
                else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwall kebrangkatan lainnya");
            }
        }

    // Menampilkan informasi semua penumpang yang telah memesan tiket yang tersedia di kereta
    public void tampilkanTiket() {
        System.out.println("==================================================");
        System.out.println("Daftar Penumpang kereta api " + namaKereta);
        System.out.println("----------------------------");
        boolean adaPenumpang = false; /* untuk melacak jika ada penumpang */

        for (int i = 0; i < tiket.length - 1; i++) { /* tak perlu membandingkan elemen terakhir dengan elemen setelahnya/kosong */
            for (int j = i + 1; j < tiket.length; j++) { /* inisialisasi indeks setelah i */
                /* pengecekan tiket yang dibandingkan tersedia tiketnya dan memiliki penumpang */
                if (tiket[i] != null && tiket[i].getNamaPenumpang()[0] != null &&
                        tiket[j] != null && tiket[j].getNamaPenumpang()[0] != null &&
                             /* penukaran posisi String sesuai urutan alfabet jika i > j */
                             tiket[i].getNamaPenumpang()[0].compareTo(tiket[j].getNamaPenumpang()[0]) > 0) {
                    /* String sementara jika terjadi penukaran posisi */
                    Ticket temp = tiket[i];
                    tiket[i] = tiket[j];
                    tiket[j] = temp;
                }
            }
        }
        for (Ticket ticket : tiket){
            /* pengecekan ticket jika tiketnya tersedia dan memiliki penumpang untuk bisa dimunculkan */
            if (ticket != null && ticket.getNamaPenumpang() != null && ticket.getNamaPenumpang().length > 0){
                System.out.println("Nama: " + ticket.getNamaPenumpang()[0]);
                /* pengecekan jika data asal dan tujuan valid pada ticket untuk bisa dimunculkan */
                if (ticket.getAsal() != null && ticket.getAsal().length > 0 && ticket.getTujuan() != null && ticket.getTujuan().length > 0) {
                        System.out.println("Asal: " + ticket.getAsal()[0]);
                        System.out.println("Tujuan: " + ticket.getTujuan()[0]);
                        System.out.println("----------------------------");
                    }
                    /* jika setelah dicetak, setidaknya ada 1 penumpang maka akan dinilai true (adaPenumpang) */
                    adaPenumpang = true;
                }
        }
        // Akan muncul jika tiket tidak tersedia sehingga tidak ada nama penumpang yang muncul
        if (!adaPenumpang) {
            System.out.println("Tidak ada penumpang");
        }
    }

    // Getter untuk mendapatkan nama kereta
        public String getNamaKereta() {
            return namaKereta;
        }
        // Setter untuk mengubah nama kereta
        public void setNamaKereta(String namaKereta) {
            this.namaKereta = namaKereta;
        }
        // Getter untuk mendapatkan jumlah tiket tersedia
        public int getJumlahTiketTersedia() {
            return jumlahTiketTersedia;
        }
        // Setter untuk mengubah jumlah tiket tersedia
        public void setJumlahTiketTersedia(int jumlahTiketTersedia) {
            this.jumlahTiketTersedia = jumlahTiketTersedia;
        }
    }