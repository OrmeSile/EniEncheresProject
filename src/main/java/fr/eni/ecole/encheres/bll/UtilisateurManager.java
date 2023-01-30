package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOUtilisateur;

public class UtilisateurManager {
	private DAOUtilisateur dao;
	private static UtilisateurManager manager;

	public UtilisateurManager(DAOUtilisateur dao) {
		this.dao = dao;
	}
}
