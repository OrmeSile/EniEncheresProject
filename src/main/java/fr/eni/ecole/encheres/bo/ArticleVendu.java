package fr.eni.ecole.encheres.bo;

import fr.eni.ecole.encheres.bo.utils.EtatVente;

import java.time.LocalDateTime;
import java.util.Objects;

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
	private Enchere enchere;

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
			Enchere enchere)
	{
		this(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente, vendeur, lieuRetrait, categorieArticle, image);
		this.noArticle = noArticle;
		this.enchere = enchere;
	}

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
			String image)
	{
		this(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente, vendeur, lieuRetrait, categorieArticle, image);
		this.noArticle = noArticle;
		this.enchere = null;
	}

	public ArticleVendu(
			String nomArticle,
			String description,
			LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres,
			int miseAPrix, int prixVente,
			EtatVente etatVente,
			Utilisateur vendeur,
			Retrait lieuRetrait,
			Categorie categorieArticle,
			String image)
	{
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
		this.enchere = null;
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

	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArticleVendu that = (ArticleVendu) o;
		return noArticle == that.noArticle && miseAPrix == that.miseAPrix && prixVente == that.prixVente && nomArticle.equals(that.nomArticle) && description.equals(that.description) && dateDebutEncheres.equals(that.dateDebutEncheres) && dateFinEncheres.equals(that.dateFinEncheres) && etatVente == that.etatVente && vendeur.equals(that.vendeur) && lieuRetrait.equals(that.lieuRetrait) && categorieArticle.equals(that.categorieArticle) && Objects.equals(image, that.image);
	}

	@Override
	public int hashCode() {
		return Objects.hash(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente, vendeur, lieuRetrait, categorieArticle, image);
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