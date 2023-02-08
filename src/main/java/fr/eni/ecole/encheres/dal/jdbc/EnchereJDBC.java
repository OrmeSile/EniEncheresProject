package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EnchereJDBC implements ItemFetchable<Enchere, Utilisateur> {
    private final String GET_ALL_BY_USER =
            "select * from encheres e " +
                    "join ARTICLES_VENDUS a " +
                    "on e.no_article = a.no_article " +
                    "where e.no_utilisateur = ?";
    private final String GET_ALL_BY_ARTICLE =
            "select * from encheres e where no_article = ?";
    private final String GET_ENCHERE_BY_ID =
            "select * from utilisateurs u" +
                    " where no_utilisateur = ?";
    @Override
    public Enchere getOneById(int id) throws BusinessException{
        try(var con = ConnectionProvider.getConnection()){
            var pr = con.prepareStatement(GET_ALL_BY_ARTICLE);
            pr.setInt(1, id);
            var rs = pr.executeQuery();
            if(rs.next()){
                var user = DAOFactory.getUtilisateurDAO().getOneById(rs.getInt(1));
                var article = DAOFactory.getArticleDAO().getOneById(id);
                var date = LocalDateTime.of(rs.getDate(3).toLocalDate(), rs.getTime(3).toLocalTime());
                var montant = rs.getInt(4);
                var enchere = new Enchere(date, montant, article, user);
                article.setEnchere(enchere);
                return enchere;
            }
            throw new BusinessException("can't find enchere");
        }catch(SQLException e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Enchere> getAll() throws BusinessException{
        return null;
    }
    @Override
    public Enchere insert(Enchere object) {
        return null;
    }

    @Override
    public void update(Enchere object) throws BusinessException {

    }

    @Override
    public void delete(int id) throws BusinessException {

    }

    @Override
    public ArrayList<Enchere> getAllByParent(Utilisateur parent) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var pr = con.prepareStatement(GET_ALL_BY_USER);
            pr.setInt(1, parent.getNoUtilisateur());
            var rs = pr.executeQuery();
            var returnList = new ArrayList<Enchere>();
            while(rs.next()){
                var article = DAOFactory.getArticleDAO().getOneById(rs.getInt(2));
                var date = LocalDateTime.of(rs.getDate(3).toLocalDate(), rs.getTime(3).toLocalTime());
                var montant = rs.getInt(4);
                returnList.add(new Enchere(date, montant, article, parent));
            }
            return returnList;
        }catch(SQLException e){
            throw new BusinessException(e.getMessage());
        }
    }
}
