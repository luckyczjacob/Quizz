package loadFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class LoadQuestions {
    public static ArrayList<String> loadQuestionsFromFile(String filename) {
        ArrayList<String> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length == 2) {
                    questions.add(parts[1]);
                } else {
                    questions.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}


