/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author user
**/
public class LocalCSVDataImporter implements DataImporter {
    private String filePath;

    public LocalCSVDataImporter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<NamedEntity> importData() {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                .skip(1) // ignore l'en-tête
                .map(line -> line.split(",", 2)) // important : limite à 2 pour gérer les noms contenant des virgules
                .filter(values -> values.length == 2)
                .map(values -> new NamedEntity(values[0].trim(), values[1].trim()))
                .toList();
        } catch (IOException e) {
            System.err.println("ERREUR : impossible de lire le fichier CSV");
            return List.of();
        }
    }
}