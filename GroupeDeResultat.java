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

public class GroupeDeResultat {
    private List<Couple> couples;  // Liste des correspondances (nom1, nom2, score)

    public GroupeDeResultat() {
        couples = new ArrayList<>();
    }

    // Ajouter une correspondance
    public void ajouterCorrespondance(String nom1, String nom2, double score) {
        couples.add(new Couple(nom1, nom2, score));
    }

    // Obtenir les couples de correspondances
    public List<Couple> getCouples() {
        return couples;
    }
}
