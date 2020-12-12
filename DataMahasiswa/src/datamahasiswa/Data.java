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
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Date;



public class Data {
    SimpleDateFormat formatdate = new SimpleDateFormat("dd/MMM/YYYY");
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<String> nim = new ArrayList<>();
    ArrayList<Integer> gender = new ArrayList<>();
    ArrayList<Date> tglLahir = new ArrayList<>();
    
    void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("        MEMASUKKAN DATA       ");
        System.out.println("------------------------------");
        System.out.print("Masukkan Nama : ");
        String inputnama = input.nextLine();
        System.out.print("Masukkan NIM  : ");
        String inputnim = input.nextLine();
        System.out.println("Tanggal Lahir (dd-mm-yyyy)");
        System.out.print("Hari  : ");
        int d = input.nextInt();
        System.out.print("Bulan : ");
        int m = input.nextInt();
        System.out.print("Tahun : ");
        int y = input.nextInt();
        Date tgllhr = new GregorianCalendar(y, m -1, d).getTime();
        System.out.println("Laki-laki : 1 / Perempuan : 2");
        System.out.print("Jenis Kelamin : ");
        int kelamin = input.nextInt();
        nama.add(inputnama);
        nim.add(inputnim);
        tglLahir.add(tgllhr);
        gender.add(kelamin);
        System.out.println("Data Berhasil Dimasukkan!");
    }
    void delete() {
        Scanner input = new Scanner(System.in);
        if (nim.isEmpty() == false) {
            try {
                System.out.println("------------------------------");
                System.out.println("          HAPUS DATA          ");
                System.out.println("------------------------------");
                System.out.print("Masukkan NIM\t: ");
                String nimHapus = input.next();
                int x = Collections.binarySearch(nim, nimHapus);
                nama.remove(x);
                nim.remove(x);
                tglLahir.remove(x);
                gender.remove(x); 
                System.out.println("------------------------------");
                System.out.println("         Data Dihapus         ");
                System.out.println("------------------------------");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("------------------------------");
                System.out.println("     Data Tidak Ditemukan     ");
                System.out.println("------------------------------");
            }
        }
        else {
            System.out.println("------------------------------");
            System.out.println("        Data Belum Ada        ");
            System.out.println("------------------------------");
        }
    }
    void find() {
        Scanner input = new Scanner(System.in);
        if (nim.isEmpty() == false) {
            System.out.println("------------------------------");
            System.out.println("          CARI DATA          ");
            System.out.println("------------------------------");
            System.out.println("Berdasarkan : ");
            System.out.println("1. NIM");
            System.out.println("2. Jenis Kelamin");
            System.out.println("------------------------------");
            System.out.print("Masukkan Pilihan : ");
            switch(input.nextLine()) {
                case "1": {
                    try {
                        System.out.print("Masukkan NIM : ");
                        String cariNim = input.next();
                        int target = Collections.binarySearch(nim, cariNim);
                        String cariNama = nama.get(target);
                        String cariNIM =  nim.get(target);
                        String cariTgllhr = formatdate.format(tglLahir.get(target));
                        String carigender = (gender.get(target) == 1) ? "Laki-Laki" : "Perempuan";
                        
                        System.out.println("Nama\t: "+ cariNama);
                        System.out.println("NIM\t: "+ cariNIM);
                        System.out.println("Tanggal Lahir\t: "+ cariTgllhr);
                        System.out.println("Jenis Kelamin\t: "+ carigender);
                        
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("------------------------------");
                        System.out.println("     Data Tidak Ditemukan     ");
                        System.out.println("------------------------------");
                    }
                    break;
                }
                case "2": {
                    System.out.println("Laki-laki : 1 / Perempuan : 2");
                    System.out.print("Masukkan Jenis Kelamin : ");
                    int carigender = input.nextInt();
                    for (int x = 0; x < gender.size(); x++) {
                        if (gender.get(x) == carigender) {
                            String cariNama = nama.get(x);
                            String cariNIM =  nim.get(x);
                            String cariTgl = formatdate.format(tglLahir.get(x));
                            String carigenderr = (gender.get(x) == 1) ? "Laki-Laki" : "Perempuan";
                    
                            System.out.println("Nama\t: "+ cariNama);
                            System.out.println("NIM\t: "+ cariNIM);
                            System.out.println("Tanggal Lahir\t: "+ cariTgl);
                            System.out.println("Jenis Kelamin\t: "+ carigenderr);
                            System.out.println("------------------------------");
                        }   
                    }  
                }
            }
        }
        else {
            System.out.println("------------------------------");
            System.out.println("        Data Belum Ada        ");
            System.out.println("------------------------------");
        }
    }
    void show() {
        if (nama.isEmpty() == false) {
            System.out.println("------------------------------");
            System.out.println("        TAMPILKAN DATA        ");
            System.out.println("------------------------------");
            for (int x = 0; x<nama.size(); x++) {
                String showNama = nama.get(x);
                String showNIM =  nim.get(x);
                String showTgllhr = formatdate.format(tglLahir.get(x));
                String showgender = (gender.get(x) == 1) ? "Laki-Laki" : "Perempuan";
                System.out.println("Mahasiswa "+ (x+1));
                System.out.println("------------------------------");
                System.out.println("Nama\t: "+ showNama);
                System.out.println("NIM\t: "+ showNIM);
                System.out.println("Tanggal Lahir\t: "+ showTgllhr);
                System.out.println("Jenis Kelamin\t: "+ showgender);
                System.out.println("------------------------------");
            }
        }
        else {
            System.out.println("------------------------------");
            System.out.println("        Data Belum Ada        ");
            System.out.println("------------------------------");
        }
        System.out.println("------------------------------");
        System.out.println("Jumlah Data : "+ nama.size());
        System.out.println("------------------------------");
    }
}
