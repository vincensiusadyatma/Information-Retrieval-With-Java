package com.informationretrieval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class ReadFile {
    private String path;
    private File folder;
    private Scanner input;


    public ReadFile(String path){
        this.path = path;
        this.folder = new File(this.path);
    }

    public InvertedIndex read(){
      List<Term> term_list = new ArrayList<>();
      InvertedIndex invertedList = new InvertedIndex();

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
                    docs =  docs.substring(0,docs.lastIndexOf('.')).toLowerCase();
                    try {
                        String temp = "";
                        while (input.hasNext()) {
                            temp += input.nextLine();
                        }
                        // System.out.println(Tokenizer.tokenize(temp).length);
                        String[] tokens = Tokenizer.tokenize(temp);
                        for (String token : tokens) {
                            Document document_object = new Document(docs);
                            //menghitung tf
                            document_object.calculateTF(token,tokens);
                            //mencari term yang pernah ada, jika ada maka hanya tinggal menambahkan doc
                            for (Term term : invertedList.getInvertedList()) {
                                if (token.equals(term.getName())) {
                                    term.addDoc(document_object);
                                    term.calculateIDF(listDocs.length);
                                    break;
                                }
                            }
                            Term term_object = new Term(token);
                            term_object.addDoc(document_object);
                            term_object.calculateIDF(listDocs.length);
                            invertedList.addTerm(term_object);
                            
                        }
                       
                        // invertedMap.addTerm(docs, Tokenizer.tokenize(temp));
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
      return invertedList;
    }

  
}



