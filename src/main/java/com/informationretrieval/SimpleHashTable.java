package com.informationretrieval;

import java.util.ArrayList;
import java.util.List;

public class SimpleHashTable {
    private final int SIZE = 1_000_000;
    List<String> table = new ArrayList<>(SIZE);

    public int hash(String term){
        return Math.abs(term.hashCode() % SIZE);
    }

    public void addTerm(Term term){
        String token = term.getName();
        int hash_index = this.hash(token);
        

    }
}
