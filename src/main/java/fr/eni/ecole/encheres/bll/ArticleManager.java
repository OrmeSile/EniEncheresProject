package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.bo.utils.FilterPayload;
import fr.eni.ecole.encheres.bo.utils.FilterTags;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.FilterFetchable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class ArticleManager {
	private final FilterFetchable<ArticleVendu, Utilisateur> dao;
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
	public ArrayList<ArticleVendu> getLoggedOutObjects() throws BusinessException {
 		return dao.getLoggedOutObjects();

	}public ArrayList<ArticleVendu> getFilteredResults(FilterPayload payload) throws BusinessException {
		var results = dao.getFilteredObjects(payload);
		return dao.getFilteredObjects(payload);
	}
	public ArrayList<ArticleVendu> getFilteredResults(Utilisateur user) throws BusinessException {
		return getFilteredResults("", null, user, false, false, false, false, false, false);
	}
	public ArrayList<ArticleVendu> getFilteredResults(String query, Categorie cat, Utilisateur user, boolean isSell, boolean isOpen, boolean isBuySelf, boolean isBuyWon, boolean isSellPre, boolean isSellFin) throws BusinessException{
		var q = Objects.isNull(query) || query.isBlank() ? null : query;
		var qBool = !Objects.isNull(q);
		var catBool = !Objects.isNull(cat);
		if(isSell){
			if(Stream.of(isOpen, isSellPre, isSellFin).noneMatch(x -> x)){
				var tags = new FilterTags(qBool, catBool, true, true, false, false, false, false);
				var payload = new FilterPayload(tags, q, cat, user);
				return dao.getFilteredObjects(payload);
			}else{
				var tags = new FilterTags(qBool, catBool, true, isOpen, isBuySelf, isBuyWon, isSellPre, isSellFin);
				var payload = new FilterPayload(tags, q, cat, user);
				return dao.getFilteredObjects(payload);
			}
		}else{
			if(Stream.of(isOpen, isBuyWon, isBuySelf).noneMatch(x -> x)){
				var tags = new FilterTags(qBool, catBool, false, true, false, false, false, false);
				var payload = new FilterPayload(tags, q ,cat, user);
				return dao.getFilteredObjects(payload);
			}else{
				var tags = new FilterTags(qBool, catBool, false, isOpen, isBuySelf, isBuyWon, isSellPre, isSellFin);
				var payload = new FilterPayload(tags, q, cat, user);
				return dao.getFilteredObjects(payload);
			}
		}
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
