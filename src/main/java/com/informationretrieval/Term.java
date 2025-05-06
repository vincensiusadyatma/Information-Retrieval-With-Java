package com.informationretrieval;

import java.util.List;

public class Term {
    private String name;
    private int df;
    private int idf;

    private DoclistOrdered<Document> DocOrdered = new DoclistOrdered<>(); 

    public Term(String name){
        this.name = name;
        this.df = 0;
        this.idf = 0;
    }

    public String getName() {
      return this.name;
    }
    public void setName(String value) {
      this.name = value;
    }

    public int getDf() {
      return this.df;
    }
    public void setDf(int value) {
      this.df = value;
    }

    public int getIdf() {
      return this.idf;
    }
    public void setIdf(int value) {
      this.idf = value;
    }

    public void addDoc(Document doc){
      this.DocOrdered.addSort(doc);
    }

    public List<Document> getDocList(){
        return this.DocOrdered;
    }

    
}
