package fr.eni.ecole.encheres.bo.utils;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class FilterPayload {
	private FilterTags tags;
	private String query;
	private Categorie category;
	private Utilisateur user;

	public FilterPayload(FilterTags tags, String query, Categorie category, Utilisateur user) {
		this.tags = tags;
		this.query = query;
		this.category = category;
		this.user = user;
	}

	public Utilisateur getUser() {
		return user;
	}

	public FilterTags getTags() {
		return tags;
	}

	public String getQuery() {
		return query;
	}

	public Categorie getCategory() {
		return category;
	}
}

