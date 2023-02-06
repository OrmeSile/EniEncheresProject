package fr.eni.ecole.encheres.bo;

import fr.eni.ecole.encheres.BusinessException;

import java.util.ArrayList;
import java.util.Objects;

public class Categorie {
	private int noCategorie;
	private String libelle;

	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Categorie{" + "noCategorie=" + noCategorie + ", libelle='" + libelle + '\'' + '}';

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Categorie categorie = (Categorie) o;
		return noCategorie == categorie.noCategorie && libelle.equals(categorie.libelle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(noCategorie, libelle);
	}
}
