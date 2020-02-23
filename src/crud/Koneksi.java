package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baydhowi21
 */
public class Koneksi {
    // 127.0.0.1 = localhost
    String host = "127.0.0.1"; // lokasi server database
    String db = "htmi_crud"; // nama database
    String username = "root"; // user database
    String password = ""; // password database
    String driver = "com.mysql.jdbc.Driver"; // driver database
    // jdbc:mysql://127.0.0.1/hmti_crud?user=root&password=
    String connect = "jdbc:mysql://" + host + "/" + db + "?user=" + username + "&password=" + password;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public Koneksi() {
    }
    
    public Koneksi(String _host, String _db, String _username, String _password) {
        this.host = _host;
        this.db = _db;
        this.username = _username;
        this.password = _password;
        this.connect = "jdbc:mysql://" + host + "/" + db + "?user=" + username + "&password=" + password;
    }
    
    public boolean connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(connect);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("koneksi berhasil");
            return true;
        } catch (Exception e) {
            System.out.println("koneksi database gagal: " + e.getMessage());
            return false;
        }
    }
    
    public boolean close() {
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean executeQuery(String _sql) {
        try {
            stmt.executeQuery(_sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet showQuery(String _sql) {
        try {
            rs = stmt.executeQuery(_sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
}
