package loadFiles;

import java.io.*;
/**
 * Třída pro uložení skóre uživatele do souboru
 */
public class UlozitSkore {
    /**
     * Metoda pro uložení skóre uživatele do souboru.
     * @param pocetSpravnychOdpovedi Celkový počet správných odpovědí.
     */
    public static void ulozit(int pocetSpravnychOdpovedi) {
        File file = new File("uzivatel.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(  pocetSpravnychOdpovedi + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
