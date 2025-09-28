/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

/**
 *
 * @author user
 */
public class Couple{
	public String nom1;
	public String nom2 ; 
	public double score ;
	
	public Couple(String nom1, String nom2, double score) {
		this.nom1=nom1 ;
		this.nom2=nom2 ;
		this.score=score ;
	}

	public String getNom1() {
		return nom1;
	}

	
	public String getNom2() {
		return nom2;
	}

	public double getScore() {
		return score;
	}

	@Override
public String toString() {
    return String.format("Nom1: %s | Nom2: %s | Score: %.2f", nom1, nom2, score);
}
	

	
	

}
