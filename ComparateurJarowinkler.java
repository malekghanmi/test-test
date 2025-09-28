/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

/**
 *
 * @author user
 */

public class ComparateurJarowinkler implements ComparateurDeChaine {

    @Override
    public double comparer(String texte1, String texte2) {
        if (texte1 == null || texte2 == null) {
            return (texte1 == null ? texte2 == null : texte1.equals(texte2)) ? 1.0 : 0.0;
        }
        double jaro = calculerJaro(texte1, texte2);

        int prefixe = 0;
        int maxPrefixe = Math.min(4, Math.min(texte1.length(), texte2.length()));
        for (int i = 0; i < maxPrefixe; i++) {
            if (texte1.charAt(i) == texte2.charAt(i)) {
                prefixe++;
            } else {
                break;
            }
        }
        double facteurPrefixe = 0.1;

        return jaro + (prefixe * facteurPrefixe * (1 - jaro));
    }

    private double calculerJaro(String s1, String s2) {
        // Distance maximale de correspondance
        int distanceMax = Math.max(s1.length(), s2.length()) / 2 - 1;
        if (distanceMax < 0) distanceMax = 0;

        boolean[] matches1 = new boolean[s1.length()];
        boolean[] matches2 = new boolean[s2.length()];

        // Compte des correspondances
        int correspondances = 0;
        for (int i = 0; i < s1.length(); i++) {
            int debut = Math.max(0, i - distanceMax);
            int fin = Math.min(s2.length() - 1, i + distanceMax);

            for (int j = debut; j <= fin; j++) {
                if (!matches2[j] && s1.charAt(i) == s2.charAt(j)) {
                    matches1[i] = true;
                    matches2[j] = true;
                    correspondances++;
                    break;
                }
            }
        }

        if (correspondances == 0) return 0.0;

        // Compte des transpositions
        int transpositions = 0;
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (matches1[i]) {
                while (!matches2[k]) k++;
                if (s1.charAt(i) != s2.charAt(k)) {
                    transpositions++;
                }
                k++;
            }
        }

        // Formule Jaro
        double m = correspondances;
        return (m / s1.length() + m / s2.length() + (m - transpositions / 2.0) / m) / 3.0;
    }

    // Implémentation de la méthode estSimilaire avec seuil
    @Override
    public boolean estSimilaire(double score, double seuil) {
        // Si le score est supérieur ou égal au seuil, on considère les chaînes comme similaires
        return score >= seuil;
    }
}
