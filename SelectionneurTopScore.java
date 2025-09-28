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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionneurTopScore implements Selectionneur {
    @Override
    public List<String> selectionner(Groupe groupe, int maxResultats) {
        List<Couple> sorted = new ArrayList<>(groupe.getCouples());
        Collections.sort(sorted, new Comparator<Couple>() {
    @Override
    public int compare(Couple c1, Couple c2) {
        return Double.compare(c2.score, c1.score); // décroissant
    }
});


        
        
        
        List<String> resultats = new ArrayList<>();
        int count = 0;
        for (Couple c : sorted) {
            resultats.add(c.nom2);
            count++;
            if (maxResultats > 0 && count >= maxResultats) break;
        }

        return resultats;
    }
}