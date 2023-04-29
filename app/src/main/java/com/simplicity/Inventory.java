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

    public T itemFound(T item){
        T temp = null; 
        Iterator <Map.Entry<T, Integer>> iterator = inventoryMakanan.entrySet().iterator(); 
        while (iterator.hasNext()){
            Map.Entry<T, Integer> entry  = iterator.next ();
            if (entry.getKey().equals(item)){
                temp = entry.getKey();  
            }
        }
        return temp; 
    }

    public void reduceItem(T item, Integer jumlah){
        T temp = itemFound(item); 
        if (item instanceof Makanan){
            if (temp != null){
                if (inventoryMakanan.get(temp) - jumlah < 0){
                    System.out.println("Maaf! Jumlah item tidak cukup..");
                    System.out.println("Saat ini kamu memiliki " + temp.getNamaObjek() + " sebanyak " + inventoryMakanan.get(item) + " buah. ");
                } else{
                    inventoryMakanan.put(temp, Integer.valueOf(inventoryMakanan.get(temp) - jumlah)); 
                }
                if (inventoryMakanan.get(temp) == 0){
                    inventoryMakanan.remove(temp); 
                }
                System.out.println("Item " + temp.getNamaObjek() + " berhasil dikurangi sebanyak " + jumlah + " buah!"); 
            }else{
                System.out.println("Maaf, tidak ada item " + item.getNamaObjek() + " dalam Inventory"); 
            }
        } else{
            if (temp != null){
                if (inventoryPeralatan.get(temp) - jumlah < 0){
                    System.out.println("Maaf! Jumlah item tidak cukup..");
                    System.out.println("Saat ini kamu memiliki " + temp.getNamaObjek() + " sebanyak " + inventoryPeralatan.get(temp) + " buah. ");
                } else{
                    inventoryPeralatan.put(temp,Integer.valueOf(inventoryPeralatan.get(temp) - jumlah)); 
                    System.out.println("Item " + temp.getNamaObjek() + " berhasil dikurangi sebanyak " + jumlah + " buah!"); 
                }
                if (inventoryPeralatan.get(temp) == 0){
                    inventoryPeralatan.remove(temp); 
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
