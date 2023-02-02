package fr.eni.ecole.encheres.bo;

import fr.eni.ecole.encheres.BusinessException;

import java.util.ArrayList;

public class Categorie {
	private ArrayList<ArticleVendu> articles;
	private String libelle;
	private int id;

	public Categorie() {
		articles = new ArrayList<>();
		libelle = null;
	}
	
	public Categorie(ArrayList<ArticleVendu> articles, String libelle, int id) {
		super();
		this.articles = articles;
		this.libelle = libelle;
		this.id = id;
	}

	public Categorie(String libelle) {
		this.libelle = libelle;
		articles = new ArrayList<>();
	}
	public Categorie (ArrayList<ArticleVendu> articles, String libelle){
		this.articles = articles;
		this.libelle = libelle;
	}

	public ArrayList<ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleVendu> articles) {
		this.articles = articles;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void ajouterArticle(ArticleVendu article){
		articles.add(article);
	}
	public ArticleVendu getArticleById(int id) throws BusinessException {
		for( ArticleVendu a : articles){
			if(a.getNoArticle() == id){
				return a;
			}
		}
		throw new BusinessException("Article id -> "+id + "introuvable dans la catégorie "+this.libelle);
	}

	@Override
	public String toString() {
		return "Categorie{" + "articles=" + articles + ", libelle='" + libelle + '\'' + '}';
	}
}
