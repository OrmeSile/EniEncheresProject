package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.dal.jdbc.ArticleJDBC;
import fr.eni.ecole.encheres.dal.jdbc.UtilisateurJDBC;

public class DAOFactory {
	public static DAOUtilisateur getUtilisateurDAO(){
		return new UtilisateurJDBC();
	}
	public static DAO<ArticleVendu> getArticleDAO(){
		return new ArticleJDBC();
	}
}
