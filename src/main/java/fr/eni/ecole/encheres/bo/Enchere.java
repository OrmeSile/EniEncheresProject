package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Enchere {
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	private ArticleVendu article;
	private Utilisateur encherisseur;

	public Enchere(LocalDateTime dateEnchere, int montantEnchere, ArticleVendu article, Utilisateur encherisseur) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.encherisseur = encherisseur;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public double getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article){
		this.article = article;
  }

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	@Override
	public String toString() {
		return "Enchere{" +
				"dateEnchere=" + dateEnchere +
				", montantEnchere=" + montantEnchere +
				", article=" + article +
				", encherisseur="+ encherisseur +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Enchere enchere = (Enchere) o;
		return montantEnchere == enchere.montantEnchere && dateEnchere.equals(enchere.dateEnchere) && article.equals(enchere.article) && encherisseur.equals(enchere.encherisseur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateEnchere, montantEnchere, article, encherisseur);
	}
}