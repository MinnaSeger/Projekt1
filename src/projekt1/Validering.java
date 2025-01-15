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
    
    public static boolean isValidLongText(String text) {
    // Regex för att matcha en längre text med bokstäver, siffror, mellanslag och vanliga specialtecken
    String textRegex = "^[a-zA-ZåäöÅÄÖ0-9\\s.,'\";:!?#@&()-_+/]{10,1000}$";
    return text != null && text.matches(textRegex);
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
     * Validerar en numerisk inmatning (t.ex. projektkostnad).
     * @param nummerInString Siffervärdet i textform.
     * @return true om inmatningen är numerisk, annars false.
     */
    public static boolean isNumerisk(String nummerInString) {
        String numeriskRegex = "^\\d+(\\.\\d+)?$";
        return Pattern.matches(numeriskRegex, nummerInString);
    }
    public static boolean isValidLosenord(String losenord) {
    // Regex för exakt 11 tecken, minst en stor bokstav, en liten bokstav och en siffra
    String losenordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{11}$";
    return losenord != null && Pattern.matches(losenordRegex, losenord);
    }
    public static boolean isValidTelefonnummer(String telefonnummer) {
    return telefonnummer != null && telefonnummer.trim().matches("^[0-9]{7,15}$");
    }
    
    public static boolean isValidAdress(String adress) {
    // Regex för att matcha adresser med bokstäver, siffror, mellanslag, och vanliga tecken som bindestreck och kommatecken
    String adressRegex = "^[a-zA-ZåäöÅÄÖ0-9\\s,'-]{2,}$";
    return adress != null && Pattern.matches(adressRegex, adress);
}

/**
 * Kontrollerar om en textruta är tom (dvs. innehåller endast mellanslag eller är helt tom).
 * @param input Textinmatningen som ska kontrolleras.
 * @return true om textrutan inte är tom, annars false.
 */
public static boolean isNotEmpty(String input) {
    return input != null && !input.trim().isEmpty();
}
}

