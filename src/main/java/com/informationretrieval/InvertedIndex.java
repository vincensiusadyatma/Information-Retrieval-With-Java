package com.informationretrieval;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
    private Map<String,Set<String>> invertedMap = new HashMap<>();

    public void addTerm(String docs, String[] tokens){
        System.out.println(docs.substring(0,docs.lastIndexOf(".")) + " : " + tokens.length);
        docs =  docs.substring(0,docs.lastIndexOf('.'));
        for (String token : tokens) {
            if (invertedMap.containsKey(token)) {
                invertedMap.get(token).add(docs);
            }else{
                invertedMap.put(token, new HashSet<>());
                invertedMap.get(token).add(docs);
            }
        }
    }

    public Map<String,Set<String>> getMap(){
        return this.invertedMap;
    }

}
