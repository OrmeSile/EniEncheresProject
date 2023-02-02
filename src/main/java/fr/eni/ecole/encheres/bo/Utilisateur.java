package fr.eni.ecole.encheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;
	private ArrayList<Enchere> encheres;
	private ArrayList<ArticleVendu> articles;

	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit,
					   boolean administrateur, ArrayList<Enchere> encheres, ArrayList<ArticleVendu> articles) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.encheres = encheres;
		this.articles = articles;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 100;

	}

	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit,
					   boolean administrateur) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

}

/*
CREATE TABLE UTILISATEURS (
no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
pseudo           VARCHAR(30) NOT NULL,
nom              VARCHAR(30) NOT NULL,
prenom           VARCHAR(30) NOT NULL,
email            VARCHAR(20) NOT NULL,
telephone        VARCHAR(15) NULL,
rue              VARCHAR(30) NOT NULL,
code_postal      VARCHAR(10) NOT NULL,
ville            VARCHAR(30) NOT NULL,
mot_de_passe     VARCHAR(30) NOT NULL,
credit           INTEGER NOT NULL,
administrateur   BIT NOT NULL
)*/