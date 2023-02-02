package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;

import java.util.ArrayList;

public interface DAO<T> {
	public T getOneById(int id) throws BusinessException;
	public ArrayList<T> getAll()throws BusinessException;
	public T insert(T object)throws BusinessException;
}
