/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ReadStreamPushBackReader2 {
    public static void main(String[] args) {
                    
                     try {
                         
                         File f = new File("coba.txt");
                         PushbackReader pushback = new PushbackReader(new FileReader(f));
                         
                         char [] words1 = new char[(int) f.length()];
                      
                         pushback.read(words1);
                         
                         System.out.println(new String(words1));
                         
                         pushback.unread((int)words1 [5]);
                         pushback.read(words1);
                         
                         System.out.println(new String(words1));
                        
                     } catch (IOException ex) {
                         Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
                     }
    }    
}
