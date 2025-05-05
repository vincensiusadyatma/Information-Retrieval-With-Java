package com.informationretrieval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFile {
    private String path;
    private File folder;
    private Scanner input;
    private InvertedIndex invertedMap = new InvertedIndex();

    public ReadFile(String path){
        this.path = path;
        this.folder = new File(this.path);
    }

    public void read(){
      if (folder.exists()) {
        if (folder.isDirectory()) {
            String[] listDocs = folder.list();

            Arrays.sort(listDocs, (x, y) -> {
                int numX = Integer.parseInt(x.replaceAll("[^0-9]", ""));
                int numY = Integer.parseInt(y.replaceAll("[^0-9]", ""));
                return Integer.compare(numX, numY);
            });
            
            for (String docs : listDocs) {
                try {
                    input = new Scanner(new BufferedReader(new FileReader(folder.getAbsolutePath() + "//" + docs)));
                    try {
                        String temp = "";
                        while (input.hasNext()) {
                            temp += input.nextLine();
                        }
                        invertedMap.addTerm(docs, Tokenizer.tokenize(temp));
                    }catch (NoSuchElementException e) {
                        System.out.println("File Improperly Formed");
                    }catch(IllegalStateException e){
                        System.out.println("Error reading file");
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File Not Found");
                }
            }
        }
      }
    }

    public void getInvertedMap(){
        System.out.println(invertedMap.getMap().entrySet());
    }

}
