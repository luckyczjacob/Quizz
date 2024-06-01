package loadFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Třída pro načtení uživatelského jména ze souboru
 */
public class NacistUzivatele {
    /**
     * Metoda pro načtení uživatelského jména ze souboru
     * @return Načtené uživatelské jméno
     */
    public static String nacistUzivatel() {
        String username = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("uzivatel.txt"))) {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return username;
    }
}
