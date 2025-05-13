package com.informationretrieval;

import java.util.Arrays;
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

    public Map<String,Map<String,Double>> computeTFIDFquery(String query){
         Map<String,Map<String,Double>> matriks = new HashMap<>();
         String[] tokens = Tokenizer.tokenize(query);

         for (String token : tokens) {
            // Term term = new Term(token);
            for (Term term_from_inverted : this.invertedList) {
               
                if (term_from_inverted.getName().equals(token)) {
                  double idf = term_from_inverted.getIdf();
                  System.out.println(term_from_inverted.getName());
                  System.out.println("df : " + term_from_inverted.getDf());
                  Document doc = new Document("query");
                  doc.calculateTF(token, tokens);
                  System.out.println("idf : " + idf);
                  System.out.println("tf : " +   doc.getTf());
                  double tfidf = doc.getTf() * idf;
                  matriks.put(token, new HashMap<>());
                  matriks.get(token).put(doc.getName(), tfidf);

                  
                  // int tf = term_from_inverted
                }
            }
         }
         System.out.println(Arrays.toString(tokens));

        return matriks;
    }

    public DoclistOrdered<Term> getInvertedList() {
      return this.invertedList;
    }

    public void setInvertedList(DoclistOrdered<Term> value) {
      this.invertedList = value;
    }
}
