package com.informationretrieval;

public class Document {
    private String name;
    private int tf;

    public Document(String name){
        this.name = name;
        this.tf = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setTf(int tf){
        this.tf = tf;
    }

    public int getTf(){
        return this.tf;
    }
}
