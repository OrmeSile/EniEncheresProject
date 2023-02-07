package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.DAOUtilisateur;
import java.sql.*;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

public class UtilisateurJDBC implements DAOUtilisateur {
	private final String UPDATE = "update utilisateurs set no_utilisateur=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? where no_utilisateur = ?";
	private final String GET_ONE_BY_ID = "select * from utilisateurs  where no_utilisateur = ?";
	private final String LOGIN = "select no_utilisateur, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur from UTILISATEURS WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?";
	private final String INSERT = "INSERT INTO UTILISATEURS VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public Utilisateur getOneById(int id) throws BusinessException {
		try(var con = ConnectionProvider.getConnection()){
			var pr = con.prepareStatement(GET_ONE_BY_ID);
			pr.setInt(1,id);
			var rs = pr.executeQuery();
			if(rs.next()){
				String pseudo = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String email = rs.getString(5);
				String telephone = rs.getString(6);
				String rue = rs.getString(7);
				String codePostal = rs.getString(8);
				String ville = rs.getString(9);
				String mdp = rs.getString(10);
				int credit = rs.getInt(11);
				boolean administrateur = rs.getBoolean(12);
				return new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, credit, administrateur);
			}
		}catch (SQLException e){
			throw new BusinessException(e.getMessage());
		}
		return null;
	}
	@Override
	public ArrayList<Utilisateur> getAll() {
		return null;
	}

	@Override
	public Utilisateur insert(Utilisateur object) throws BusinessException {
		try(var con = ConnectionProvider.getConnection()){
			var ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, object.getPseudo());
			ps.setString(2, object.getNom());
			ps.setString(3, object.getPrenom());
			ps.setString(4, object.getEmail());
			ps.setString(5, object.getTelephone());
			ps.setString(6, object.getRue());
			ps.setString(7, object.getCodePostal());
			ps.setString(8, object.getVille());
			ps.setString(9, object.getMotDePasse());
			ps.setInt(10, object.getCredit());
			ps.setBoolean(11, object.isAdministrateur());
			var rs = ps.executeQuery();
			if(rs.next()){
				object.setNoUtilisateur(rs.getInt(1));
				return object;
			}
			throw new BusinessException("erreur d'insertion");
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void update(Utilisateur object) throws BusinessException {
		try(var con = ConnectionProvider.getConnection()){
			var ps = con.prepareStatement(UPDATE);
			ps.setString(1, object.getPseudo());
			ps.setString(2, object.getNom());
			ps.setString(3, object.getPrenom());
			ps.setString(4, object.getEmail());
			ps.setString(5, object.getTelephone());
			ps.setString(6, object.getRue());
			ps.setString(7, object.getCodePostal());
			ps.setString(8, object.getVille());
			ps.setString(9, object.getMotDePasse());
			ps.setInt(10, object.getCredit());
			ps.setBoolean(11, object.isAdministrateur());
			ps.setInt(12, object.getNoUtilisateur());
		}catch (SQLException e){
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws BusinessException {
		try(Connection con = ConnectionProvider.getConnection()){
			
			PreparedStatement ps = con.prepareStatement("{call dbo.cleanup_user (?)}");
				ps.setInt(1, id);
				ps.executeUpdate();	
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}

	public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
		BusinessException ex = new BusinessException();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(LOGIN);
			ps.setString(1, pseudo);
			ps.setString(2, pseudo);
			ps.setString(3, motDePasse);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String email = rs.getString(4);
				String telephone = rs.getString(5);
				String rue = rs.getString(6);
				String codePostal = rs.getString(7);
				String ville = rs.getString(8);
				int credit = rs.getInt(9);
				boolean administrateur = rs.getBoolean(10);
				var user = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
				user.setEncheres(DAOFactory.getEnchereDAO().getAllByParent(user));
				user.setArticles(DAOFactory.getArticleDAO().getAllByParent(user));
				return user;
			} else {
				ex.addExceptionMessage("Erreur de connexion");
				throw ex;
			}
		} catch (SQLException e) {
			ex.addExceptionMessage(e.getMessage());
			throw ex;
		}
	}
}
