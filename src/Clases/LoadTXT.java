/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.HashTable;
import EDD.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author guzzo
 */
public class LoadTXT {
        
    
        private static String getPath(){
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("C:\\Users\\juann\\OneDrive\\Escritorio"));
            
            int result = fc.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath(); 
                
                String[] array = filePath.split("\\\\");
                String fileStr = array[array.length-1];
                if(!fileStr.contains(".txt")){
                    JOptionPane.showMessageDialog(null, "El archivo seleccionado no es valido");
                    return getPath();
                }
                else{
                    return filePath;                                        
                }
                
            }
            return null;
        }
            
        /***
         * Leer resumen
         * @return Summary
         */
        public static Summary read() {           
            String filePath = getPath();
            if(filePath != null){                
                try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
                    String line;

                    boolean isTitle = true;
                    boolean isAuthor = false;
                    boolean isBody = false;
                    boolean isKeywords = false;

                    String title = "";
                    String authors = "";
                    String body = "";
                    String keywords = "";

                    while ((line = br.readLine()) != null) {
                        if(!line.isBlank()){
                            if(isTitle){
                                title += line + "\n";
                                isTitle = false;
                                isAuthor = true;
                            }
                            else if(isAuthor){
                                if(line.equals("Resumen")){
                                    isAuthor = false;
                                    isBody = true;
                                }
                                else if(!line.contains("Autores")){
                                    authors += line + "\n";
                                }
                            }
                            else if(isBody){
                                if(line.contains("Palabras claves:")){
                                    keywords = line.split(": ")[1];                                
                                }
                                else{
                                    body += line;                                
                                }                            
                            }
                        }

                    }

                    Summary summary = new Summary(title, authors, body, keywords);
                    return summary;

                } catch (IOException e) {
                    System.err.println("Error al leer el archivo: " + e.getMessage());
                    e.printStackTrace();
                }
            }            
            
            return null;
        }
        
        
        /***
         * 
         * @param ht 
         */
        public static void save(HashTable ht){                
            String rutaArchivo =  "src\\DB\\summaries.txt";             
            
            List<Summary>[] table = ht.getTable();
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))){
                for (List<Summary> bucket: table){ 

                    if(bucket != null){                    

                        if(bucket.getSize() == 1){
                            Summary summary = bucket.get(0);
                            writer.write(summary.getTitle());                            
                            writer.write("\nAutores\n");
                            writer.write(summary.getAuthor());                            
                            writer.write("\nResumen\n");
                            writer.write(summary.getBody());
                            writer.write("\n\nPalabras claves: " + summary.getKeywords());
                            writer.write("\nSeparador\n");

                        }

                        else if(bucket.getSize() > 1){

                            for (int i = 0; i < bucket.getSize(); i++) {
                                Summary summary = bucket.get(i);
                                writer.write(summary.getTitle());                            
                                writer.write("\nAutores\n");
                                writer.write(summary.getAuthor());                            
                                writer.write("\nResumen\n");
                                writer.write(summary.getBody());
                                writer.write("\n\nPalabras claves: " + summary.getKeywords());
                                writer.write("\nSeparador\n");
                            }                        

                        }
                    }                               
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }  
        
        
        public static void load(HashTable ht1, HashTable ht2, HashTable ht3){
            String filePath = "src\\DB\\summaries.txt";
                           
            try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath)))) {
                String line;

                boolean isTitle = true;
                boolean isAuthor = false;
                boolean isBody = false;
                boolean isKeywords = false;

                String title = "";
                String authors = "";
                String body = "";
                String keywords = "";

                while ((line = br.readLine()) != null) {
                    if(!line.isBlank()){
                        if(isTitle){
                            title += line + "\n";
                            isTitle = false;
                            isAuthor = true;
                        }
                        else if(isAuthor){
                            if(line.equals("Resumen")){
                                isAuthor = false;
                                isBody = true;
                            }
                            else if(!line.contains("Autores")){
                                authors += line + "\n";
                            }
                        }
                        else if(isBody){
                            if(line.contains("Palabras claves:")){   
                                isBody = false;
                                isKeywords = true;
                                keywords = line.split(": ")[1];                                
                            }
                            else{
                                body += line;                                
                            }                            
                        }
                        else if(isKeywords){
                            if(line.contains("Separador")){

                                
                                Summary summary = new Summary(title, authors, body, keywords);
                                ht1.add(summary, 1);
                                ht2.add(summary, 2);
                                ht3.add(summary, 3);
                                
                                title = "";
                                authors = "";
                                body = "";
                                keywords = "";
                                isTitle = true;
                                isAuthor = false;
                                isBody = false;
                                isKeywords = false;                                
                            }
                        }
                    }

                }


            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
                e.printStackTrace();
            }

        }
        
        
        
        
    
}
