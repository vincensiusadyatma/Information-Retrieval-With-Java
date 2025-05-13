package com.informationretrieval;

import java.util.List;

public class Term implements Comparable<Term> {
    private String name;
    private int df;
    private double idf;

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

    public double getIdf() {
      return this.idf;
    }
    public void setIdf(int value) {
      this.idf = value;
    }

    public void addDoc(Document doc){
      this.DocOrdered.addSort(doc);
      calculateDF();
    }

    public List<Document> getDocList(){
        return this.DocOrdered;
    }

    public int compareTo(Term other_doc) {
      return this.name.compareTo(other_doc.name);
    }

    public void calculateDF(){
      this.df = DocOrdered.size();
    }

    public void calculateIDF(int totaldocs){
      this.idf = Math.log10( (double) totaldocs/this.DocOrdered.size());
    }

    
}
