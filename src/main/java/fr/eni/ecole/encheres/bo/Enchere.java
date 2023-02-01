package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;
public class Enchere {
	private LocalDateTime dateEnchere;
	private double montantEnchere;
	private ArticleVendu article;
	private Utilisateur user;

	public Enchere(LocalDateTime dateEnchere, double montantEnchere, ArticleVendu article, Utilisateur user) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.user = user;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
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

	public void setMontantEnchere(double montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article){
		this.article = article;
  }

	@Override
	public String toString() {
		return "Enchere{" + "dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", article=" + article + '}';
	}
}