package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.time.LocalDateTime;
import java.util.Objects;

public class EnchereManager {
	private static EnchereManager manager;
	private ItemFetchable<Enchere, Utilisateur> dao;

	private EnchereManager(){
		dao = DAOFactory.getEnchereDAO();
	}
	public static EnchereManager getManager(){
		if(Objects.isNull(manager)){
			manager = new EnchereManager();
		}
		return manager;
	}

	public Enchere addEnchereOnArticle(Utilisateur user, int montant, int articleId) throws BusinessException {
		var dbEnchere = dao.getOneById(id);
		if (Objects.isNull(dbEnchere)) {
			dao.insert(enchere);
		} else {
			dao.update(enchere);
		}
		return dao.getOneById(id);
	}
}