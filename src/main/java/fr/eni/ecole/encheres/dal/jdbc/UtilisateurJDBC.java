package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.DAOUtilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurJDBC implements DAOUtilisateur {
	private final String GET_ONE_BY_ID = "select * from utilisateurs  where no_utilisateur = ?";
	private final String LOGIN = "select no_utilisateur, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur from UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	private final String UTILISATEUR = "INSERT INTO UTILISATEURS VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public Utilisateur getOneById(int id) throws BusinessException {
		try(var con = ConnectionProvider.getConnection()){
			var pr = con.prepareStatement(GET_ONE_BY_ID);
			pr.setInt(1,id);
			var rs = pr.executeQuery();
			Utilisateur user = null;
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
	public Utilisateur insert(Utilisateur object) {
		return null;
	}

	@Override
	public void update(Utilisateur object) throws BusinessException {

	}

	public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
		BusinessException ex = new BusinessException();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(LOGIN);
			ps.setString(1, pseudo);
			ps.setString(2, motDePasse);
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
//				TODO: uncomment + implement in DAOFactory + required JDBC
//				ArrayList<ArticleVendu> articles = DAOFactory.getArticleDAO().getAllByUserId(id);
//				ArrayList<Enchere> encheres = DAOFactory.getEnchereDAO().getAllByUserId(id);
				return new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
			} else {
				ex.addExceptionMessage("Erreur de connection");
				throw ex;
			}
		} catch (SQLException e) {
			ex.addExceptionMessage(e.getMessage());
			throw ex;
		}
	}
}
