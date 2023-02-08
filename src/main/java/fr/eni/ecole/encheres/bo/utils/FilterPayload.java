package fr.eni.ecole.encheres.bo.utils;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class FilterPayload {
	private final FilterTags tags;
	private final String query;
	private final Categorie category;
	private final Utilisateur user;

	private FilterPayload(){
		tags = FilterTags.getEmpty();
		query = null;
		category = null;
		user = null;
	}
	public static FilterPayload getEmpty(){
		return new FilterPayload();
	}
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

