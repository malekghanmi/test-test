/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

/**
 *
 * @author user
 */
public class ComparateurEgalitExact implements ComparateurDeChaine {
        @Override
	public double comparer(String nom1, String nom2) {
        return nom1.equals(nom2) ? 1.0 : 0.0;
    }
        @Override
	public boolean estSimilaire(double score, double seuil) {
		return score >= seuil ;
	}
	

}
