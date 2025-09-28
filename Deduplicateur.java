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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
public class Deduplicateur {
    public static List<String> dedupliquer(List<String> noms, Configuration config) {
        Set<String> uniques = new LinkedHashSet<>();
        List<String> resultats = new ArrayList<>();

        for (String nom : noms) {
            // Si le nom commence par '?', on le rejette immédiatement
            if (nom.startsWith("?")) {
                continue;
            }

            List<String> variantsNom = config.pretraitement.pretraiter(nom);
            boolean estDoublon = false;

            for (String v1 : variantsNom) {
                for (String existant : uniques) {
                    for (String v2 : config.pretraitement.pretraiter(existant)) {
                        double score = config.comparateur.comparer(v1, v2);
                        if (config.comparateur.estSimilaire(score, config.seuil)) {
                            estDoublon = true;
                            break;
                        }
                    }
                    if (estDoublon) break;
                }
                if (estDoublon) break;
            }

            if (!estDoublon) {
                uniques.add(nom);
                resultats.add(nom);
            }
        }

        return resultats;
    }
}
