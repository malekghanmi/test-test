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
import java.util.List;

public class SelectionneurTous implements Selectionneur {
	public List<String> selectionner(Groupe groupe, int maxResultats) {
        List<String> resultats = new ArrayList<>();
        for (Couple c : groupe.getCouples()) {
            resultats.add(c.nom2);
            if (maxResultats > 0 && resultats.size() >= maxResultats) break;
        }
        return resultats;
    }

}
