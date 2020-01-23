package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class modelPelanggan {
      private String id_pelanggan;
        private String username;
        private String password;
        private String nomer_KWH;
        private String nama_pelanggan;
        private String alamat;
        private String id_tarif;
        private String daya;

    public String getDaya() {
        return daya;
    }

    public void setDaya(String daya) {
        this.daya = daya;
    }
        

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomer_KWH() {
        return nomer_KWH;
    }

    public void setNomer_KWH(String nomer_KWH) {
        this.nomer_KWH = nomer_KWH;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId_tarif() {
        return id_tarif;
    }

    public void setId_tarif(String id_tarif) {
        this.id_tarif = id_tarif;
    }
}
