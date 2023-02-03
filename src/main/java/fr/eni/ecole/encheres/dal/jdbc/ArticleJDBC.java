package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.EtatVente;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.ItemFetchable;
import fr.eni.ecole.encheres.tools.ArticleStateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArticleJDBC implements ItemFetchable<ArticleVendu, Utilisateur> {
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS('nom_article','description',date_debut_enchere,date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, 'etat_vente', image ) values ?,?,?,?,?,?,?,?,?,?";
	private final String ALL = "select * from ARTICLES_VENDUS";
	private final String USERID = "select * from ARTICLES_VENDUS where no_utilisateur =?";
	private final String GET_ALL_BY_PARENT = "select * from articles_vendus a join CATEGORIES c on a.no_categorie = c.no_categorie where no_utilisateur = ?";
	private final String GET_ONE_BY_ID = "select * from ARTICLES_VENDUS where no_article = ?";
	@Override
	public ArticleVendu getOneById(int id) throws BusinessException {
		BusinessException ex = new BusinessException();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement ps = con.prepareStatement(GET_ONE_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nomArticle = rs.getString(2);
				String description = rs.getString(3);
				LocalDateTime dateDebutEnchere = LocalDateTime.of(rs.getDate(1).toLocalDate(), rs.getTime(1).toLocalTime());
				LocalDateTime dateFinEnchere = LocalDateTime.of(rs.getDate(1).toLocalDate(), rs.getTime(1).toLocalTime());
				int miseAPrix = rs.getInt(6);
				int prixVente = rs.getInt(7);
				EtatVente etatVente = convertEtatVente(rs.getString(8));
				String image = rs.getString(9);
			}
			
		} catch (SQLException e) {
			ex.addExceptionMessage(e.getMessage());
			throw ex;
		}
		return null;
	}

	private EtatVente convertEtatVente(String etatVente) throws BusinessException {
		switch (etatVente){
			case "CR":
				return EtatVente.CREE;
			case "EC":
				return EtatVente.EN_COURS;
			case "VD":
				return EtatVente.VENDU;
			case "RT":
				return EtatVente.RETIRE;
			default:
				var be = new BusinessException();
				be.addExceptionMessage("bad EtatVente DB status");
				throw be;
		}
		//'CR','EC','VD','RT'
	}
	@Override
	public ArrayList<ArticleVendu> getAll() {//boucle while
		return null;
	}

	@Override
	public ArticleVendu insert(ArticleVendu object) throws BusinessException{
		BusinessException ex = new BusinessException();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement ps = con.prepareStatement(INSERT,java.sql.Statement.RETURN_GENERATED_KEYS);
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
			if(rs.next()) {
				object.setNoArticle(rs.getInt(1));
				return object;
			}else{
				ex.addExceptionMessage("Erreur d'insertion");
				throw ex;
			}
		}catch(SQLException e) {
			ex.addExceptionMessage(e.getMessage());
			throw ex;
		}
	}

	@Override
	public ArrayList<ArticleVendu> getAllByParent(Utilisateur parent) throws BusinessException {
		try(var con = ConnectionProvider.getConnection()){
			var pr = con.prepareStatement(GET_ALL_BY_PARENT);
			pr.setInt(1,parent.getNoUtilisateur());
			var rs = pr.executeQuery();
			var returnList = new ArrayList<ArticleVendu>();
			while(rs.next()){
				var noArticle = rs.getInt(1);
				var nom = rs.getString(2);
				var description = rs.getString(3);
				var dateDebut = LocalDateTime.of(rs.getDate(4).toLocalDate(), rs.getTime(4).toLocalTime());
				var dateFin = LocalDateTime.of(rs.getDate(5).toLocalDate(), rs.getTime(5).toLocalTime());
				var prixInitial = rs.getInt(6);
				var prixVente = rs.getInt(7);
				var etatVente = ArticleStateConverter.getEnumFromString(rs.getString(10));
				var image = rs.getString(11);
				var categorie = new Categorie(rs.getInt(12), rs.getString(13));
				new ArticleVendu(noArticle, nom, description, dateDebut, dateFin, prixInitial, prixVente, )

			}
		}catch(SQLException e){
			throw new BusinessException(e.getMessage());
		}
		return null;
	}
}