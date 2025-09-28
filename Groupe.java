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

public class Groupe{
	private List<Couple> couples ; 
	private double seuil ;
	public Groupe(double seuil) {
		this.couples = new ArrayList<>();
		this.seuil = seuil;
	}
	public void ajouter(Couple couple) {
		couples.add(couple) ;
	}
	public List<Couple> getCouples() {
		return couples;
	}

	public double getSeuil() {
		return seuil;
	}
	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}
	@Override
	public String toString() {
		return "Groupe [couples=" + couples + ", seuil=" + seuil + ", getCouples()=" + getCouples() + ", getSeuil()="
				+ getSeuil() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	

}