package com.informationretrieval;

import java.util.HashMap;

import java.util.Map;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.List;

public class InvertedIndex {
    private Map<String,SortedSet<String>> invertedMap = new HashMap<>();
    private DoclistOrdered<Term> invertedList = new DoclistOrdered<>();

    public void addTerm(String docs, String[] tokens){
        System.out.println(docs.substring(0,docs.lastIndexOf(".")) + " : " + tokens.length);
        docs =  docs.substring(0,docs.lastIndexOf('.'));
        for (String token : tokens) {
            if (invertedMap.containsKey(token)) {
                invertedMap.get(token).add(docs);
            }else{
                invertedMap.put(token, new TreeSet<>());
                invertedMap.get(token).add(docs);
            }
        }
    }

    public void addTerm(List<Term> termList){
        for (Term term : termList) {
            this.invertedList.addSort(term);
        }
    }

    public Map<String,SortedSet<String>> getMap(){
        return this.invertedMap;
    }

}
