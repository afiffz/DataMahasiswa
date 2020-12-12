/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;

/**
 *
 * @author afiff
 */

import java.util.Scanner;

public class Menu {
    boolean x = true;
    Scanner input = new Scanner(System.in);
    
    void mainMenu() {
        
        Data menu = new Data();
        while(x) {
            System.out.println("------------------------------");
            System.out.println("      Data Mahasiswa PTIK     ");
            System.out.println("------------------------------");
            System.out.println("Menu Program:");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Menghapus Data");
            System.out.println("3. Mencari Data");
            System.out.println("4. Menampilkan Data");
            System.out.println("5. Keluar");
            System.out.println("------------------------------");
            System.out.print("Masukkan Pilihan Anda : ");
            
            switch(input.nextLine()) {
                
                case "1": {
                    menu.add();
                    break;
                }
                case "2": {
                    menu.delete();
                    break;
                }
                case "3": {
                    menu.find();
                    break;
                }    
                case "4": {
                    menu.show();
                    break;
                }
                case "5": {
                    System.out.println("------------------------------");
                    System.out.println("         Terima Kasih         ");
                    System.out.println("------------------------------");
                    x = false;
                    break;
                }
                default : {
                    System.out.println("------------------------------");
                    System.out.println("        Menu Tidak Ada        ");
                    System.out.println("------------------------------");
                }
            }
        }
    }
}
