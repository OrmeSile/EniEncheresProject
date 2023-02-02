package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.UserFetchable;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class RetraitJDBC implements DAO<Retrait>, UserFetchable<Retrait> {
    private final String GET_ALL_BY_USER_ID = "select r.no_article, rue, code_postal, ville from retraits r join encheres e on r.no_article = e.no_article where e.no_utilisateur = ?";
    private final String GET_ONE_BY_ID = "select no_article, rue, code_postal, ville from retraits where no_article = ?";
    private final String INSERT = "insert into retraits values ?,?,?,?";
    private final String GET_ALL = "select r.no_article, rue, code_postal, ville, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image from retraits r join articles_vendus a on r.no_article = a.no_article ";

    @Override
    public Retrait getOneById(int id) {
    }

    @Override
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
    public Retrait insert(Retrait object) {
        return null;
    }

    @Override
    public ArrayList<Retrait> getAllByUserId(int id) throws BusinessException {
        try (Connection con = ConnectionProvider.getConnection()) {
            PreparedStatement pr = con.prepareStatement(GET_ALL_BY_USER_ID);
            ResultSet rs = pr.executeQuery();
            ArrayList<Retrait> list = new ArrayList<>();
            while(rs.next()){
                int dbId = rs.getInt(1);
                String rue = rs.getString(2);
                String cp = rs.getString(3);
                String ville = rs.getString(4);
                list.add(new Retrait(dbId, rue, cp, ville));
            }
            return list;
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
