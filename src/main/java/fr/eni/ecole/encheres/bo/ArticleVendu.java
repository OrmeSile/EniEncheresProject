package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEnchere;
	private LocalDateTime dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private String etatVente;
	private String image;

	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEnchere,
			LocalDateTime dateFinEnchere, int prixInitial, int prixVente, int noUtilisateur, int noCategorie,
			String etatVente, String image) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = etatVente;
		this.image = image;
	}

	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEnchere,
			LocalDateTime dateFinEnchere, int prixInitial, int prixVente, int noUtilisateur, int noCategorie,
			String etatVente, String image) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = etatVente;
		this.image = image;
	}

	public ArticleVendu() {
		super();
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDateTime dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDateTime getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDateTime dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ArticleVendu [nomArticle=" + nomArticle + ", description=" + description + ", dateDebutEnchere="
				+ dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial=" + prixInitial
				+ ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie=" + noCategorie
				+ ", etatVente=" + etatVente + ", image=" + image + "]";
	}

}
/*
 * CREATE TABLE ARTICLES_VENDUS ( no_article INTEGER IDENTITY(1,1) NOT NULL,
 * nom_article VARCHAR(30) NOT NULL, description VARCHAR(300) NOT NULL,
 * date_debut_enchere DATETIME NOT NULL, date_fin_enchere DATETIME NOT NULL,
 * prix_initial INTEGER NULL, prix_vente INTEGER NULL, no_utilisateur INTEGER
 * NOT NULL, no_categorie INTEGER NOT NULL, etat_vente CHAR(2) NOT NULL DEFAULT
 * 'CR', image VARCHAR(150) NULL )
 */