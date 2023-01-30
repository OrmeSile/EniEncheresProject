package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.jdbc.UtilisateurJDBC;

public class DAOFactory {
	public static DAOUser getUtilisateurDAO(){
		return new UtilisateurJDBC();
	}
}
