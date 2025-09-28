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
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Configuration config = new Configuration();

    public static void main(String[] args) {
        System.out.println("Bienvenue dans l'outil de traitement de noms !");
        boolean quitter = false;

        while (!quitter) {
            afficherMenuPrincipal();
            int choix = lireEntier("Entrez votre choix : ");

            switch (choix) {
                case 1 -> effectuerRecherche();
                case 2 -> comparerListes();
                case 3 -> dedupliquerListe();
                case 4 -> configurerParametres();
                case 5 -> {
                    quitter = true;
                    System.out.println(" Merci d avoir utilise notre outil !");
                }
                default -> System.out.println(" Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("""
                \n========================= MENU PRINCIPAL =========================
                1.  Effectuer une recherche dans un fichier CSV
                2.  Comparer deux fichiers CSV
                3.  Dedupliquer un fichier CSV
                4.  Configurer les parametres
                5.  Quitter
                ==================================================================
                """);
    }

    private static void effectuerRecherche() {
        System.out.print("Entrez le nom a rechercher : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le chemin du fichier CSV : ");
        String chemin = scanner.nextLine();

        DataImporter importer = new LocalCSVDataImporter(chemin);
        List<NamedEntity> entities = importer.importData();
        List<String> noms=entities.stream().map(NamedEntity::getNom).collect(Collectors.toList());
        MoteurDeRecherche moteur = new MoteurDeRecherche(config);
        Groupe groupe = moteur.rechercher(nom, noms , "prefixe");
        System.out.println("Resultats :");
        for (Couple c : groupe.getCouples()) {
            System.out.println(c);
        }
    }

    private static void comparerListes() {
        System.out.print("Chemin du premier fichier CSV : ");
        String chemin1 = scanner.nextLine();
        System.out.print("Chemin du second fichier CSV : ");
        String chemin2 = scanner.nextLine();

        DataImporter importer1 = new LocalCSVDataImporter(chemin1);
        DataImporter importer2 = new LocalCSVDataImporter(chemin2);

        List<NamedEntity> liste1 = importer1.importData();
        List<NamedEntity> liste2 = importer2.importData();
      List<String> liste11 =liste1.stream().map(NamedEntity::getNom).toList();
      List<String> liste22 =liste2.stream().map(NamedEntity::getNom).toList();
        ComparateurDeChaine comparateur = config.getComparateur();
        GroupeDeResultat groupe = new GroupeDeResultat();
        for (String nom1 : liste11) {
    for (String nom2 : liste22) {
        // Comparaison des éléments des deux listes
        double score = comparateur.comparer(nom1, nom2);

        // Si le score de similarité est suffisamment élevé, ajouter la correspondance
        if (score < config.getSeuil()) { // Définir un seuil pour la similarité
            groupe.ajouterCorrespondance(nom1, nom2, score);
        }
    }
}

        System.out.println("Correspondances detectees :");
        for (Couple c : groupe.getCouples()) {
            System.out.println(c);
        }
    }

    private static void dedupliquerListe() {
        System.out.print("Chemin du fichier CSV a dedupliquer : ");
        String chemin = scanner.nextLine();

        DataImporter importer = new LocalCSVDataImporter(chemin);
        List<NamedEntity> entities= importer.importData();
        List<String> nomss =entities.stream().map(NamedEntity::getNom).toList();
        List<String> uniques = Deduplicateur.dedupliquer(nomss , config);

        System.out.println("Liste sans doublons :");
        for (String ne : uniques) {
            System.out.println(ne);
        }
    }

    private static void configurerParametres() {
        System.out.println("""
                \n===== CONFIGURATION =====
                1. Choisir le pretraitement
                2. Choisir la structure d indexation
                3. Choisir la mesure de comparaison
                4. Definir le seuil ou nombre de résultats
                """);

        int choix = lireEntier("Votre choix : ");
        switch (choix) {
            case 1 -> config.choisirPretraitement(scanner);
            case 2 -> config.choisirIndex(scanner);
            case 3 -> config.choisirComparateur(scanner);
            case 4 -> config.choisirParametresResultat(scanner);
            default -> System.out.println("Choix invalide.");
        }
    }

    private static int lireEntier(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre : ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // vider le buffer
        return value;
    }
}
