package fr.eni.ecole.encheres.bo.tests;

import fr.eni.ecole.encheres.bo.*;

import java.time.LocalDateTime;

public class testBOCircular {
    public static void main(String[] args){
        var user1 = new Utilisateur(1, "pseudo", "nom", "prenom","email", "telephone", "rue","codePostal", "ville", "motDePasse", 10, false);
        var retrait = new Retrait(user1.getRue(), user1.getCodePostal(), user1.getVille());
        var categorie = new Categorie(1, "categorie");
        var user2 = new Utilisateur(2, "pseudo", "nom", "prenom","email", "telephone", "rue","codePostal", "ville", "motDePasse", 10, false);
        var article = new ArticleVendu(1,"article", "description", LocalDateTime.now().minusDays(10), LocalDateTime.now(), 10, 20, EtatVente.VENDU, user1, retrait, categorie, "image" );
        var enchere = new Enchere(LocalDateTime.now().minusDays(1), 10, article, user2);
        System.out.println(enchere);

        System.out.println(enchere);
    }
}
