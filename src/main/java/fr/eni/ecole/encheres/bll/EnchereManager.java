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

	public Enchere addEnchere(Utilisateur user, int montant, int articleId, Enchere previous) throws BusinessException {
		if(montant <= 0){
			throw new BusinessException("negative amount");
		}
		if(montant > user.getCredit()){
			throw new BusinessException("low credits");
		}
		var article = ArticleManager.getManager().getOneArticleById(articleId);
		if(Objects.isNull(previous)) {
			dao.insert(new Enchere(LocalDateTime.now(), montant, article, user));
			return dao.getOneById(articleId);
		} else if (previous.getMontantEnchere() < montant) {
			user.setCredit(user.getCredit() - montant);
			var prevUser = previous.getEncherisseur();
			prevUser.setCredit(prevUser.getCredit()+previous.getMontantEnchere());
			UtilisateurManager.getUtilisateurManager().updateUser(prevUser);
			dao.update(new Enchere(LocalDateTime.now(), montant, article, user));
			UtilisateurManager.getUtilisateurManager().updateUser(user);
			return dao.getOneById(articleId);
		}else {
			throw new BusinessException("invalid amount");
		}
	}
	public Enchere getEnchere(int id) throws BusinessException{
		return dao.getOneById(id);
	}
}