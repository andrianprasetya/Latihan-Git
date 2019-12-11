/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDB;
import intefc.interfc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Civilition
 */
public class ControllerDB implements interfc{
    private String ID_pel;

    
    private String Id_tagihan,Id_pelanggan,Username,Password,Nomer_KWH,Nama_pelanggan,Alamat,Id_tarif,daya;
    private int tarif;
    public String getId_tagihan() {
        return Id_tagihan;
    }
    private boolean statusPembayaran;

    public boolean getStatusPembayaran() {
        return statusPembayaran;
    }

    public String getDaya() {
        return daya;
    }

    public int getTarif() {
        return tarif;
    }
    private boolean Status = false;
    
    private String Lupa_Username;

    

    public void login_pel(String Username, String Password) throws SQLException{
        PreparedStatement Pre = koneksi.getConnection().prepareStatement("select * from pelanggan where Username=? and Password=?");
            Pre.setString(1, Username);
            Pre.setString(2, Password);
            ResultSet rs = Pre.executeQuery();
           if(rs.next())
           {
               ID_pel = rs.getString("id_pelanggan");
               Status = true;
           }        
    }
    public void login_admin(String Username, String Password) throws SQLException{
        PreparedStatement Pre = koneksi.getConnection().prepareStatement("select * from admin where Username=? and Password=?");
            Pre.setString(1, Username);
            Pre.setString(2, Password);
            ResultSet rs = Pre.executeQuery();
           if(rs.next())
           {
               Status = true;
           }        
    }
    public pelanggan insert(pelanggan P) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("insert into pelanggan values(?,?,?,?,?,?,?)");
        st.setString(1,P.getId_pelanggan());
        st.setString(2, P.getUsername());
        st.setString(3, P.getPassword());
        st.setString(4, P.getNomer_KWH());
        st.setString(5,P.getNama_pelanggan());
        st.setString(6, P.getAlamat());
        st.setString(7, P.getId_tarif());
        
