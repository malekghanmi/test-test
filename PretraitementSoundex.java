/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

/**
 *
 * @author user
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PretraitementSoundex implements Pretraitement {
	 
	public List<String> pretraiter(String chaine) {
        if (chaine == null) return null;
        if (chaine.isEmpty()) return new ArrayList<>();
        
        // Convertir en majuscules et supprimer les caractères non-alphabétiques
        String s = chaine.toUpperCase().replaceAll("[^A-Z]", "");
        if (s.isEmpty()) return new ArrayList<>();
        
        char firstLetter = s.charAt(0);
        
        // Remplacer les consonnes par des chiffres selon les règles Soundex
        s = s.replaceAll("[BFPV]", "1")
             .replaceAll("[CGJKQSXZ]", "2")
             .replaceAll("[DT]", "3")
             .replaceAll("[L]", "4")
             .replaceAll("[MN]", "5")
             .replaceAll("[R]", "6");
        
        // Supprimer les voyelles et les 'H', 'W', 'Y'
        s = s.replaceAll("[AEIOUHWY]", "");
        
        // Supprimer les chiffres doublons adjacents
        StringBuilder sb = new StringBuilder();
        sb.append(firstLetter);
        
        if (s.length() > 0) {
            char last = s.charAt(0);
            sb.append(last);
            
            for (int i = 1; i < s.length(); i++) {
                char current = s.charAt(i);
                if (current != last) {
                    sb.append(current);
                    last = current;
                }
            }
        }
        
        // Limiter à 4 caractères et compléter avec des '0' si nécessaire
        String soundex = sb.toString();
        soundex = soundex.substring(0, Math.min(4, soundex.length()));
        while (soundex.length() < 4) {
            soundex += "0";
        }
        
        return Arrays.asList(soundex);
    }
}