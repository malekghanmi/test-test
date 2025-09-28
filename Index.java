/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.util.List;

/**
 *
 * @author user
 */
public interface Index {
     void indexer(List<String> noms);
      List<String> getNoms();
      List<String> rechercherParMotCle(String motCle);
      List<String> rechercherParPrefixe(String prefixe);
}
