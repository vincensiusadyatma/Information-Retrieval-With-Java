package com.informationretrieval;

// import java.util.ArrayList;
// import java.util.List;
public class Main {
    public static void main(String[] args) {
     
        ReadFile readCorpus = new ReadFile("documents");
        InvertedIndex invertedListCorpus = readCorpus.read();
        
        // System.out.println(invertedListCorpus.computeTFIDF());
        // System.out.println(invertedListCorpus.computeTFIDFquery("semarang"));
        CosineSimilarity similarity = new CosineSimilarity();
        similarity.compute(invertedListCorpus.computeTFIDF(), invertedListCorpus.computeTFIDFquery("aku suka main api dengan teman saya"));
        similarity.printResult();
        // System.out.println(similarity.countVectorLenght(invertedListCorpus.computeTFIDF()));
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
