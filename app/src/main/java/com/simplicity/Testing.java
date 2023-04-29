package com.simplicity;

public class Testing {
    public static void main(String[] args) throws InterruptedException{
        World w = new World(new Waktu());
        Menu m = new Menu();
        Point p1 = new Point(30, 30); 
        Point p2 = new Point(0, 0); 

        Rumah r1 = new Rumah(p1);
        Rumah r2 = new Rumah(p2);  
        Sim s1 = new Sim("Default", r1); 
        Sim s2 = new Sim("Kawan", r2);
        w.setCurrentSim(s1);
        m.viewSimInfo(w);


        w.getWaktu().displayWaktu();
        BahanMakanan b = new BahanMakanan("Nasi");
        BahanMakanan b2 = new BahanMakanan("Ayam");
        BahanMakanan b3 = new BahanMakanan("Sapi");

        Kiriman bb = new Kiriman(b, s1, 10);

        s1.beliBarang(b, 1);
        s1.beliBarang(b2, 2);
        s1.beliBarang(b3, 3);

        Waktu.displayPengiriman();
//        s1.olahraga(20);
        w.getWaktu().displayWaktu();
        Waktu.displayPengiriman();

//        m.viewSimInfo(w);
        Point point = new Point(0, 0);
        //w.setCurrFurnitur(w.getDaftarRumah().get(point).getDaftarRuangan().get(point).getDaftarObjek().get(new Point(5, 5)));
        w.setCurrFurnitur(w.addRumah("s1").getCurrRuangan().getDaftarObjek().get(new Point(5, 5)));

        Toilet accessedFurnitur2;
        accessedFurnitur2 = (Toilet) w.getCurrFurnitur();
        accessedFurnitur2.buangAir(s1);
        m.viewSimInfo(w);
        BahanMakanan nasiBaru = new BahanMakanan("Nasi");
        s1.getInventory().lihatInventory();
        // s1.getInventory().reduceItem(nasiBaru, 1); 
        // s1.getInventory().lihatInventory();

        w.setCurrFurnitur(w.getCurrentRumah().getCurrRuangan().getDaftarObjek().get(new Point(1, 0)));

        Kompor accessedFurnitur;

        accessedFurnitur = (Kompor) w.getCurrFurnitur();
        accessedFurnitur.masak(s1);
        m.viewSimInfo(w);
        w.getWaktu().displayWaktu();
        s1.getInventory().lihatInventory();
    }
        
}
