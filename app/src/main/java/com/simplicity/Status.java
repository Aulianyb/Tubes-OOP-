package com.simplicity;

public class Status {
    private boolean beliBarang; 
    private String namaStatus; 

    public Status(){
        namaStatus = "idle"; 
        beliBarang = false;  
    }

    public String getStatus(){
        return namaStatus; 
    
    }

    public void setStatus(String status){
        namaStatus = status; 
    }

    public boolean getBeli(){
        return beliBarang; 
    }
    
    public void setBeli(boolean beli){
        beliBarang = beli; 
    }

    public void updatePembelian(Sim sim){
        beliBarang = false; 
        Waktu.getInstance().getPengiriman().forEach((key, action)->{
            if (key.getSim() == World.getCurrentSim()){
                beliBarang = true; 
            }
        });
    }

    //testing
    public void displayStatus(Sim sim){
        System.out.println("S T A T U S");
        System.out.println("beli barang : " + beliBarang);
        System.out.println("upgrade rumah : " + sim.getCurrentRumah().getUpgradeStatus());

    }
}
