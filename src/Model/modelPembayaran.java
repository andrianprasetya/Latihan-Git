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
public class modelPembayaran {
    private String id_pembayaran;

    public String getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(String id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }
    private String NamaPelanggan;
    private String nomorKWH;
    private int tanggal_Pembayaran;
    private int bulan_Pembayaran;
    private int Total_Bayar;
    private String Nama_Admin;

    public String getNamaPelanggan() {
        return NamaPelanggan;
    }

    public void setNamaPelanggan(String NamaPelanggan) {
        this.NamaPelanggan = NamaPelanggan;
    }

    public String getNomorKWH() {
        return nomorKWH;
    }

    public void setNomorKWH(String nomorKWH) {
        this.nomorKWH = nomorKWH;
    }

    public int getTanggal_Pembayaran() {
        return tanggal_Pembayaran;
    }

    public void setTanggal_Pembayaran(int tanggal_Pembayaran) {
        this.tanggal_Pembayaran = tanggal_Pembayaran;
    }

    public int getBulan_Pembayaran() {
        return bulan_Pembayaran;
    }

    public void setBulan_Pembayaran(int bulan_Pembayaran) {
        this.bulan_Pembayaran = bulan_Pembayaran;
    }

    public int getTotal_Bayar() {
        return Total_Bayar;
    }

    public void setTotal_Bayar(int Total_Bayar) {
        this.Total_Bayar = Total_Bayar;
    }

   

    public String getNama_Admin() {
        return Nama_Admin;
    }

    public void setNama_Admin(String Nama_Admin) {
        this.Nama_Admin = Nama_Admin;
    }
}
