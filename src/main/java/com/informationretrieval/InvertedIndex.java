package com.informationretrieval;

import java.util.HashMap;

import java.util.Map;
public class InvertedIndex {
  
    private DoclistOrdered<Term> invertedList = new DoclistOrdered<>();

    public void addTerm(Term term){
        this.invertedList.addSort(term);
    }

    public Map<String,Map<String,Double>> computeTFIDF(){
        Map<String,Map<String,Double>> matriks = new HashMap<>();
        for (Term term : invertedList) {
          matriks.put(term.getName(), new HashMap<>() );
          for (Document doc : term.getDocList()) {
            double tfidf = doc.getTf() * term.getIdf();
            matriks.get(term.getName()).put(doc.getName(), tfidf);
          }
        }
        return matriks;
    }

    public double computeTFIDFquery(){
         Map<String,Map<String,Double>> matriks = new HashMap<>();
        return 0;
    }

    

 
    public DoclistOrdered<Term> getInvertedList() {
      return this.invertedList;
    }
    public void setInvertedList(DoclistOrdered<Term> value) {
      this.invertedList = value;
    }
}
