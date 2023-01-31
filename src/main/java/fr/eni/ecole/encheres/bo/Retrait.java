package fr.eni.ecole.encheres.bo;

import java.util.ArrayList;

public class Retrait {
	private int noArticle;
	String rue;
	String codePostal;
	String ville;
	private ArrayList<ArticleVendu> articles;
	
	public Retrait(int noArticle, String rue, String codePostal, String ville, ArrayList<ArticleVendu> articles) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articles = articles;
	}

	public Retrait(String rue, String codePostal, String ville ,  ArrayList<ArticleVendu> articles) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articles = articles;
	}

	public Retrait() {
		super();
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	public ArrayList<ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleVendu> articles) {
		this.articles = articles;
	}
		
}
/*CREATE TABLE RETRAITS (
		no_article       INTEGER NOT NULL,
	    rue              VARCHAR(30) NOT NULL,
	    code_postal      VARCHAR(15) NOT NULL,
	    ville            VARCHAR(30) NOT NULL
	)*/