/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */

public class IndexArbre implements Index {
   private final Noeud racine = new Noeud();

   public IndexArbre() {
   }

   private static class Noeud {
      Map<Character, Noeud> enfants = new HashMap<>();
      boolean estFinDeMot = false;
      String motComplet = null;
   }

   @Override
   public void indexer(List<String> noms) {

      this.racine.enfants.clear();
      
      for (String nom : noms) {
         if (nom != null && !nom.trim().isEmpty()) {
            this.ajouterNom(nom);
         }
      }
   }

   private void ajouterNom(String nom) {
      Noeud courant = this.racine;
      
      for (char c : nom.toLowerCase().toCharArray()) {
         courant = courant.enfants.computeIfAbsent(c, k -> new Noeud());
      }
      
      courant.estFinDeMot = true;
      courant.motComplet = nom;
   }

   @Override
   public List<String> getNoms() {
      List<String> resultats = new ArrayList<>();
      this.collecterMots(this.racine, resultats);
      return resultats;
   }

   private void collecterMots(Noeud noeud, List<String> resultats) {
      if (noeud.estFinDeMot && noeud.motComplet != null) {
         resultats.add(noeud.motComplet);
      }

      for (Noeud enfant : noeud.enfants.values()) {
         this.collecterMots(enfant, resultats);
      }
   }

   @Override
   public List<String> rechercherParPrefixe(String prefixe) {
      // Si le préfixe est vide, retourner tous les noms
      if (prefixe == null || prefixe.isEmpty()) {
         return this.getNoms();
      }
      
      Noeud courant = this.racine;
      
      // Descendre dans l'arbre selon le préfixe
      for (char c : prefixe.toLowerCase().toCharArray()) {
         if (!courant.enfants.containsKey(c)) {
            return new ArrayList<>();
         }
         courant = courant.enfants.get(c);
      }
      
   
      List<String> resultats = new ArrayList<>();
      this.collecterMots(courant, resultats);
      return resultats;
   }

   @Override
   public List<String> rechercherParMotCle(String motCle) {
      if (motCle == null || motCle.isEmpty()) {
         return this.getNoms();
      }
      
      List<String> resultats = new ArrayList<>();
      
   
      for (String nom : this.getNoms()) {
         if (nom.toLowerCase().contains(motCle.toLowerCase())) {
            resultats.add(nom);
         }
      }
      
      return resultats;
   }
}