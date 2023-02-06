package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.*;
import fr.eni.ecole.encheres.dal.jdbc.ArticleJDBC;
import fr.eni.ecole.encheres.dal.jdbc.CategorieJDBC;
import fr.eni.ecole.encheres.dal.jdbc.EnchereJDBC;
import fr.eni.ecole.encheres.dal.jdbc.UtilisateurJDBC;

public class DAOFactory {
	public static DAOUtilisateur getUtilisateurDAO(){
		return new UtilisateurJDBC();
	}
//	TODO: uncomment and implement
	public static ItemFetchable<ArticleVendu, Utilisateur> getArticleDAO(){return new ArticleJDBC();}
	public static ItemFetchable<Categorie, ArticleVendu> getCategorieDAO(){return new CategorieJDBC();}
	public static BiItemFetchable<Enchere, Utilisateur, ArticleVendu> getEnchereDAO(){
		return new EnchereJDBC();
	};
//	public static DAO<Retrait> getRetraitDAO();
}
