/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

/**
 *
 * @author user
 */
public class ComparateurLevenshtein implements ComparateurDeChaine {

    @Override
    public double comparer(String s1, String s2) {
        int distance = calculerDistanceLevenshtein(s1, s2);
        int maxLength = Math.max(s1.length(), s2.length());
        if (maxLength == 0) return 1.0;
        return 1.0 - ((double) distance / maxLength); // Normalise entre 0 et 1
    }

    private int calculerDistanceLevenshtein(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1,        // suppression
                                 dp[i][j - 1] + 1),       // insertion
                        dp[i - 1][j - 1] + cost);         // substitution
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public boolean estSimilaire() {
        return false; // Comparateur basé sur une distance
    }

    @Override
    public boolean estSimilaire(double score, double seuil) {
        return score >= seuil; // Score entre 0 et 1
    }
}
