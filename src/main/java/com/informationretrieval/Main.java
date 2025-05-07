package com.informationretrieval;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        ReadFile readCorpus = new ReadFile("documents");
        System.out.println( readCorpus.read().get(1).getDocList().size());
        // readCorpus.printMap();
        // DoclistOrdered<String> ordered1 = new DoclistOrdered<>();
     
        // ordered1.addSort("lumpia");
        // ordered1.addSort("soto");
        // ordered1.addSort("semarang");
        // ordered1.addSort("rabu");
        // System.out.println(ordered1.toString());

        // SimpleHashTable tabel1 = new SimpleHashTable();
        // // System.out.println(tabel1.hash("y"));

        // tabel1.addTerm(null);
        // // System.out.println(ordered1.toString());
   
        // List<Integer> listAngka = new ArrayList<>();
        // for (int i : listAngka) {
        //     System.out.println(i);
        // }

    }
}
