package fr.eni.ecole.encheres.dal.tests;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class DALTests {
	public static void main(String[] args) {
		try{
			var user = DAOFactory.getUtilisateurDAO().getOneById(1);
			var articles = DAOFactory.getArticleDAO().getAllByParent(user);
		} catch (BusinessException e) {
			throw new RuntimeException(e);
		}
	}
}
