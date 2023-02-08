package fr.eni.ecole.encheres.bo.utils;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;

import java.util.Objects;

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
	private FilterPayload(FilterTags tags, String query, Categorie category){
		this.tags = tags;
		this.query = query;
		this.category = category;
		this.user = null;
	}
	public static FilterPayload getVisitorPayload(String query, Categorie category){
		var tags = new FilterTags(!(Objects.isNull(query)||query.isBlank()), !(Objects.isNull(category)), false, true, false, false, false, false);
		return new FilterPayload(tags, query, category);
	}

	public FilterPayload(FilterTags tags, String query, Categorie category, Utilisateur user) {
		this.tags = tags;
		this.query = query;
		this.category = category;
		this.user = user;
	}
	public static FilterPayload getEmpty(){
		return new FilterPayload();
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

