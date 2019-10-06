/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

import Praktikum2.ReadStreamPushBackReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PushbackReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author User
 */
public class TugasController {
    
    private final Tugas view;
    
    public TugasController(Tugas view) {
        this.view = view;
        
            this.view.getBtnBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    proses();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadLocationException ex) {
                    Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }) ;
        
        this.view.getBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
    
    private void proses() throws FileNotFoundException, BadLocationException{
        JFileChooser loadFile = view.getLoadFile();
        StyledDocument doc = view.getTxtPane().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            PushbackReader  reader = new PushbackReader(new FileReader(loadFile.getSelectedFile()));
            LineNumberReader re = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));
        
            char[] words = new char[(int) loadFile.getSelectedFile().length()];
            
            try {
                reader.read(words);
                
                String data = null;
                String data1 = null;
                doc.insertString(0, "", null);
                
                int hitungKarakter = 0;
                int hitungKata = 0;
                
                if((data = new String(words)) != null) {
                String[] wordlist = data.split("\\s+");
                
                hitungKarakter += words.length;
                hitungKata += wordlist.length;
                
                doc.insertString(doc.getLength(), "" +data+ "\n", null);
            }
                while((data1 = re.readLine()) != null){
                       
                    }
                     int hitungBaris = re.getLineNumber();
                    
                JOptionPane.showMessageDialog(null, "File Berhasil dibaca." + "\n"
                        + "Jumlah baris = " + hitungBaris + "\n"
                        + "Jumlah kata = " + hitungKata + "\n"
                        + "Jumlah karakter = " + hitungKarakter);
                    
                } catch (IOException ex) {
                    Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
                }
         
        }
    }
    
    private void simpan() {
        JFileChooser loadFile = view.getLoadFile();
        if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
            BufferedWriter writer = null;
            try {
                String contents = view.getTxtPane().getText();
                if (contents != null && !contents.isEmpty()) {
                    writer = new BufferedWriter(new FileWriter(loadFile.getSelectedFile()));
                    writer.write(contents);
                }
                JOptionPane.showMessageDialog(null, "File Berhasil disimpan.");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (writer != null) {
                    try {
                        writer.flush();
                        writer.close();
                        view.getTxtPane().setText("");
                    } catch (IOException ex) {
                        Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}

    
    

