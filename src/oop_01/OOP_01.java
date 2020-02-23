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
public class OOP_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BelajarMethod b = new BelajarMethod();
        Mahasiswa m = new Mahasiswa();
        m.NIM = "20191503";
        b.tampilkanNama(m);
        
        String nama = b.nama();
        if (nama.equals("")) {
            System.out.println("data tidak ada");
        } else {
            System.out.println(nama);
        }
    }
    
}
