package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;

import java.util.ArrayList;

public interface ArticleFetchable<T> {
	public ArrayList<T> getOneByArticle(ArticleVendu article) throws BusinessException;
}
