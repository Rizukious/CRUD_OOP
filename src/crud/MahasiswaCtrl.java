/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baydhowi21
 */
public class MahasiswaCtrl {
    Mahasiswa mhs = new Mahasiswa();
    Koneksi k = new Koneksi();
    ResultSet rs;
    
    private final String primary_key = "nim";
    private final String table_name = "mahasiswa";
    // select * from mahasiswa
    private final String q_select = "select * from " + table_name;

    public MahasiswaCtrl() {
    }
    
    public MahasiswaCtrl(Mahasiswa _mhs) {
        this.mhs = _mhs;
    }
    
    public void replaceData() throws SQLException {
        rs.updateString("nim", mhs.getNim());
        rs.updateString("nama", mhs.getNama());
        rs.updateString("jurusan", mhs.getJurusan());
        rs.updateString("alamat", mhs.getAlamat());
        rs.updateString("no_tlp", mhs.getNo_tlp());
    }
    
    public void saveData() {
        try {
            k = new Koneksi();
            if (k.connect()) {
                // jika koneksi berhasil
                // select * from mahasiswa where nim = 'mhs.getNim()';
                String q = q_select + " where " + primary_key + "='" + mhs.getNim() + "'";
                rs = k.showQuery(q);
                if (rs.next()) {
                    // update data
                    this.replaceData();
                    rs.updateRow();
                    System.out.println("data terupdate");
                } else {
                    // insert data
                    rs.moveToInsertRow();
                    this.replaceData();
                    rs.insertRow();
                    System.out.println("data tersimpan");
                    rs.moveToCurrentRow();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            k.close();
        }
    }
    
    public void deleteData() {
        try {
            k = new Koneksi();
            if (k.connect()) {
                String q = q_select + " where " + primary_key + "='" + mhs.getNim() + "'";
                rs = k.showQuery(q);
                if (rs.next()) {
                    rs.deleteRow();
                    System.out.println("data terhapus");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            k.close();
        }
    }
    
    public void retrieveData(ResultSet _rs, Mahasiswa _mhs) throws SQLException {
        _mhs.setNim(_rs.getString("nim"));
        _mhs.setNama(_rs.getString("nama"));
        _mhs.setJurusan(_rs.getString("jurusan"));
        _mhs.setAlamat(_rs.getString("alamat"));
        _mhs.setNo_tlp(_rs.getString("no_tlp"));
    }
    
    public List<Mahasiswa> getLists(String _q) {
        List<Mahasiswa> list = new ArrayList<Mahasiswa>();
        try {
            k = new Koneksi();
            if (k.connect()) {
                rs = k.showQuery(_q);
                while(rs.next()) {
                    Mahasiswa _mhs = new Mahasiswa();
                    this.retrieveData(rs, _mhs);
                    list.add(_mhs);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            k.close();
        }
        
        return list;
    }
    
    public List<Mahasiswa> getAllLists() {
        return this.getLists(q_select);
    }
}
