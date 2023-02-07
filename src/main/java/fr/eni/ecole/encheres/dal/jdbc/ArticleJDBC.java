package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.*;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;
import fr.eni.ecole.encheres.tools.ArticleStateConverter;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class ArticleJDBC implements ItemFetchable<ArticleVendu, Utilisateur> {
	private final String UPDATE = "update articles_vendus set nom_article=?, 'description'=?,date_debut_enchere = ?,date_fin_enchere = ?, prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ?, etat_vente = ?, image = ? where no_article = ?";
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS('nom_article','description',date_debut_enchere,date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, 'etat_vente', image ) values ?,?,?,?,?,?,?,?,?,?";
	private final String GET_ALL = "select * from articles_vendus a join CATEGORIES c on a.no_categorie = c.no_categorie left join RETRAITS r on a.no_article = r.no_article";

	@Override
	public ArticleVendu getOneById(int id) throws BusinessException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(GET_ALL + " where a.no_article = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return buildArticleFromResultSet(rs);
			}
			throw new BusinessException("no article found for id " + id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public ArrayList<ArticleVendu> getAll() throws BusinessException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(GET_ALL);
			ResultSet rs = ps.executeQuery();
			ArrayList<ArticleVendu> articles = new ArrayList<>();
			while (rs.next()) {
				ArticleVendu article = buildArticleFromResultSet(rs);
				articles.add(article);
			}
			return articles;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("exception");
			throw new BusinessException(e.getMessage());
		}
	}

	public ArrayList<ArticleVendu> getAllByCategorie(Categorie categorie) throws BusinessException{
		try(var con = ConnectionProvider.getConnection()){
			var ps = con.prepareStatement(GET_ALL + " where a.no_categorie = ?");
			ps.setInt(1, categorie.getNoCategorie());
			var rs = ps.executeQuery();
			ArrayList<ArticleVendu> articles = new ArrayList<>();
			while(rs.next()){
				articles.add(buildArticleFromResultSet(rs));
			}
			return articles;
		}catch (SQLException e){
			throw new BusinessException("can't get by categorie");
		}
	}

	@Override
	public ArticleVendu insert(ArticleVendu object) throws BusinessException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT, java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, object.getNomArticle());
			ps.setString(2, object.getDescription());
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(object.getDateDebutEncheres()));
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(object.getDateFinEncheres()));
			ps.setInt(5, object.getMiseAPrix());
			ps.setInt(6, object.getPrixVente());
			ps.setInt(7, object.getVendeur().getNoUtilisateur());
			ps.setInt(8, object.getCategorieArticle().getNoCategorie());
			ps.setString(9, object.getEtatVente().getState());
			ps.setString(10, object.getImage());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				object.setNoArticle(rs.getInt(1));
				return object;
			}
			throw new BusinessException("can't insert user");
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void update(ArticleVendu object) throws BusinessException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1, object.getNomArticle());
			ps.setString(2, object.getDescription());
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(object.getDateDebutEncheres()));
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(object.getDateFinEncheres()));
			ps.setInt(5, object.getMiseAPrix());
			ps.setInt(6, object.getPrixVente());
			ps.setInt(7, object.getVendeur().getNoUtilisateur());
			ps.setInt(8, object.getCategorieArticle().getNoCategorie());
			ps.setString(9, object.getEtatVente().getState());
			ps.setString(10, object.getImage());
			ps.setInt(11, object.getNoArticle());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws BusinessException {

	}

	@Override
	public ArrayList<ArticleVendu> getAllByParent(Utilisateur parent) throws BusinessException {
		try (var con = ConnectionProvider.getConnection()) {
			var pr = con.prepareStatement((GET_ALL + " where no_utilisateur = ?"));
			pr.setInt(1, parent.getNoUtilisateur());
			var rs = pr.executeQuery();
			var returnList = new ArrayList<ArticleVendu>();
			while (rs.next()) {
				var noArticle = rs.getInt(1);
				var nom = rs.getString(2);
				var description = rs.getString(3);
				var dateDebut = LocalDateTime.of(rs.getDate(4).toLocalDate(), rs.getTime(4).toLocalTime());
				var dateFin = LocalDateTime.of(rs.getDate(5).toLocalDate(), rs.getTime(5).toLocalTime());
				var miseAPrix = rs.getInt(6);
				var prixVente = rs.getInt(7);
				var etatVente = ArticleStateConverter.getEnumFromString(rs.getString(10));
				var image = rs.getString(11);
				var categorie = new Categorie(rs.getInt(12), rs.getString(13));
				var retrait = new Retrait(rs.getString(15), rs.getString(16), rs.getString(17));
				var article = new ArticleVendu(noArticle, nom, description, dateDebut, dateFin, miseAPrix, prixVente, etatVente, parent, retrait, categorie, image);
				retrait.setArticle(article);
				var encheres = DAOFactory.getEnchereDAO().getAllBySecondParent(article);
				article.setEncheres(encheres);
				returnList.add(article);
			}
			parent.setArticles(returnList);
			return returnList;
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	private ArticleVendu buildArticleFromResultSet(ResultSet rs) throws BusinessException {
		try {
			var id = rs.getInt(1);
			var nom = rs.getString(2);
			var description = rs.getString(3);
			var dateDebut = LocalDateTime.of(rs.getDate(4).toLocalDate(), rs.getTime(4).toLocalTime());
			var dateFin = LocalDateTime.of(rs.getDate(5).toLocalDate(), rs.getTime(5).toLocalTime());
			var miseAPrix = rs.getInt(6);
			var prixVente = rs.getInt(7);
			var etatVente = ArticleStateConverter.getEnumFromString(rs.getString(10));
			var image = rs.getString(11);
			var categorie = new Categorie(rs.getInt(12), rs.getString(13));
			boolean retraitIsNull = Stream.of(rs.getString(15), rs.getString(16), rs.getString(17)).anyMatch(Objects::isNull);
			var user = DAOFactory.getUtilisateurDAO().getOneById(rs.getInt(8));
			var retrait = retraitIsNull ? new Retrait(user.getRue(), user.getCodePostal(), user.getVille()) : new Retrait(rs.getString(15), rs.getString(16), rs.getString(17));
			var article = new ArticleVendu(id, nom, description, dateDebut, dateFin, miseAPrix, prixVente, etatVente, user, retrait, categorie, image);
			retrait.setArticle(article);
			article.setEncheres(DAOFactory.getEnchereDAO().getAllBySecondParent(article));
			user.getArticles().add(article);
			return article;
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
	}
}