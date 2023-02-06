package fr.eni.ecole.encheres.bo;

import java.util.ArrayList;
import java.util.Objects;

public class Retrait {
	String rue;
	String codePostal;
	String ville;
	ArticleVendu article;
	public Retrait(String rue, String codePostal, String ville, ArticleVendu article) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}

	public Retrait(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
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

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Retrait{" +
				"rue='" + rue + '\'' +
				", codePostal='" + codePostal + '\'' +
				", ville='" + ville + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Retrait retrait = (Retrait) o;
		return rue.equals(retrait.rue) && codePostal.equals(retrait.codePostal) && ville.equals(retrait.ville) && article.equals(retrait.article);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rue, codePostal, ville, article);
	}
}
/*CREATE TABLE RETRAITS (
		no_article       INTEGER NOT NULL,
	    rue              VARCHAR(30) NOT NULL,
	    code_postal      VARCHAR(15) NOT NULL,
	    ville            VARCHAR(30) NOT NULL
	)*/