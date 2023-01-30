package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;

public interface DAOUser extends DAO<Utilisateur>{
	public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException;
}
