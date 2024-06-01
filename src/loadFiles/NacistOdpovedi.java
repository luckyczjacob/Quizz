package loadFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Třída pro načtení odpovědí na otázky ze souboru.
 */
public class NacistOdpovedi {
    /**
     * Metoda pro načtení odpovědí na otázky ze souboru a určení správných odpovědí.
     * @param nazevSouboru Název souboru, ze kterého se mají načíst odpovědi.
     * @param spravneOdpovedi Mapa uchovávající indexy správných odpovědí pro každou otázku.
     * @return Mapa odpovědí na otázky, kde klíčem je číslo otázky a hodnotou seznam odpovědí.
     */
    public static HashMap<Integer, ArrayList<String>> loadAnswersFromFile(String nazevSouboru, HashMap<Integer, Integer> spravneOdpovedi) {
        HashMap<Integer, ArrayList<String>> answers = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
            String line;
            while ((line = br.readLine()) != null) {
                /**
                 * Rozdělení řádku podle dvou mezer a zpracování čísla otázky, textu odpovědi a informace o správnosti
                 */
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
                    /**
                     * Pokud je odpověď správná, uložíme index této odpovědi jako správnou odpověď pro danou otázku
                     */
                    questionAnswers.add(answerText);
                    if (isCorrect == 1) {
                        spravneOdpovedi.put(questionNumber, answers.get(questionNumber).size() - 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }
}
