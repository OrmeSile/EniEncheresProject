package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.jdbc.UtilisateurJDBC;

public class DAOFactory {
	public static DAOUtilisateur getUtilisateurDAO(){
		return new UtilisateurJDBC();
	}
//	TODO: uncomment and implement
//	public static DAO<ArticleVendu> getArticleDAO();
//	public static DAO<Categorie> getCategorieDAO();
//	public static DAO<Enchere> getEnchereDAO();
//	public static DAO<Retrait> getRetraitDAO();
}
