package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;

import java.util.ArrayList;

public interface UserFetchable<T> {
	public ArrayList<T> getAllByUser(Utilisateur user) throws BusinessException;
}
