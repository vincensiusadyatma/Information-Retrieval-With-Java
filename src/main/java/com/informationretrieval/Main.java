package com.informationretrieval;

public class Main {
    public static void main(String[] args) {
        ReadFile readCorpus = new ReadFile("documents");
        readCorpus.read();
    }
}
