package com.simplicity;
import java.util.*;

public class Masakan extends Makanan {
    private List<BahanMakanan> ingredients = new ArrayList<BahanMakanan>();

    //Konstruktor
    public Masakan(String namaObjek) {
        super(namaObjek);

        if (namaObjek.equals("Nasi Ayam")) {
            setNilaiKekenyangan(16);
            ingredients.add(new BahanMakanan("Nasi"));
            ingredients.add(new BahanMakanan("Ayam"));
        }
        else if (namaObjek.equals("Nasi Kari")) {
            setNilaiKekenyangan(30);
            ingredients.add(new BahanMakanan("Nasi"));
            ingredients.add(new BahanMakanan("Kentang"));
            ingredients.add(new BahanMakanan("Wortel"));
            ingredients.add(new BahanMakanan("Sapi"));
        }
        else if (namaObjek.equals("Susu Kacang")) {
            setNilaiKekenyangan(5);
            ingredients.add(new BahanMakanan("Susu"));
            ingredients.add(new BahanMakanan("Kacang"));
        }
        else if (namaObjek.equals("Tumis Sayur")) {
            setNilaiKekenyangan(5);
            ingredients.add(new BahanMakanan("Wortel"));
            ingredients.add(new BahanMakanan("Bayam"));
        }
        else if (namaObjek.equals("Bistik")) {
            setNilaiKekenyangan(22);
            ingredients.add(new BahanMakanan("Kentang"));
            ingredients.add(new BahanMakanan("Sapi"));
        }
    }

    public List<BahanMakanan> getBahan() {
        return ingredients;
    }

    //Mengecek ketersediaan bahan pada inventory
    public boolean bahanInInventory(Inventory<ObjekGame> inv, List<BahanMakanan> l) {
        for (BahanMakanan m : l) {
            if (!inv.getInventoryMakanan().containsKey(m)) {
                return false;
            }
        }
        return true;
    }
}
