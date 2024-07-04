/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author guzzo
 */
public class Lista<T> {
    private Nodo head;
    private Nodo tail;
    private int size;

    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public Lista(T... elements) {
        for(T data: elements){
            append(data);
        }
    }
    
    

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    
    public void append(T data){
        Nodo newNodo = new Nodo(data);
        if(isEmpty()){
            this.head = this.tail = newNodo;
        }
        else{
            this.tail.setNext(newNodo);
            this.tail = newNodo;
        }
        this.size++;
    }
    
    public void preappend(T data){
        Nodo newNodo = new Nodo(data);
        if(isEmpty()){
            this.head = this.tail = newNodo;
        }
        else{
            newNodo.setNext(this.head);
            this.head = newNodo;
        }
        this.size++;
    }
    
    public void insert(int idx, T data){
        Nodo newNodo = new Nodo(data);
        if(!isEmpty()){
            if(idx < 0 && idx > this.size - 1){
                System.out.println("Error: indice fuera de rango");
            }
            else{
                if(idx == 0){
                    preappend(data);
                }
                else{
                    Nodo pointer = this.head;
                    for (int i = 0; i < idx-1; i++) {
                        pointer = pointer.getNext();
                    }
                    newNodo.setNext(pointer.getNext());
                    pointer.setNext(newNodo);
                    this.size++;
                }
            }
        }
    }
    
    
    public void pop(int idx){
        if(!isEmpty()){
            if(idx < 0 && idx > this.size - 1){
                System.out.println("Error: indice fuera de rango");
            }
            else{
                if(idx == 0){
                    this.head = this.head.getNext();
                    this.size--;
                }
                else if(idx == size-1){
                    Nodo pointer = this.head;
                    for (int i = 0; i < this.size-2; i++) {
                        pointer = pointer.getNext();
                    }
                    pointer.setNext(null);
                    this.tail = pointer;
                    this.size--;                    
                }
                else{
                    Nodo pointer = this.head;
                    for (int i = 0; i < idx-1; i++) {
                        pointer = pointer.getNext();
                    }
                    pointer.setNext(pointer.getNext().getNext());
                    this.size--;
                }
            }
        }
    }
    
    
    public void print(){
        Nodo pointer = this.head;
        while(pointer != null){
            System.out.println(pointer.getData());
            pointer = pointer.getNext();
        }
    }
    
    public T get(int idx){
        if(!isEmpty()){
            if(idx < 0 && idx > this.size - 1){
                System.out.println("Error: indice fuera de rango");
            }
            else{
                if(idx == 0){
                    return (T) this.head.getData();
                }
                else if(idx == size-1){
                    return (T) this.tail.getData();
                }
                else{
                    Nodo pointer = this.head;
                    for (int i = 0; i < idx; i++) {
                        pointer = pointer.getNext();
                    }
                    return (T) pointer.getData();
                    
                }
            }
        }
        return null;
    }
    

    
    
    
    
}
