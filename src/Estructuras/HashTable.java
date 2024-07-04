/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Clases.Resumen;

/**
 *
 * @author guzzo
 */
public class HashTable<T> {
    private Lista[] tabla;

    public HashTable(int tamaño) {
        this.tabla = new Lista[tamaño];
    }

    public Lista[] getTabla() {
        return tabla;
    }

    public void setTabla(Lista[] tabla) {
        this.tabla = tabla;
    }
    
    
    
    public int hash(String titulo){
        int idx = 0;
        for (int i = 0; i < titulo.length(); i++) {
            char c = titulo.charAt(i);
            idx += c;
        }
        
        return idx % tabla.length;
    }
    
    
    public void agregar(Resumen resumen){
        int idx = hash(resumen.getTitulo());
        if(tabla[idx] == null){
            tabla[idx] = new Lista(resumen);
        }
        else{
            Lista bucket = tabla[idx];
            bucket.append(resumen);
        }
    }
    
    public void eliminar(Resumen resumen){
        int idx = hash(resumen.getTitulo());
        if(tabla[idx] == null){
            System.out.println("El elemento no se encuentra en el hashtable");
        }
        else{
            Lista bucket = tabla[idx];
            if(bucket.getSize() == 1){
                tabla[idx] = null;
            }
            else{
                for (int i = 0; i < 10; i++) {
                    Resumen aux = (Resumen) bucket.get(i);
                    if(aux.getTitulo().equals(resumen.getTitulo())){
                        bucket.pop(i);
                    }
                }   
            }
        }
    }
    
    public Resumen obtener(String titulo){
        int idx = hash(titulo);
        if(tabla[idx] == null){
            System.out.println("El elemento no se encuentra en el hashtable");
        }
        else{
            Lista bucket = tabla[idx];
            if(bucket.getSize() == 1){
                return (Resumen) bucket.get(0);
            }
            else{
                for (int i = 0; i < 10; i++) {
                    Resumen aux = (Resumen) bucket.get(i);
                    if(aux.getTitulo().equals(titulo)){
                        return (Resumen) bucket.get(i);
                    }
                }   
            }
        }
        return null;
    }
    
    

}