package com.simplicity;

public class MejaKursi extends Furnitur {
    //Konstruktor
    public MejaKursi(String namaObjek) {
        super(namaObjek);
        setPanjang(3);
        setLebar(3);
        setHarga(50);

        setValidAction(new Status());
        getValidAction().setStatus("makan");
    }

    //Nunggu inventory selesai dulu
//    public void makan(Sim sim) {
//        Thread thread = new Thread(new Runnable(){
//            public void run(){
//                try {
//                    System.out.println("Makan..."); //indikator buat testing
//                    Thread.sleep(30000);
//                } catch (InterruptedException e){
//                }
//                finally{
//                    sim.setKekeyangan(-20);
//                }
//            }
//        });
//        thread.run();
//    }
}
