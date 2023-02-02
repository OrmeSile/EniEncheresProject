package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ArticleFetchable;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.UserFetchable;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class RetraitJDBC implements DAO<Retrait> {
    private final String GET_ONE_BY_ID = "select rue, code_postal, ville from retraits where no_article = ?";
    private final String INSERT = "insert into retraits values ?,?,?,?";
    private final String GET_ALL = "select r.no_article, rue, code_postal, ville, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image from retraits r join articles_vendus a on r.no_article = a.no_article ";

    @Override
    public Retrait getOneById(int id) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(GET_ONE_BY_ID);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if(rs.next()){
                var rue = rs.getString(1);
                var cp = rs.getString(2);
                var ville = rs.getString(3);
                return new Retrait(rue, cp, ville);
            }
            throw new BusinessException("Retrait not found");
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    //TODO see if needed
    public ArrayList<Retrait> getAll() throws BusinessException{
        try (var con = ConnectionProvider.getConnection()) {
            var rs = con.prepareStatement(GET_ALL).executeQuery();
            var list = new ArrayList<Retrait>();
            while(rs.next()){
                var itemId = rs.getInt(1);
                var rue = rs.getString(2);
                var cp = rs.getString(3);
                var ville = rs.getString(4);
                var nomArticle = rs.getString(5);
                var description = rs.getString(6);
                var debut = LocalDateTime.of(rs.getDate(7).toLocalDate(),rs.getTime(7).toLocalTime());
                var fin = LocalDateTime.of(rs.getDate(8).toLocalDate(),rs.getTime(8).toLocalTime());
                var prixInitial = rs.getInt(9);
                var prixVente = rs.getInt(10);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public  Retrait insert(Retrait object) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(INSERT);
            ps.setInt(1,object.getArticle().getNoArticle());
            ps.setString(2, object.getRue());
            ps.setString(3,object.getCodePostal());
            ps.setString(4, object.getVille());
            ps.executeUpdate();
            return object;
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
