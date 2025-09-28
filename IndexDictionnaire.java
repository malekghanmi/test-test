/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author user
 */
public class IndexDictionnaire implements Index {
    private final Map<String, List<String>> dictionnaire = new HashMap<>();
    private List<String> allNames = new ArrayList<>(); 

    public IndexDictionnaire() {
    }

    @Override
    public void indexer(List<String> noms) {
      
        dictionnaire.clear();
        allNames.clear();
        

        for (String nom : noms) {
            if (nom != null && !nom.trim().isEmpty()) {
               
                allNames.add(nom);
                char firstChar = Character.toUpperCase(nom.charAt(0));
                String key = String.valueOf(firstChar);
                dictionnaire.computeIfAbsent(key, k -> new ArrayList<>()).add(nom);
                if (nom.length() >= 2) {
                    String prefix2 = nom.substring(0, 2).toUpperCase();
                    dictionnaire.computeIfAbsent(prefix2, k -> new ArrayList<>()).add(nom);
                    
                    if (nom.length() >= 3) {
                        String prefix3 = nom.substring(0, 3).toUpperCase();
                        dictionnaire.computeIfAbsent(prefix3, k -> new ArrayList<>()).add(nom);
                    }
                }
            }
        }
    }

    public Map<String, List<String>> getDictionnaire() {
        return Collections.unmodifiableMap(dictionnaire);
    }

    @Override
    public List<String> getNoms() {
        return new ArrayList<>(allNames); 
    }

    @Override
    public List<String> rechercherParMotCle(String motCle) {
        if (motCle == null || motCle.isEmpty()) {
            return new ArrayList<>(allNames);
        }
        
        List<String> resultats = new ArrayList<>();
        List<String> exactMatches = dictionnaire.get(motCle);
        if (exactMatches != null) {
            resultats.addAll(exactMatches);
        }
        for (String nom : allNames) {
            if (nom.toLowerCase().contains(motCle.toLowerCase()) && !resultats.contains(nom)) {
                resultats.add(nom);
            }
        }
        
        return resultats;
    }

    @Override
    public List<String> rechercherParPrefixe(String prefixe) {
        if (prefixe == null || prefixe.isEmpty()) {
            return new ArrayList<>(allNames);
        }
        
        List<String> resultats = new ArrayList<>();
        String prefixeUpper = prefixe.toUpperCase();
        
        List<String> exactList = dictionnaire.get(prefixeUpper);
        if (exactList != null) {
            resultats.addAll(exactList);
        }

        for (String nom : allNames) {
            if (nom.toUpperCase().startsWith(prefixeUpper) && !resultats.contains(nom)) {
                resultats.add(nom);
            }
        }
        
        return resultats;
    }
}