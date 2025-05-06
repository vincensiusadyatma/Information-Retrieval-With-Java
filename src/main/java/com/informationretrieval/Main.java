package com.informationretrieval;

public class Main {
    public static void main(String[] args) {
        // ReadFile readCorpus = new ReadFile("documents");
        // readCorpus.read();
        // readCorpus.printMap();
        DoclistOrdered<String> ordered1 = new DoclistOrdered<>();
     
        ordered1.addSort("lumpia");
        ordered1.addSort("soto");
        ordered1.addSort("semarang");
        ordered1.addSort("rabu");
        System.out.println(ordered1.toString());
        // System.out.println(ordered1.toString());
    }
}