        st.executeUpdate();
        return P;
    }

    
    public void lupa_passwrd(String ID) throws SQLException{
        PreparedStatement Pre = koneksi.getConnection().prepareStatement("SELECT * FROM pelanggan WHERE id_pelanggan=?");
            Pre.setString(1, ID);
            ResultSet rs = Pre.executeQuery();
            if(rs.next())
            {
                Lupa_Username = rs.getString("username");
                ID_pel = rs.getString("id_pelanggan"); 
            }
    }
    public void UpdatePassword(String NEW_PW, String ID) throws SQLException{
        PreparedStatement Pre=koneksi.getConnection().prepareStatement
        ("update pelanggan set Password=? where id_pelanggan=?");
        Pre.setString(1, NEW_PW);
        Pre.setString(2,ID);
        Pre.executeUpdate();
        
    }
    public String getLupa_Username() {
        return Lupa_Username;
    }

    
    public String getID_pel() {
        return ID_pel;
    }
    public void Tagih(String IDPEL,String IDTGH,String BLN) throws SQLException{
        PreparedStatement Pre = koneksi.getConnection().prepareStatement
        ("SELECT * FROM tagihan INNER JOIN pelanggan ON pelanggan.id_pelanggan = tagihan.id_pelanggan INNER JOIN tarif ON pelanggan.id_tarif = tarif.id_tarif where pelanggan.id_pelanggan=? and id_tagihan=? and bulan=?");
            Pre.setString(1, IDPEL);
            Pre.setString(2, IDTGH);
            Pre.setString(3, BLN);
            ResultSet rs = Pre.executeQuery();
           if(rs.next())
           {
               Nama_pelanggan = rs.getString("pelanggan.nama_pelanggan");
               ID_pel = rs.getString("id_pelanggan"); 
               daya = rs.getString("tarif.daya");
               tarif = rs.getInt("tarif.tarif_perkwh");
               statusPembayaran = rs.getBoolean("tagihan.status");
               Status = true;
           }        
        }
    public void info_pelanggan(String ID) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("select * from pelanggan where id_pelanggan=?");
        st.setString(1, ID);
        ResultSet rs = st.executeQuery();
        if(rs.next())
        {
            Id_pelanggan = rs.getString("id_pelanggan");
            Username = rs.getString("username");
            Password = rs.getString("password");
            Nomer_KWH = rs.getString("nomor_KWH");
            Nama_pelanggan = rs.getString("nama_pelanggan");
            Alamat = rs.getString("alamat");
            Id_tarif = rs.getString("id_tarif");
        }
        
    }
    public String getUsername() {
        return Username;
    }

    public String getNomer_KWH() {
        return Nomer_KWH;
    }
    public String getId_pelanggan() {
        return Id_pelanggan;
    }

    public String getPassword() {
        return Password;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getId_tarif() {
        return Id_tarif;
    }
    public String getNama_pelanggan() {
                return Nama_pelanggan;
    }    
    public List<penggunaan> getAll(String ID) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("select * from penggunaan where id_pelanggan=? ");
        st.setString(1, ID);
        ResultSet rs = st.executeQuery();
        
        List<penggunaan> list = new ArrayList<penggunaan>();
        while(rs.next()){
            penggunaan png = new penggunaan();
            png.setBulan(rs.getString("bulan"));
            png.setTahun(rs.getString("tahun"));
            png.setMeter_awal(rs.getString("meter_awal"));
            png.setMeter_akhir(rs.getString("meter_akhir"));
            list.add(png);
        }
        return list;
    }
    
    public List<pelanggan> getAll_pelanggan() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from pelanggan ");
        
        List<pelanggan> list = new ArrayList<pelanggan>();
        while(rs.next()){
            pelanggan pl = new pelanggan();
            pl.setId_pelanggan(rs.getString("id_pelanggan"));
            pl.setNama_pelanggan(rs.getString("nama_pelanggan"));
            pl.setNomer_KWH(rs.getString("nomor_KWH"));
            pl.setAlamat(rs.getString("alamat"));
            
            list.add(pl);
        }
        return list;
    }
    public void ViewPembayaran (String Id_Pelanggan, String Bulan) throws SQLException{
        PreparedStatement st = koneksi.getConnection().prepareStatement("SELECT tagihan.id_tagihan,pelanggan.nama_pelanggan,tarif.daya,tarif.tarif_perkwh,tagihan.bulan FROM tagihan INNER JOIN pelanggan ON pelanggan.id_pelanggan = tagihan.id_pelanggan INNER JOIN tarif ON pelanggan.id_tarif = tarif.id_tarif where pelanggan.id_pelanggan=? and tagihan.bulan=?");
        st.setString(1, Id_Pelanggan);
        st.setString(2, Bulan);
        ResultSet rs = st.executeQuery();
        if(rs.next())
        {
           Id_tagihan = rs.getString("tagihan.id_tagihan");
           Nama_pelanggan = rs.getString("pelanggan.nama_pelanggan");
           daya = rs.getString("tarif.daya");
           tarif = rs.getInt("tarif.tarif_perkwh");
        }
    }
    public pembayaran insertPembayaran(pembayaran P) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("insert into pembayaran values(?,?,?,?,?,?,?,NULL)");
        st.setString(1, P.getId_pembayaran());
        st.setString(2, P.getId_tagihan());
        st.setString(3, P.getId_pelanggan());
        st.setInt(4, P.getTanggal());
        st.setInt(5, P.getBulan());
        st.setInt(6, P.getBiaya_admin());
        st.setInt(7, P.getTotal_bayar());
        
        st.executeUpdate();
        return P;
    }
     public void UpdatePelanggan(pelanggan p) throws SQLException{
        PreparedStatement Pre=koneksi.getConnection().prepareStatement
        ("update pelanggan set nama_pelanggan=?, alamat=?, nomerKWH=? where id_pelanggan=? ");
        Pre.setString(1, p.getNama_pelanggan());
        Pre.setString(2, p.getAlamat());
        Pre.setString(3, p.getNomer_KWH());
        Pre.setString(4, p.getId_pelanggan());
        Pre.executeUpdate();
        
    }
    
    public boolean getStatus() {
        return Status;
    }

}
