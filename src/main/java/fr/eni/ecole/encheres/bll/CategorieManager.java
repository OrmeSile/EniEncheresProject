package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.util.ArrayList;
import java.util.Objects;

public class CategorieManager {
	private ItemFetchable<Categorie, ArticleVendu> dao;
	private static CategorieManager manager;

	private CategorieManager(){
		dao = DAOFactory.getCategorieDAO();
	}
	public static CategorieManager getManager(){
		if(Objects.isNull(manager)){
			manager = new CategorieManager();
		}
		return manager;
	}

	public ArrayList<Categorie> getCategories() throws BusinessException {
		return dao.getAll();
	}
}
