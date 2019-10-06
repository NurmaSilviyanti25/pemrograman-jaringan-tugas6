/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ReadStreamPushBackInputStream {
    public static void main(String[] args) {
        
                  //PushbackInputStream stream = new PushbackInputStream(System.in);
                 //System.out.print("Masukan karakter apapun: ");
                 try {
                     //Baca file coba.txt menggunakan class PushbackInputStream tanpa menggunakan perulangan
                     PushbackInputStream stream1 = new PushbackInputStream (new FileInputStream("coba.txt"));
                     
                     int read = stream1.read();
                     stream1.unread(read);
                     int read2 = stream1.read();
                     System.out.println("" + (char) read);
                     System.out.println("" + (char) read2);
                 } catch (IOException ex) {
                     Logger.getLogger(ReadFilePushBackInputStream.class.getName()).log(Level.SEVERE, null, ex);
                 }
    }
    
}

//Jawaban
//Ada perbedaan, karena penambahan method unread(read) jadi karakter akan dicek ulang sehingga output karakter
//yang dimasukkan akan double atau akan muncul dua kali.

