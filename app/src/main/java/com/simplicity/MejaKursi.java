package com.simplicity;
import java.util.*;

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

    @Override
    public void aksi(Sim sim) {
        boolean empty = true;

        for (ObjekGame m : ((Map<ObjekGame, Integer>)sim.getInventory().getInventory()).keySet()) {
            if (m instanceof Makanan) {
                empty = false;
            }
        }

        if (empty) {
            System.out.println("Tidak terdapat makanan pada inventory.");
        }
        else {
            TimeThread.getInstance().resume();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Makanan temp = null;
                    try {
                        //Map<Makanan, Integer> inv = sim.getInventory();
                        int i = 1;

                        //Menampilkan daftar makanan yang dimiliki
                        System.out.println("Makanan yang terdapat dalam inventory:");
                        for (ObjekGame m : ((Map<ObjekGame, Integer>) sim.getInventory().getInventory()).keySet()) {
                            if (m instanceof Makanan) {
                                System.out.println(i + ". " + m.getNamaObjek());
                                i++;
                            }
                        }

                        //Input makanan yang ingin dimakan
                        Scanner scanner = new Scanner(System.in);
                        String namaMakanan = scanner.nextLine();
                        boolean valid = false;
                        //Mengonsumsi makanan
                        for (ObjekGame ma : ((Map<ObjekGame, Integer>) sim.getInventory().getInventory()).keySet()) {
                            if (ma instanceof Makanan && ma.getNamaObjek().toLowerCase().equals(namaMakanan.toLowerCase())) {
                                valid = true;
                                temp = (Makanan) ma;
                                break;
                            }
                        }

                        if (valid) {
                            System.out.println("Makan..."); //indikator buat testing
                            System.out.printf("[");
                            for (int j = 0; j < 10; j++) {
                                Thread.sleep(3000);
                                System.out.printf(">");
                            }
                            System.out.println("]");
                            sim.getInventory().reduceItem(temp, 1);
                            sim.setKekenyangan(temp.getNilaiKekenyangan());
                            Waktu.getInstance().timePass(30);
                            System.out.println("Makan selesai!");
                            System.out.println("Kekenyangan : +" + temp.getNilaiKekenyangan());
                            if (!sim.getJamBuangAir().kondisi.equals("Butuh buang air")) {
                                if (sim.getJamBuangAir().waktu > 0) {
                                    sim.setJamBuangAir(sim.getJamBuangAir().waktu, "Belum buang air");
                                } else {
                                    sim.setJamBuangAir(0, "Belum buang air");
                                }
                            } else {
                                sim.setJamBuangAir(0, "Belum buang air");
                            }
                        } else {
                            System.out.println("Makanan tidak terdapat pada inventory.");
                        }


                    } catch (InterruptedException e) {
                        System.out.println("Makan dihentikan.");
                    }
                }
            });
            thread.run();
            TimeThread.getInstance().pause();
        }
    }
}
