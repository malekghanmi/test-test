/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class IndexTri  implements Index{
    private List<String> noms ;
    
    @Override
    public void indexer(List<String> noms) {
    	this.noms = new ArrayList<>(noms);
        Collections.sort(this.noms);
    }
    @Override
    public List<String> getNoms(){
    	return noms ;
    }
     @Override
    public List<String> rechercherParMotCle(String motCle) {
  
        List<String> resultats = new ArrayList<>();
        for (String nom : noms) {
            if (nom.equals(motCle)) {
                resultats.add(nom);
            }
        }
        return resultats;
    }
 @Override
    public List<String> rechercherParPrefixe(String prefixe) {
     
        List<String> resultats = new ArrayList<>();
        for (String nom : noms) {
            if (nom.startsWith(prefixe)) {
                resultats.add(nom);
            }
        }
        return resultats;
    }
    	
    }