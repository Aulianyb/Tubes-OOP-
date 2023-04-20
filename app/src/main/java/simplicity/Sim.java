public class Sim{
    private String namaLengkap; 
    //pekerjaan; 
    private int uang;
    //tambahin inventory nanti
    private int kekenyangan; 
    private int mood; 
    private int kesehatan; 
    //tambahin status

    //nanti tambahin buildernya

    public String getNama(){
        return namaLengkap; 
    }

    //tambahin getter pekerjaan

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

    //getter status

    public void setNama(String namaBaru){
        namaLengkap = namaBaru; 
    }

    //changePekerjaan

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