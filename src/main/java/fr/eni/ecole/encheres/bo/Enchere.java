package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Enchere {
	LocalDateTime dateEnchere;
	double montantEnchere;
<<<<<<< HEAD
	private ArticleVendu article;
=======
	private ArrayList<ArticleVendu> articles;
	private ArrayList<Utilisateur> utilisateurs;
>>>>>>> refs/heads/BO-ASSOCIATION

	public Enchere(LocalDateTime dateEnchere, double montantEnchere,ArrayList<ArticleVendu> articles,ArrayList<Utilisateur> utilisateurs ) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articles = articles;
		this.utilisateurs = utilisateurs;
	}
<<<<<<< HEAD
	public void setArticle(ArticleVendu article){
		this.article = article;
	}
=======

	public ArrayList<ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleVendu> articles) {
		this.articles = articles;
	}

	public ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public void addArticle(ArticleVendu article) {
		this.articles.add(article);
	}
	public void addUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}
	
>>>>>>> refs/heads/BO-ASSOCIATION
}