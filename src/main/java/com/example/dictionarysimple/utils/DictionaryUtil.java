package com.example.dictionarysimple.utils;

import com.example.dictionarysimple.config.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryUtil {

    private static Scanner sc = new Scanner(System.in);
    private static HashMap<Integer, HashMap<String, String>> dicMap = new HashMap<>();
    
    private static Integer score = 0;

    static {
        ArrayList<String> wordAndMeanList = FileUtil.readFromFile(Config.FILENAME);

        int i = 0;
        for (String line : wordAndMeanList) {
            String[] wordAndMeanArr = line.split(",");

            HashMap<String, String> wordAndMeanMap = new HashMap<String, String>();
            wordAndMeanMap.put(wordAndMeanArr[0], wordAndMeanArr[1]);
            dicMap.put(i++, wordAndMeanMap);
        }
    }
    
    public static void askMeanings(){
        for(int i=0;i<dicMap.size();i++){
            askMeaning(i);
        }
        
        System.out.println("\nYour score: " + score);
    }

    public static void askMeaning(int index) {
        char lang = askLanguageFromCompetitor();
        
        HashMap<String, String> wordAndMeanMap = dicMap.get(index);

        String word = (String) wordAndMeanMap.keySet().iterator().next();
        String meaning = (String) wordAndMeanMap.values().iterator().next();
        
        int choice = 3;
        while (choice > 0) {
            String meaningFromCompetitor = askMeaningFromCompetitor(word, lang);

            if (meaning.equals(meaningFromCompetitor)) {
                isMeaning(lang);
                increaseScore();
                return;
            }

            choice--;

            if (choice == 0) {
                isNotMeaning(meaning, lang);
            }
        }
    }

    public static char askLanguageFromCompetitor() {
        System.out.print("which language would you like to ask question? in Azerbaijan or English (a,e) : ");
        char lang = sc.nextLine().charAt(0);
        return lang;
    }

    public static String askMeaningFromCompetitor(String word, char lang) {
        System.out.println((lang == 'e') ? "what is " + word : word + " nedir?");
        String meaning = sc.nextLine();
        return meaning;
    }

    public static void isNotMeaning(String meaning, char lang) {
        System.out.println((lang == 'e') ? "this word's meaning is " + meaning : "bu sozun menasi " + meaning + "-dir");
    }

    public static void isMeaning(char lang) {
        System.out.println((lang == 'e') ? "Congratulations! that meaning is correct!" : "Tebrikler! bu sozun menasi dogrudur!");
    }
    
    public static void increaseScore(){
        score++;
    }
}
