package com.simplicity;

public class Jam extends Furnitur {
    public Jam(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(10);

        setValidAction(new Status());
        getValidAction().setStatus("melihat waktu");
    }

    @Override
    public void aksi(Sim sim) {
        int totalDetik = 12 * 60;
        int totalWaktuBerjalan = Waktu.getInstance().getMenit() * 60 + Waktu.getInstance().getDetik();

        int sisaMenit = (totalDetik - totalWaktuBerjalan) / 60;
        int sisaDetik = (totalDetik - totalWaktuBerjalan) % 60;
        System.out.println("");
        System.out.println("=".repeat(23) +  " WAKTU " + "=".repeat(23));
        System.out.println("");
        System.out.print("Sisa Waktu Hari Ini : ");
        if (sisaMenit < 10) {
            System.out.print("0");
        }
        else {
            System.out.print("");
        }
        System.out.print(sisaMenit);
        if (sisaDetik < 10) {
            System.out.print(":0");
        }
        else {
            System.out.print(":");
        }
        System.out.println(sisaDetik);

        System.out.print("Sisa Waktu Pengiriman Barang : ");
        System.out.println("");
        Waktu.getInstance().displayPengiriman();
        System.out.println("");
        System.out.print("Sisa Waktu Upgrade Rumah : ");
        System.out.println("");
        Waktu.getInstance().displayUpgrade();
    }
}
