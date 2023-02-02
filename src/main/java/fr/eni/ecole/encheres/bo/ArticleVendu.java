package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEnchere;
	private LocalDateTime dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private String etatVente;
	private String image;
	private ArrayList<Enchere> encheres;
	private Utilisateur utilisateur;
	private Retrait lieuRetrait;

	private Categorie categorieArticle;

	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere, int prixInitial, int prixVente, int noCategorie, String etatVente, Retrait lieuRetrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.lieuRetrait = lieuRetrait;
		this.image = null;
	}

	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere, int prixInitial, int prixVente, int noCategorie, String etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.encheres = new ArrayList<>();
		this.image = null;
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

	public ArrayList<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(ArrayList<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public void addEnchere(Enchere e) {
		encheres.add(e);
	}

	public Categorie getcategorieArticle() {
		return categorieArticle;
	}

	public void setcategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	@Override
	public String toString() {
		return "ArticleVendu [nomArticle=" + nomArticle + ", description=" + description + ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial=" + prixInitial + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
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