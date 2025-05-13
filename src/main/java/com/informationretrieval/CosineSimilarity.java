package com.informationretrieval;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CosineSimilarity {
    Map<String,Double> resultSimilarity;
    
    public Map<String,Double> compute(Map<String, Map<String, Double>> tfidfMatrix, Map<String, Map<String, Double>> queryVector){
        // System.out.println(tfidfMatrix);
        // System.out.println(queryVector);
        Map<String,Double> docSimilarityMatrix = new HashMap<>();
        Map<String,Double> docCosineSimilarityMatrix = new HashMap<>();
        for (Map.Entry<String, Map<String, Double>> entry : queryVector.entrySet()) {
            String queryKey = entry.getKey();
          
            // System.out.println(queryKey);
            // System.out.println(entry.getValue());
            for (Map.Entry<String, Map<String, Double>> docTfidfEntry : tfidfMatrix.entrySet()) {
                if (docTfidfEntry.getKey().equals(queryKey)) {
                    // System.out.println(docTfidfEntry.getKey());
                    // System.out.println(docTfidfEntry.getValue());
                    for (Map.Entry<String,Double> doc : docTfidfEntry.getValue().entrySet()) {
                        // System.out.println(doc.getKey());
                         if (docSimilarityMatrix.containsKey(doc.getKey())) {
                              docSimilarityMatrix.put(doc.getKey(),  docSimilarityMatrix.get(doc.getKey()) + ( doc.getValue() * entry.getValue().get("query")));
                            
                        }else{
                           docSimilarityMatrix.put(doc.getKey(), doc.getValue() * entry.getValue().get("query"));
                        }
                    }
                   

                }
            }
        }
        Map<String,Double> tfidflenght = countVectorLenght(tfidfMatrix);
        Map<String,Double> querylenght = countVectorLenght(queryVector);
        // System.out.println(docSimilarityMatrix);
        // for (iterable_type iterable_element : iterable) {
        for (Map.Entry<String, Double> docSimilarity : docSimilarityMatrix.entrySet()) {
            // System.out.println(docSimilarity.getKey());
            docCosineSimilarityMatrix.put(docSimilarity.getKey(), docSimilarity.getValue()/(tfidflenght.get(docSimilarity.getKey()) *  querylenght.get("query")));

        }
        // }
        // System.out.println(tfidflenght);
        // System.out.println(docCosineSimilarityMatrix);
        this.resultSimilarity = new TreeMap<>(docCosineSimilarityMatrix);
        return docCosineSimilarityMatrix;
    }


    public Map<String,Double> countVectorLenght(Map<String, Map<String, Double>> tfidfMatrix){
        // System.out.println(tfidfMatrix.entrySet());
        Map<String,Double> docVectorList = new HashMap<>();
         for (Map.Entry<String, Map<String, Double>> entry : tfidfMatrix.entrySet()) {

            //menjumlahkan tfidf pada setiap doc pada term tertentu
            for (Map.Entry<String, Double> innerEntry : entry.getValue().entrySet()) {
                String docKey = innerEntry.getKey();
                Double tfidfValue = innerEntry.getValue();
                if (docVectorList.containsKey(docKey)) {
                    docVectorList.put(docKey, docVectorList.get(docKey) + Math.pow(tfidfValue, 2));
                }else{
                    docVectorList.put(docKey,Math.pow(tfidfValue, 2));
                }
            }

            //melakukan akar pada hasil penjumlahan tf idf
            for (Map.Entry<String, Double> vector_entry : docVectorList.entrySet()) {
                Double finalLenght = Math.sqrt(vector_entry.getValue());
                docVectorList.put(vector_entry.getKey(), finalLenght);
            }
        }
        return docVectorList;
    }

   public void printResult() {
    if (resultSimilarity == null || resultSimilarity.isEmpty()) {
        System.out.println("No similarity results available.");
    }
    resultSimilarity.entrySet().stream().sorted((e1, e2) -> {
            int num1 = Integer.parseInt(e1.getKey().replaceAll("[^0-9]", ""));
            int num2 = Integer.parseInt(e2.getKey().replaceAll("[^0-9]", ""));
            return Integer.compare(num1, num2);
        }).forEach(entry -> 
            System.out.printf("%s -> %.6f\n", entry.getKey(), entry.getValue())
        );
    }

}
