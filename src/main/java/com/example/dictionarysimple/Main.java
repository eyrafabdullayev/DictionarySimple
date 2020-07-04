package com.example.dictionarysimple;

import com.example.dictionarysimple.config.Config;
import com.example.dictionarysimple.utils.DictionaryUtil;
import com.example.dictionarysimple.utils.FileUtil;
import java.io.IOException;

public class Main {

    static {
        String text = "map,xerite\n"
                + "apple,alma\n"
                + "teacher,muellim\n"
                + "student,telebe";

        try {
            FileUtil.writeToFile(Config.FILENAME, text, false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DictionaryUtil.askMeanings();
    }
}
