package com.example.dictionarysimple.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

    public static boolean writeToFile(String fileName, String text, boolean append) throws IOException {
        boolean isWritten = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            bw.write(text);
            isWritten = true;
        } finally {
            return isWritten;
        }
    }
    
    public static ArrayList<String> readFromFile(String fileName){
        ArrayList<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = null;
            while ((line = br.readLine()) != null) {                
                wordList.add(line);
            }
        } catch (Exception e) {
        }
        return wordList;
    }
}
