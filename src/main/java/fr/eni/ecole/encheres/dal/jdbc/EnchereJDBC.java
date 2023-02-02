package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.UserFetchable;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnchereJDBC implements DAO<Enchere>, UserFetchable<Enchere> {
    private final String GET_ALL_BY_USER = "select * from encheres e join ARTICLES_VENDUS a on e.no_article = a.no_article where no_utilisateur = ?";
    @Override
    public Enchere getOneById(int id) {

    }

    @Override
    public ArrayList<Enchere> getAll() throws BusinessException{

    }
    @Override
    public Enchere insert(Enchere object) {
        return null;
    }

    @Override
    public ArrayList<Enchere> getAllByUser(Utilisateur user) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(GET_ALL_BY_USER);
            ps.setInt(1, user.getNoUtilisateur());
            var rs = ps.executeQuery();
            while(rs.next()){
                rs.
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
