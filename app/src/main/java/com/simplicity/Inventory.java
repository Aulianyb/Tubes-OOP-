package com.simplicity;
import java.util.*;

public class Inventory<T extends ObjekGame> {
    private HashMap<T, Integer> inventory;

    public Inventory(){
        inventory = new HashMap<>(); 
    }

    public Map<T, Integer> getInventory(){
        return inventory; 
    }

    public T itemFound(T item){
        T temp = null; 
        Iterator <Map.Entry<T, Integer>> iterator = inventory.entrySet().iterator(); 
        while (iterator.hasNext()){
            Map.Entry<T, Integer> entry  = iterator.next ();
            if (entry.getKey().equals(item)){
                temp = entry.getKey();  
            }
        }
        return temp; 
    }

    public boolean itemAvailable(T item){
        Iterator <Map.Entry<T, Integer>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<T, Integer> entry  = iterator.next ();
            if (entry.getKey().equals(item)){
                return true;
            }
        }
        return false;
    }

    public void reduceItem(T item, Integer jumlah){
        T temp = itemFound(item); 
        if (temp != null){
            if (inventory.get(temp) - jumlah < 0){
                System.out.println("Maaf! Jumlah item tidak cukup..");
                System.out.println("Saat ini kamu memiliki " + temp.getNamaObjek() + " sebanyak " + inventory.get(item) + " buah. ");
            } else{
                inventory.put(temp, Integer.valueOf(inventory.get(temp) - jumlah)); 
            }
            if (inventory.get(temp) == 0){
                inventory.remove(temp); 
            }
            System.out.println("Item " + temp.getNamaObjek() + " berhasil dikurangi sebanyak " + jumlah + " buah dari inventory!");
        }else{
            System.out.println("Maaf, tidak ada item " + item.getNamaObjek() + " dalam Inventory"); 
        }
    }

    public void addItem(T item, int jumlah){
        T temp = itemFound(item); 
        if (temp != null){
            inventory.put(temp, inventory.get(temp) + jumlah); 
        } else{
            inventory.put(item, jumlah); 
        }
        System.out.println("Item " + temp.getNamaObjek() + " berhasil ditambahkan sebanyak " + jumlah + " buah dari inventory!");
    }

    public void lihatInventory(){
        // ini juga nampilin dua duanya kah? makanan dan non makanan?
        System.out.println(""); 
        System.out.println(" ".repeat(12) + "I N V E N T O R Y" + " ".repeat(12)); 
        System.out.println("-".repeat(42)); 
        System.out.println("|     Nama Barang    | Kategori | Jumlah |"); 
        System.out.println("-".repeat(42)); 

        if (inventory.isEmpty()){
            System.out.println("|" + " ".repeat(20) + "|" + " ".repeat(10) + "|" + " ".repeat(8) + "|"); 
            System.out.println("-".repeat(42)); 

        } else{
            inventory.forEach((key, value) -> {
                int x = 20 - key.getNamaObjek().length();
                int y = 10 - key.getKategori().length(); 
                int z = 8 - value.toString().length(); 
                System.out.println("|" + key.getNamaObjek() + " ".repeat(x) + "|" + key.getKategori() + " ".repeat(y) + "|" + value + " ".repeat(z) + "|"); 
                System.out.println("-".repeat(42)); 
            });
        }

        System.out.println("");
    }

}
