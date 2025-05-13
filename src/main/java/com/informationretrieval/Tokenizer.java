package com.informationretrieval;



public class Tokenizer {
    public static String[] tokenize(String content){
        String[] tokens = content.toLowerCase().split("[^A-Za-z0-9]+");
        // System.out.println(tokens.length);
        // for (String string : tokens) {
        //     System.out.println(string);
        // }
        return tokens;
    }
}
