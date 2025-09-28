/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PretraitementEnleverBenIbn implements Pretraitement{
         @Override
	 public List<String> pretraiter(String nom) {
	        
	        String nomModifie = nom.replaceAll("\\b(Ben|Ibn|bin)\\b", "").trim();
	        List<String> resultat = new ArrayList<>();
	        resultat.add(nomModifie);
	        return resultat;
	    }

}
