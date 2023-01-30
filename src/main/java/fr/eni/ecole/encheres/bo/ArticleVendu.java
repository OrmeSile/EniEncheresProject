package fr.eni.ecole.encheres.bo;

public class ArticleVendu {
int
String
String
DATETIME
DATETIME
int
int
int
int
String
String
}
 /*
CREATE TABLE ARTICLES_VENDUS (
no_article                    INTEGER IDENTITY(1,1) NOT NULL,
nom_article                   VARCHAR(30) NOT NULL,
description                   VARCHAR(300) NOT NULL,
date_debut_enchere            DATETIME NOT NULL,
date_fin_enchere              DATETIME NOT NULL,
prix_initial                  INTEGER NULL,
prix_vente                    INTEGER NULL,
no_utilisateur                INTEGER NOT NULL,
no_categorie                  INTEGER NOT NULL,
etat_vente					  CHAR(2) NOT NULL DEFAULT 'CR',
image 						  VARCHAR(150) NULL
)
*/