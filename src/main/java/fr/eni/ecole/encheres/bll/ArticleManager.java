package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.DAOFactory;

import java.util.ArrayList;
import java.util.Objects;

public class ArticleManager {
	private final DAO<ArticleVendu> dao;
	private static ArticleManager manager;

	private ArticleManager(){
		dao = DAOFactory.getArticleDAO();
	}

	public static ArticleManager getArticleManager(){
		if(Objects.isNull(manager)){
			manager = new ArticleManager();
		}
		return manager;
	}

	public ArticleVendu ajouterArticle(ArticleVendu article) throws BusinessException {
		return dao.insert(article);
	}

	public ArrayList<ArticleVendu> getArticlesByUtilisateur(Utilisateur user) throws BusinessException{
		//return dao.getAllByUserId(user);
		return null;
	}

	public ArrayList<ArticleVendu> getAllArticles() throws BusinessException{
		return dao.getAll();
	}
}
