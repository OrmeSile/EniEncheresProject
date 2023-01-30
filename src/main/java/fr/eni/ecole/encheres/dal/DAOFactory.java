package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.dal.jdbc.UtilisateurJDBC;

public class DAOFactory {
	public static DAOUtilisateur getUtilisateurDAO(){
		return new UtilisateurJDBC();
	}
}
