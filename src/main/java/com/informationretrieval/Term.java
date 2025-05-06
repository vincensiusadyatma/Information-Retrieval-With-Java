package com.informationretrieval;

public class Term {
    private String name;
    private int df;
    private int idf;

    private DoclistOrdered<String> DocOrdered = new DoclistOrdered<>(); 

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
}
