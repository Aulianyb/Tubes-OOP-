package com.simplicity;
import java.util.*;

public class Inventory<T extends ObjekGame> {
    //Makanan : objectnya, Integer : jumlah
    private HashMap<T, Integer> inventoryMakanan;
    private HashMap<T, Integer> inventoryPeralatan;

    public Inventory(){
        inventoryMakanan = new HashMap<>(); 
        inventoryPeralatan = new HashMap<>(); 
    }

    public Map<T, Integer> getInventoryMakanan() {
        return inventoryMakanan;
    }

    public void reduceItem(T item, Integer jumlah){
        if (item instanceof Makanan){
            if (inventoryMakanan.containsKey(item)){
                if (inventoryMakanan.get(item) - jumlah < 0){
                    System.out.println("Maaf! Jumlah item tidak cukup..");
                    System.out.println("Saat ini kamu memiliki " + item.getNamaObjek() + " sebanyak " + inventoryMakanan.get(item) + " buah. ");
                } else{
                    inventoryMakanan.put(item, Integer.valueOf(inventoryMakanan.get(item) - jumlah)); 
                }
                if (inventoryMakanan.get(item) == 0){
                    inventoryMakanan.remove(item); 
                }
                System.out.println("Item " + item.getNamaObjek() + " berhasil dikurangi sebanyak " + jumlah + " buah!"); 
            }else{
                System.out.println("Maaf, tidak ada item " + item.getNamaObjek() + " dalam Inventory"); 
            }
        } else{
            if (inventoryPeralatan.containsKey(item)){
                if (inventoryPeralatan.get(item) - jumlah < 0){
                    System.out.println("Maaf! Jumlah item tidak cukup..");
                    System.out.println("Saat ini kamu memiliki " + item.getNamaObjek() + " sebanyak " + inventoryPeralatan.get(item) + " buah. ");
                } else{
                    inventoryPeralatan.put(item,Integer.valueOf(inventoryPeralatan.get(item) - jumlah)); 
                    System.out.println("Item " + item.getNamaObjek() + " berhasil dikurangi sebanyak " + jumlah + " buah!"); 
                }
                if (inventoryPeralatan.get(item) == 0){
                    inventoryPeralatan.remove(item); 
                }
        
            }else{
                System.out.println("Maaf, tidak ada item " + item.getNamaObjek() + " dalam Inventory"); 
            }
        }
    }

    public void addItem(T item, int jumlah){
        // ini cara tau harus masukin ke Makanan atau non Makanan gimana ya?
        //nunggu dulu mungkin ada indikatornya
        if (item instanceof Makanan){
            if (inventoryMakanan.containsKey(item)){
                inventoryMakanan.put(item, inventoryMakanan.get(item) + jumlah); 
            } else{
                inventoryMakanan.put(item, jumlah); 
            }
        } else{
            if (inventoryPeralatan.containsKey(item)){
                inventoryPeralatan.put(item, inventoryPeralatan.get(item) + jumlah); 
            } else{
                inventoryPeralatan.put(item, jumlah); 
            }
        }

        System.out.println("Berhasil menambahkan " + item.getNamaObjek() + " sebanyak " + jumlah + " buah!"); 
    }

    public void lihatInventory(){
        // ini juga nampilin dua duanya kah? makanan dan non makanan?
        System.out.println("==================");
        System.out.println(" I N V E N T O R Y"); 
        System.out.println("=================="); 

        if (inventoryMakanan.isEmpty() && inventoryPeralatan.isEmpty()){
            System.out.println("Oops! Sepertinya tidak ada apa apa dalam Inventory Sim ini"); 
        } else{
            inventoryMakanan.forEach((key, value) -> {
                System.out.println(key.getNamaObjek() + " : " + value); 
            });
            inventoryPeralatan.forEach((key, value) -> {
                System.out.println(key.getNamaObjek() + " : " + value); 
            });
        }

        System.out.println("");
    }

}
