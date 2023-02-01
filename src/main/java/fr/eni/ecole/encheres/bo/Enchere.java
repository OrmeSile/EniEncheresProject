package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;
public class Enchere {
	LocalDateTime dateEnchere;
	double montantEnchere;
	private ArticleVendu article;

	public Enchere(LocalDateTime dateEnchere, double montantEnchere ) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
  
	public void setArticle(ArticleVendu article){
		this.article = article;
  }
}