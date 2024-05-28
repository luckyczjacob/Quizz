package loadFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadAnswers {
    public static HashMap<Integer, ArrayList<String>> loadAnswersFromFile(String filename, HashMap<Integer, Integer> correctAnswers) {
        HashMap<Integer, ArrayList<String>> answers = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("  ", 3);
                if (parts.length == 3) {
                    int questionNumber = Integer.parseInt(parts[0]);
                    String answerText = parts[1];
                    int isCorrect = Integer.parseInt(parts[2]);
                    ArrayList<String> questionAnswers = answers.get(questionNumber);
                    if (questionAnswers == null) {
                        questionAnswers = new ArrayList<>();
                        answers.put(questionNumber, questionAnswers);
                    }
                    questionAnswers.add(answerText);
                    if (isCorrect == 1) {
                        correctAnswers.put(questionNumber, answers.get(questionNumber).size() - 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }
}
