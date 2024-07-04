/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CargarTxt {

    public static String leerArchivo(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        String linea;

        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader lectorBuffer = new BufferedReader(isr)) {

            while ((linea = lectorBuffer.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }

        return contenido.toString();
    }
}

    



