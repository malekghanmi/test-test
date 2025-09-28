/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Configuration {
    
	public Pretraitement pretraitement;
    public Index indexeur;
    public ComparateurDeChaine comparateur;
    public GenerateurDeCandidat generateur;
    public Selectionneur selectionneur;
    public double seuil;
    public int maxResultats;
    
    public Configuration(){
         this.pretraitement = new PretraitementNormalisation();
    	this.indexeur = new IndexDictionnaire();
    	this.comparateur = new ComparateurLevenshtein();
    	this.generateur = new GenerateurPrefixe();
    	this.selectionneur = new SelectionneurTopScore();
    	this.seuil = 0.8;
    	this.maxResultats = 5;
    
    
    }
     // Méthodes interactives pour la configuration CLI
    public void choisirPretraitement(Scanner scanner) {
        System.out.println("""
            Choisir le pretraitement :
            1. Normalisation (minuscule, sans accents)
            2. Enlever 'El' ou 'Al'
            3. Enlever 'Ben', 'Ibn'
            4. Soundex
        """);
        int choix = scanner.nextInt(); scanner.nextLine(); // vider buffer
        switch (choix) {
            case 1 -> this.pretraitement = new PretraitementNormalisation();
            case 2 -> this.pretraitement = new PraitraitementEnleverElAl();
            case 3 -> this.pretraitement = new PretraitementEnleverBenIbn();
            case 4 -> this.pretraitement = new PretraitementSoundex();
            default -> System.out.println("Choix invalide, valeur par défaut conservee.");
        }
    }

    public void choisirIndex(Scanner scanner) {
        System.out.println("""
            Choisir la structure d’index :
            1. Dictionnaire
            2. Trie
            
        """);
        int choix = scanner.nextInt(); scanner.nextLine();
        switch (choix) {
            case 1 -> this.indexeur = new IndexDictionnaire();
            case 2 -> this.indexeur = new IndexTri();
       
            default -> System.out.println("Choix invalide, valeur par défaut conservee.");
        }
    }

    public void choisirComparateur(Scanner scanner) {
        System.out.println("""
            Choisir la mesure de comparaison :
            1. Egalite exacte
            2. Levenshtein
            3. Jaro-Winkler
        """);
        int choix = scanner.nextInt(); scanner.nextLine();
        switch (choix) {
            case 1 -> this.comparateur = new ComparateurEgalitExact();
            case 2 -> this.comparateur = new ComparateurLevenshtein();
            case 3 -> this.comparateur = new ComparateurJarowinkler();
            default -> System.out.println("Choix invalide, valeur par défaut conservée.");
        }
    }

    public void choisirParametresResultat(Scanner scanner) {
        System.out.print("Definir le seuil (par exemple 0.8) : ");
        this.seuil = scanner.nextDouble();
        System.out.print("Definir le nombre maximal de resultats : ");
        this.maxResultats = scanner.nextInt();
        scanner.nextLine(); // vider buffer
    }
    
    
    
    public Configuration(Pretraitement pretraitement,Index indexeur,ComparateurDeChaine comparateur,GenerateurDeCandidat generateur, Selectionneur selectionneur,
     double seuil,int maxResultats) {
    	this.pretraitement = pretraitement;
    	this.indexeur = indexeur;
    	this.comparateur = comparateur;
    	this.generateur = generateur;
    	this.selectionneur = selectionneur;
    	this.seuil = seuil;
    	this.maxResultats = maxResultats;
    }
	public Pretraitement getPretraitement() {
		return pretraitement;
	}
	public void setPretraitement(Pretraitement pretraitement) {
		this.pretraitement = pretraitement;
	}
	public Index getIndexeur() {
		return indexeur;
	}
	public void setIndexeur(Index indexeur) {
		this.indexeur = indexeur;
	}
	public ComparateurDeChaine getComparateur() {
		return comparateur;
	}
	public void setComparateur(ComparateurDeChaine comparateur) {
		this.comparateur = comparateur;
	}
	public GenerateurDeCandidat getGenerateur() {
		return generateur;
	}
	public void setGenerateur(GenerateurDeCandidat generateur) {
		this.generateur = generateur;
	}
	public Selectionneur getSelectionneur() {
		return selectionneur;
	}
	public void setSelectionneur(Selectionneur selectionneur) {
		this.selectionneur = selectionneur;
	}
	public double getSeuil() {
		return seuil;
	}
	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}
	public int getMaxResultats() {
		return maxResultats;
	}
	public void setMaxResultats(int maxResultats) {
		this.maxResultats = maxResultats;
	}
    

	
	
	

   


}