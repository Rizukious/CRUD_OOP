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
public class BelajarMethod {
    
    public Mahasiswa tampilkanNama(Mahasiswa mhs) {
        this.tampilkanNama2();
        return mhs;
    }
    
    public String nama() {
        return "";
    }
    
    public void tampilkanNama2() {
        
    }
    
    protected static void test() {
        BelajarMethod b = new BelajarMethod();
        b.tampilkanNama2();
        System.out.println("ini static");
    }
    
}
