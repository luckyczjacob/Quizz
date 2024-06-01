package loadFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Třída pro načtení otázek ze souboru
 */
public class NacistOtazky {
    /**
     * Metoda pro načtení otázek ze souboru.
     * @param nazevSouboru Název souboru, ze kterého se mají načíst otázky.
     * @return Seznam otázek načtených ze souboru
     */
    public static ArrayList<String> nacistOtazkyZeSouboru(String nazevSouboru) {
        ArrayList<String> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
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


