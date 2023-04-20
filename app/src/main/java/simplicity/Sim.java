public class Sim{
    private String namaLengkap; 
    private Pekerjaan pekerjaan; 
    private int uang;
    private Inventory inventory; 
    private int kekenyangan; 
    private int mood; 
    private int kesehatan; 
    private Status status; 

    //nanti tambahin buildernya

    public String getNama(){
        return namaLengkap; 
    }

    public Pekerjaan getPekerjaan(){
        return pekerjaan; 
    }

    public int getUang(){
        return uang; 
    }

    public int getKekeyangan(){
        return kekenyangan; 
    }

    public int getMood(){
        return mood; 
    }

    public int getKesehatan(){
        return kesehatan; 
    }

    public Status getStatus(){
        return status; 
    }

    public void setNama(String namaBaru){
        namaLengkap = namaBaru; 
    }

    public void setPekerjaan(Pekerjaan pekerjaan){
        this.pekerjaan = pekerjaan; 
    }

    public void setKekeyangan(int diff){
        kekenyangan += diff; 
    }

    public void setMood(int diff){
        mood += diff; 
    }

    public void setKesehatan(int diff){
        kesehatan += diff; 
    }

}