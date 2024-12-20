/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekt1;

import java.util.regex.Pattern;

/**
 *
 * @author elsa
 */
public class Validering {
     /**
     * Validerar en e-postadress.
     * @param ePost E-postadressen som ska valideras.
     * @return true om e-postadressen är giltig, annars false.
     */
    public static boolean isValidePost(String ePost) {
        String ePostRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(ePostRegex, ePost);
    
}
    /**
     * Validerar ett namn. Endast bokstäver och minst två tecken långt.
     * @param namn Namnet som ska valideras.
     * @return true om namnet är giltigt, annars false.
     */
    public static boolean isValidNamn(String namn) {
        String namnRegex = "^[a-zA-ZåäöÅÄÖ\\s'-]{2,}$";
        return Pattern.matches(namnRegex, namn);
    }
    
    /**
     * Validerar ett datum i formatet YYYY-MM-DD.
     * @param datum Datumet som ska valideras.
     * @return true om datumet är giltigt, annars false.
     */
    public static boolean isValidDatum(String datum) {
        String datumRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(datumRegex, datum);
    }
    /**
     * Validerar ett telefonnummer (exempel: 0701234567 eller +46701234567).
     * @param telefonnummer Telefonnummer som ska valideras.
     * @return true om telefonnumret är giltigt, annars false.
     */
    public static boolean isValidTelefonnummer(String telefonnummer) {
        String telefonRegex = "^(\\+46|0)[7-9]\\d{8}$";
        return Pattern.matches(telefonRegex, telefonnummer);
    }
    /**
     * Validerar en numerisk inmatning (t.ex. projektkostnad).
     * @param nummerInString Siffervärdet i textform.
     * @return true om inmatningen är numerisk, annars false.
     */
    public static boolean isNumerisk(String nummerInString) {
        String numeriskRegex = "^\\d+(\\.\\d+)?$";
        return Pattern.matches(numeriskRegex, nummerInString);
    }
    /**
 * Validerar ett lösenord. Det ska vara exakt 11 tecken långt och 
 * kan bestå av stora bokstäver, små bokstäver eller siffror.
 * @param losenord Lösenordet som ska valideras.
 * @return true om lösenordet är giltigt, annars false.
 */
public static boolean isValidLosenord(String losenord) {
    String losenordRegex = "^[a-zA-Z0-9]{11}$"; // Exakt 11 tecken: stora/små bokstäver och siffror
    return Pattern.matches(losenordRegex, losenord);
}
}

