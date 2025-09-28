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
import java.util.Collections;
import java.util.List;




public class GenerateurPrefixe extends Generateur {
   public GenerateurPrefixe() {
   }

   @Override
   public List<Couple> generer(String nomRecherche, Index index, ComparateurDeChaine comparateur) {
      List<Couple> resultats = new ArrayList<>();
      
      // Si le nom de recherche est vide, retourner une liste vide
      if (nomRecherche == null || nomRecherche.isEmpty()) {
         return resultats;
      }
      
      // Récupérer tous les noms qui commencent par le préfixe (ou les 2 premiers caractères)
      String prefixe = nomRecherche.length() > 1 ? nomRecherche.substring(0, 2) : nomRecherche;
      List<String> candidats = index.rechercherParPrefixe(prefixe);
      
      // Si aucun candidat n'est trouvé avec le préfixe, essayer avec toute la liste
      if (candidats.isEmpty()) {
         candidats = index.getNoms();
      }
      
      // Comparer chaque candidat avec le nom recherché
      for (String nomCandidat : candidats) {
         double score = comparateur.comparer(nomRecherche, nomCandidat);
         resultats.add(new Couple(nomRecherche, nomCandidat, score));
      }
      
      // Trier les résultats par score décroissant
      Collections.sort(resultats, (c1, c2) -> Double.compare(c2.score, c1.score));
      
      return resultats;
   }

   @Override
   public String toString() {
      return "GenerateurPrefixe";
   }
}



