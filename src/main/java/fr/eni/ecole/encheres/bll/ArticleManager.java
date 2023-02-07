package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.time.LocalDateTime;
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
	public ArticleVendu addArticle (ArticleVendu article) throws BusinessException{
		BusinessException be = new BusinessException();
//methode de validation faire les méthodes plus bas		description = request.getParameter("description");
		addnomArticle(article.getNomArticle(), be);
		addescription(article.getDescription(), be);
		addmiseAprix(article.getMiseAPrix(), be);
		addDaterenseigner(article.getDateDebutEncheres(), article.getDateFinEncheres(), be);
		addDateOrdre(article.getDateDebutEncheres(), article.getDateFinEncheres(), be);
		addRue(article.getLieuRetrait().getRue(), be);
		addCp(article.getLieuRetrait().getCodePostal(), be);
		addville(article.getLieuRetrait().getVille(), be);
		return dao.insert(article);
	}
	
	private void addnomArticle (String nomArticle, BusinessException be ) {
		if(nomArticle == null || nomArticle.isBlank()) {
			be.addExceptionMessage("le nom de l'article doit être renseigner");
		}
	}
	private void addmiseAprix (int miseAPrix, BusinessException be ) {
		if(miseAPrix<=0) {
			be.addExceptionMessage("Veuillez renseigner le prix de l'article");
		}
	}
	private void addDaterenseigner (LocalDateTime dateDebutEncheres,LocalDateTime dateFinEncheres, BusinessException be ) {
		if( dateDebutEncheres == null || dateFinEncheres == null) {
			be.addExceptionMessage("veuillez renseigner les dates d'enchères");
		}
	}
	private void addDateOrdre (LocalDateTime dateDebutEncheres,LocalDateTime dateFinEncheres, BusinessException be ) {
		if(dateFinEncheres.isAfter(dateDebutEncheres)||dateDebutEncheres.isBefore(LocalDateTime.now())|| dateFinEncheres.isBefore(LocalDateTime.now())) {
			be.addExceptionMessage("veuillez respecter l'ordre des dates");
		}
	}
	private void addRue (String rue, BusinessException be ) {
		if(rue == null || rue.isBlank()) {
			be.addExceptionMessage("La rue doit être renseigner");
		}
	}
	private void addCp (String codePostal, BusinessException be ) {
		if(codePostal == null || codePostal.isBlank()) {
			be.addExceptionMessage("Le code postal doit être renseigner");
		}
	}
	private void addville (String ville, BusinessException be ) {
		if(ville == null || ville.isBlank()) {
			be.addExceptionMessage("la ville doit être renseigner");
		}
	}
	private void addescription (String description, BusinessException be ) {
		if(description == null || description.isBlank()) {
			be.addExceptionMessage("la description de l'article doit être renseigner");
		}
	}
}
