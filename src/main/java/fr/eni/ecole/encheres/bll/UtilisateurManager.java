package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.DAOUtilisateur;

import java.time.LocalDate;
import java.util.Objects;

public class UtilisateurManager {
	private DAOUtilisateur dao;
	private static UtilisateurManager manager;

	private UtilisateurManager() {
		dao = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateurManager getUtilisateurManager() {
		if (Objects.isNull(manager)) {
			manager = new UtilisateurManager();
		}
		return manager;
	}

	public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
		// TODO ajouter contraintes de validation mot de passe/utilisateur (null check,
		// longueur, caractères...)
		return dao.seConnecter(pseudo, motDePasse);
	}

	public Utilisateur ajouter() {
		// TODO : tester la validité de la description et de la note
		// Utilisateur utilisateur = new Utilisateur();
		// return utilisateur;
		return null;
	}
}
