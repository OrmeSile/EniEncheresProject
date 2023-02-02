package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.Utilisateur;

import java.util.ArrayList;

public interface DAO<T> {
	public T getOneById(int id);
	public ArrayList<T> getAll();
	public T insert(T object);
}