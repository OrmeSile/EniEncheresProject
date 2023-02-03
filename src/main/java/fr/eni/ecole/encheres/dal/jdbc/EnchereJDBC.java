package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
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
    private final String GET_USER_BY_ID =
            "select * from utilisateurs u where no_utilisateur = ?";
    @Override
    public Enchere getOneById(int id) {
        return null;
    }

    @Override
    public ArrayList<Enchere> getAll() throws BusinessException{
        return null;
    }
    @Override
    public Enchere insert(Enchere object) {
        return null;
    }

    public ArrayList<Enchere> getAllByUser(Utilisateur user) throws BusinessException {
        try(var con = ConnectionProvider.getConnection()){
            var ps = con.prepareStatement(GET_ALL_BY_USER);
            ps.setInt(1, user.getNoUtilisateur());
            var rs = ps.executeQuery();
            ArrayList<Enchere> encheres = new ArrayList<>();
            while(rs.next()){
//               encheres.add(new Enchere(LocalDateTime.of(rs.getDate(3).toLocalDate(), rs.getTime(3).toLocalTime()), rs.getInt(4)));
               var idArticle = rs.getInt(5);
               var nom = rs.getString(6);
               var description = rs.getString(7);
               var debut = LocalDateTime.of(rs.getDate(8).toLocalDate(), rs.getTime(8).toLocalTime());
               var fin = LocalDateTime.of(rs.getDate(9).toLocalDate(), rs.getTime(9).toLocalTime());
               var prixInit = rs.getInt(10);
               var prixFin = rs.getInt(11);
               var etat = rs.getString(14);
               var image = rs.getString(15);
//               encheres.get(encheres.size()-1).setUser(user);
            }
            return encheres;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Enchere> getAllByParent(Utilisateur parent) throws BusinessException {
        return null;
    }
}
