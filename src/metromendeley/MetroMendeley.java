/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metromendeley;

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
    public static void main(String[] args) {
        // TODO code application logic here
        Lista lista = new Lista(1, 2, 3, 4, 5, 6);
        
        
        
        
        lista.pop(5);
        lista.print();
        
        
        System.out.println(lista.get(3));
        

    }
    
}
