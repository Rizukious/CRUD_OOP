/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_01;

/**
 *
 * @author baydhowi21
 */
public class Manusia {
    String nama;
    String email;
    Mahasiswa data_mhs;
    
    public Manusia() {
        System.out.println("ini constructor");
    }
    
    public Manusia(String nama) {
        String data = nama;
        System.out.println(data);
    }
    
    public Manusia(Mahasiswa data) {
        System.out.println(data.NIM);
    }
    
    public void tampilkanNIM() {
        System.out.println(data_mhs.NIM);
    }
}
