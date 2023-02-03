package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.util.ArrayList;
import java.util.Objects;

public class ArticleManager {
	private final ItemFetchable<ArticleVendu, Utilisateur> dao;
	private static ArticleManager manager;

	private ArticleManager(){
		dao = DAOFactory.getArticleDAO();
	}
	public static ArticleManager getManager(){
		if(Objects.isNull(manager)){
			manager = new ArticleManager();
		}
		return manager;
	}

	public ArticleVendu getOneArticleById(int id) throws BusinessException {
		return dao.getOneById(id);
	}
	public ArrayList<ArticleVendu> getAllArticlesByUtilisateur(Utilisateur user) throws BusinessException{
		return dao.getAllByParent(user);
	}
	public ArrayList<ArticleVendu> getAll() throws BusinessException{
		return dao.getAll();
	}
}
