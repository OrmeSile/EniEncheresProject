package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private EtatVente etatVente;
	private Utilisateur vendeur;
	private Retrait lieuRetrait;
	private Categorie categorieArticle;
	private String image;
	private ArrayList<Enchere> encheres;

	public ArticleVendu(
			int noArticle,
			String nomArticle,
			String description,
			LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres,
			int miseAPrix,
			int prixVente,
			EtatVente etatVente,
			Utilisateur vendeur,
			Retrait lieuRetrait,
			Categorie categorieArticle,
			String image,
			ArrayList<Enchere> encheres)
	{
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.vendeur = vendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
		this.image = image;
		this.encheres = encheres;
	}

	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, EtatVente etatVente, Utilisateur vendeur, Retrait lieuRetrait, Categorie categorieArticle, String image) {
		this.noArticle = 0;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.vendeur = vendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
		this.image = image;
		this.encheres = new ArrayList<>();
	}

	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, EtatVente etatVente,
						Utilisateur vendeur, Retrait lieuRetrait, Categorie categorieArticle, String image) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.vendeur = vendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
		this.image = image;
		this.encheres = new ArrayList<>();
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

	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public EtatVente getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(EtatVente etatVente) {
		this.etatVente = etatVente;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}


	public Categorie getCategorieArticle() {
		return categorieArticle;
	}

	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
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

	@Override
	public String toString() {
		return "ArticleVendu{" +
				"noArticle=" + noArticle +
				", nomArticle='" + nomArticle + '\'' +
				", description='" + description + '\'' +
				", dateDebutEncheres=" + dateDebutEncheres +
				", dateFinEncheres=" + dateFinEncheres +
				", miseAPrix=" + miseAPrix +
				", prixVente=" + prixVente +
				", etatVente=" + etatVente +
				", vendeur=" + vendeur +
				", lieuRetrait=" + lieuRetrait +
				'}';
	}
}