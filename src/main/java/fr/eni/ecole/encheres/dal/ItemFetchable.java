package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;

import java.util.ArrayList;

public interface ItemFetchable<T, P> extends DAO<T> {
	public ArrayList<T> getAllByParent(P parent) throws BusinessException;
}
