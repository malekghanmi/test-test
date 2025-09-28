/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

/**
 *
 * @author user
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PretraitementNormalisation implements Pretraitement {
    @Override
    public List<String> pretraiter(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            return Collections.emptyList();
        }
        
        String resultat = nom.toLowerCase()
                          .replaceAll("[éèêë]", "e")
                          .replaceAll("[àâä]", "a")
                          .replaceAll("[îï]", "i")
                          .replaceAll("[ôö]", "o")
                          .replaceAll("[ùûü]", "u")
                          .replaceAll("ç", "c")
                          .replaceAll("[^a-z]", " ")
                          .replaceAll("\\s+", " ")
                          .trim();
        
         if (resultat.isEmpty()) {
            return Collections.emptyList();
        } else {
            return Arrays.asList(resultat);
        }
    }
}