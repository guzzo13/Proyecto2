/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metromendeley;

import Clases.CargarTxt;
import static Clases.CargarTxt.leerArchivo;
import Estructuras.Lista;
import java.io.IOException;

/**
 *
 * @author guzzo
 */
public class MetroMendeley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      
        CargarTxt txt = new CargarTxt();
        
        txt.leerArchivo("C:\\Users\\guzzo\\OneDrive\\Escritorio\\prueba.txt");
        System.out.println(txt.leerArchivo("C:\\Users\\guzzo\\OneDrive\\Escritorio\\prueba.txt"));

    }
    
}
