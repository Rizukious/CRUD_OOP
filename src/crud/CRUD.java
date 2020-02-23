/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.List;

/**
 *
 * @author baydhowi21
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MahasiswaCtrl ctrl = new MahasiswaCtrl();
        List<Mahasiswa> listMhs = ctrl.getAllLists();
        for (Mahasiswa mhs: listMhs) {
            System.out.println("NIM: " + mhs.getNim());
            System.out.println("Nama: " + mhs.getNama());
        }
    }
    
}
