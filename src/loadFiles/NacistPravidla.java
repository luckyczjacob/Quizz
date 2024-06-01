package loadFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Třída pro načtení textu pravidel ze souboru
 */
public class NacistPravidla {
    /**
     * Metoda pro načtení textu pravidel ze souboru.
     * @param nazevSouboru Název souboru, ze kterého se má načíst text pravidel
     * @return Pole řetězců obsahující text pravidel načtený ze souboru.
     */

    public static String[] loadTextFromFile(String nazevSouboru) {
       ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nazevSouboru))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }
}
