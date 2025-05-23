package com.informationretrieval;

public class Document implements Comparable<Document> {
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
    public int compareTo(Document other_doc) {
        return this.name.compareTo(other_doc.name);
    }

    public void calculateTF(String token,String[] tokens){
        for (String term : tokens) {
            if (term.equals(token)) {
                this.tf++;
            }
        }
    }
}
