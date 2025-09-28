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


public class Generateur implements GenerateurDeCandidat{
	public List<Couple> generer(String nomRecherche, Index indexeur, ComparateurDeChaine comparateur) {
        List<Couple> couples = new ArrayList<>();
        for (String nom : indexeur.getNoms()) {
            double score = comparateur.comparer(nomRecherche, nom);
            couples.add(new Couple(nomRecherche, nom, score));
        }
        return couples;
    }

}