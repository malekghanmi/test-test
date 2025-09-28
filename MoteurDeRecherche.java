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

   

public class MoteurDeRecherche {
   private Configuration config;

   public MoteurDeRecherche(Configuration config) {
      this.config = config;
   }

   public Groupe rechercher(String nom, List<String> liste, String typeGenerationDeCandidat) {
      List<String> nomRecherchePretraite = this.config.pretraitement.pretraiter(nom);
      List<String> nomsTraites = new ArrayList<>();
      for (String n : liste) {
         nomsTraites.addAll(this.config.pretraitement.pretraiter(n));
      }
      
      this.config.indexeur.indexer(nomsTraites);
      GenerateurDeCandidat generateur;
      generateur = switch (typeGenerationDeCandidat.toLowerCase()) {
           case "prefixe" -> new GenerateurPrefixe();
           case "longueur" -> new GenerateurLongueurEgale();
           default -> new Generateur();
       };
      Groupe groupe = new Groupe(this.config.seuil);
      for (String nomRech : nomRecherchePretraite) {
         List<Couple> couples = generateur.generer(nomRech, this.config.indexeur, this.config.comparateur);
         for (Couple c : couples) {
            if (this.config.comparateur.estSimilaire(c.score, this.config.seuil)) {
               groupe.ajouter(c);
               if (this.config.maxResultats > 0 && groupe.getCouples().size() >= this.config.maxResultats) {
                  return groupe;
               }
            }
         }
      }
      
      return groupe;
   }
}