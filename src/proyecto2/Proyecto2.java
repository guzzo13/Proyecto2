/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import Clases.LoadTXT;
import Clases.Summary;
import EDD.HashTable;
import EDD.List;
import Interfaces.MainMenu;
import java.io.File;

/**
 *
 * @author guzzo
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String filePath = "src\\DB\\summaries.txt";
        File file = new File(filePath);
        
        if(file.exists() && file.length() == 0){
            MainMenu mn = new MainMenu();
            mn.setVisible(true);            
        }
        else{
            HashTable htTitle = new HashTable(100);
            HashTable htKeywords = new HashTable(100);
            HashTable htAuthors = new HashTable(100);
            LoadTXT.load(htTitle, htKeywords, htAuthors);
            
            MainMenu mn = new MainMenu(htTitle, htKeywords, htAuthors);
            mn.setVisible(true);
        }
        
        
        
        
        
        
        
        
        
    }
    
}
