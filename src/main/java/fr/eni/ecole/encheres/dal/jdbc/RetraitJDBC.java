package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.sql.*;
import java.util.ArrayList;

public class RetraitJDBC implements ItemFetchable<Retrait, ArticleVendu> {
    private final String GET_ONE_BY_ID = "select * from retraits where no_article = ?";
    private final String INSERT = "insert into retraits values ?,?,?,?";
    private final String GET_ALL_BY_PARENT = "select * from retraits where no_article = ?";
    @Override
    public Retrait getOneById(int id) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(GET_ONE_BY_ID);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if(rs.next()){
                var rue = rs.getString(2);
                var cp = rs.getString(3);
                var ville = rs.getString(4);
                var article = DAOFactory.getArticleDAO().getOneById(rs.getInt(1));
                return new Retrait(rue, cp, ville, article);
            }
            throw new BusinessException("Retrait not found");
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }


        @Override
//    TODO see if needed
    public ArrayList<Retrait> getAll() throws BusinessException{
//        try (var con = ConnectionProvider.getConnection()) {
//            var rs = con.prepareStatement(GET_ALL).executeQuery();
//            var list = new ArrayList<Retrait>();
//            while(rs.next()){
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }
    @Override
    public  Retrait insert(Retrait object) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(INSERT);
            ps.setString(2, object.getRue());
            ps.setString(3,object.getCodePostal());
            ps.setString(4, object.getVille());
            ps.executeUpdate();
            return object;
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void update(Retrait object) throws BusinessException {

    }

    @Override
    public void delete(int id) throws BusinessException {

    }

    @Override
    public ArrayList<Retrait> getAllByParent(ArticleVendu parent) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(GET_ALL_BY_PARENT);
            ps.setInt(1 ,parent.getNoArticle());
            var rs = ps.executeQuery();
            if(rs.next()){
                var rue = rs.getString(1);
                var codePostal = rs.getString(2);
                var ville = rs.getString(3);
                var list = new ArrayList<Retrait>();
                list.add(new Retrait(rue, codePostal, ville, parent));
                return list;
            }
        }
    catch (SQLException e){
            throw new BusinessException(e.getMessage());
        }
        return null;
    }
}
