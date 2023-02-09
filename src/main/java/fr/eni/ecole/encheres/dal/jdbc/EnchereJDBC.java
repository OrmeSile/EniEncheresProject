package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.sql.SQLException;
import java.sql.Timestamp;
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
                var date = LocalDateTime.of(rs.getDate(3).toLocalDate(), rs.getTime(3).toLocalTime());
                var montant = rs.getInt(4);
                return new Enchere(date, montant, user);
            }
            return null;
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
    public Enchere insert(Enchere object) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement("insert into ENCHERES values (?,?,?,?)");
            ps.setInt(1,object.getEncherisseur().getNoUtilisateur());
            ps.setInt(2, object.getArticle().getNoArticle());
            ps.setTimestamp(3,Timestamp.valueOf(object.getDateEnchere()));
            ps.setInt(4,object.getMontantEnchere());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
        return object;
    }

    @Override
    public void update(Enchere object) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement("update encheres set no_utilisateur = ?, date_enchere = ?, montant_enchere = ? where no_article = ?");
            ps.setInt(1, object.getEncherisseur().getNoUtilisateur());
            ps.setTimestamp(2, Timestamp.valueOf(object.getDateEnchere()));
            ps.setInt(3, object.getMontantEnchere());
            ps.setInt(4, object.getArticle().getNoArticle());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new BusinessException(e.getMessage());
        }
    }


    @Override
    public void delete(int id) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement("delete from ENCHERES where no_article = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
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
