package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.UserFetchable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArticleJDBC implements DAO<ArticleVendu>, UserFetchable<ArticleVendu> {
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS('nom_article','description',date_debut_enchere,date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, 'etat_vente', image ) values ?,?,?,?,?,?,?,?,?,?";
	private final String ALL = "select * from ARTICLES_VENDUS";
	private final String USERID = "select * from ARTICLES_VENDUS where no_utilisateur =?";
	private final String ID = "select * from ARTICLES_VENDUS where no_article = ?";
	@Override
	public ArticleVendu getOneById(int id) throws BusinessException {
		BusinessException ex = new BusinessException();
		try(Connection con = ConnectionProvider.getConnection()){
			PreparedStatement ps = con.prepareStatement(ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next());
			String nomArticle = rs.getString(2);
			String description = rs.getString(3);
			LocalDateTime dateDebutEnchere = LocalDateTime
					.of(rs.getDate(1).toLocalDate(),
						rs.getTime(1).toLocalTime());
			LocalDateTime dateFinEnchere = LocalDateTime
					.of(rs.getDate(1).toLocalDate(),
						rs.getTime(1).toLocalTime());
			int prixInitial = rs.getInt(6);
			int prixVente = rs.getInt(7);
			String etatVente = rs.getString(8);
			String image = rs.getString(9);
			ArrayList<Enchere> = rs.getArray(10, "Enchere");
			
			
		} catch (SQLException e) {
			ex.addExceptionMessage(e.getMessage());
			throw ex;
		}
		return null;
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
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(object.getDateDebutEnchere()));
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(object.getDateFinEnchere()));
			ps.setInt(5, object.getPrixInitial());
			ps.setInt(6, object.getPrixVente());
			ps.setInt(7, object.getUtilisateur().getNoUtilisateur());
			ps.setInt(8, object.getcategorieArticle().getId());
			ps.setString(9, object.getEtatVente());
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
	public ArrayList<ArticleVendu> getAllByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}