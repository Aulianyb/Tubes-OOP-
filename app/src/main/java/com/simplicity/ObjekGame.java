package com.simplicity;

public class ObjekGame {
    private String namaObjek;
    //private String kategori;

    //Konstruktur
    public ObjekGame(String namaObjek) {
        this.namaObjek = namaObjek;
    }

    //Getter
    public String getNamaObjek() {
        return namaObjek;
    }

    //Setter
    public void setNamaObjek(String namaObjek) {
        this.namaObjek = namaObjek;
    }

    // @Override
    public boolean equals(ObjekGame objectGame) {
        if (this == objectGame)
            return true;
        if (objectGame == null || getClass() != objectGame.getClass())
            return false;
        ObjekGame that = (ObjekGame) objectGame;
        return namaObjek.equals(that.getNamaObjek());
    }
}
