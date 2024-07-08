/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Summary;

/**
 *
 * @author guzzo
 */
public class HashTable<T> {
    private List[] table;
    private int numSummaries;
    static final int TITLE = 1;
    static final int KEYWORDS = 2;
    static final int AUTHORS = 3;

    public HashTable(int size) {
        this.table = new List[size];
        this.numSummaries = 0;
    }

    public List[] getTable() {
        return table;
    }

    public void setTable(List[] table) {
        this.table = table;
    }

    public int getNumSummaries() {
        return numSummaries;
    }

    public void setNumSummaries(int numSummaries) {
        this.numSummaries = numSummaries;
    }
    
    
    
    
    
    public int hash(String str){
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            idx += c;
        }
        
        return idx % table.length;
    }
    
    
    
    public void add(Summary summary, int option){
        switch(option){
            case TITLE:
                addWithTitle(summary);
                break;
               
            case KEYWORDS:
                addWithKeywords(summary);
                break;
            
            case AUTHORS:
                addWithAuthors(summary);
                break;
                        
        }
    }
    
    
    public void addWithTitle(Summary summary){
        int idx = this.hash(summary.getTitle().replace("\n", ""));
        System.out.println(idx);
        
        List bucket = table[idx];
        if(bucket == null){
            table[idx] = new List(summary);
        }
        else{
            bucket.append(summary);
        }
        
        this.numSummaries++;
    }
    
    
    public void addWithKeywords(Summary summary){
        String[] keywords = summary.getKeywords().split(", ");
        
        for(String keyword: keywords){
            int idx = this.hash(keyword);

            List bucket = table[idx];
            if(bucket == null){
                table[idx] = new List(summary);
            }
            else{
                bucket.append(summary);
            }

            this.numSummaries++;            
        }
    }
    
    public void addWithAuthors(Summary summary){
        String[] authors = summary.getAuthor().split("\n");        
        
        for(String author: authors){            
            int idx = this.hash(author.trim());

            List bucket = table[idx];
            if(bucket == null){
                table[idx] = new List(summary);
            }
            else{
                bucket.append(summary);
            }

            this.numSummaries++;            
        }
    }
    
    
    public void delete(String title){
        int idx = this.hash(title);
        
        List<Summary> bucket = table[idx];
        if(bucket == null){
            System.out.println("El elemento no existe en la tabla");
        }
        else{
            if(bucket.getSize() == 1){
                table[idx] = null;
            }
            else if(bucket.getSize() > 1){
                for (int i = 0; i < bucket.getSize(); i++) {
                    Summary auxSummary = bucket.get(i);
                    if(auxSummary.getTitle().equals(title)){
                        bucket.pop(i);
                        break;
                    }
                }
            }
        }
        
        this.numSummaries--;
    }
    
    
    public Summary get(String title){
        int idx = this.hash(title);
        
        List<Summary> bucket = table[idx];
        if(bucket == null){
            System.out.println("El elemento no existe en la tabla");
        }
        else{
            if(bucket.getSize() == 1){
                return bucket.get(0);
            }
            else if(bucket.getSize() > 1){
                for (int i = 0; i < bucket.getSize(); i++) {
                    Summary auxSummary = bucket.get(i);
                    if(auxSummary.getTitle().equals(title)){
                        return auxSummary;
                    }
                }
            }
        }
        return null;
    }
    

    
    
    
    
    
}
