package com.informationretrieval;

import java.util.HashMap;
import java.util.Map;

public class CosineSimilarity {
    public Map<String,Double> compute(Map<String, Map<String, Double>> tfidfMatrix, Map<String, Map<String, Double>> queryVector){


        return null;
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
}
