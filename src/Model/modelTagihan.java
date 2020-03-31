/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author user
 */
public class modelTagihan {

    public String getId_tagihan() {
        return id_tagihan;
    }

    public void setId_tagihan(String id_tagihan) {
        this.id_tagihan = id_tagihan;
    }
    private String id_tagihan;
    private String NamaPelanggan ;
    private String Alamat;
    private String noKWH;
    private int Bulan;
    private int Tahun;
    private int jumlah_meter;
    private String status;

    public String getNamaPelanggan() {
        return NamaPelanggan;
    }

    public void setNamaPelanggan(String NamaPelanggan) {
        this.NamaPelanggan = NamaPelanggan;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getNoKWH() {
        return noKWH;
    }

    public void setNoKWH(String noKWH) {
        this.noKWH = noKWH;
    }

    public int getBulan() {
        return Bulan;
    }

    public void setBulan(int Bulan) {
        this.Bulan = Bulan;
    }

    public int getTahun() {
        return Tahun;
    }

    public void setTahun(int Tahun) {
        this.Tahun = Tahun;
    }

    public int getJumlah_meter() {
        return jumlah_meter;
    }

    public void setJumlah_meter(int jumlah_meter) {
        this.jumlah_meter = jumlah_meter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
