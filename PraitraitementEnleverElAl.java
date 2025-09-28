/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author user
 */
public class PraitraitementEnleverElAl implements Pretraitement{
    
    private List<String> motsCommuns = Arrays.asList("de", "la","el","ll","al","le", "et", "des", "les");

    @Override
    public List<String> pretraiter(String nom) {
        
        String[] mots = nom.split(" ");
        List<String> motsModifies = new ArrayList<>();
        for (String mot : mots) {
            if (!motsCommuns.contains(mot.toLowerCase())) {
                motsModifies.add(mot);
            }
        }


        String nomModifie = String.join(" ", motsModifies);
        
     
        List<String> resultat = new ArrayList<>();
        resultat.add(nomModifie);
        return resultat;
    }
}

