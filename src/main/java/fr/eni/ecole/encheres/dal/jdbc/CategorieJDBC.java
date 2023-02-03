package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.ItemFetchable;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieJDBC implements ItemFetchable<Categorie, ArticleVendu> {

    private final String GET_ALL = "select * from categories";

    @Override
    public Categorie getOneById(int id) {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAll() throws BusinessException {
        try(var con = ConnectionProvider.getConnection()) {
            var rs = con.prepareStatement(GET_ALL).executeQuery();
            ArrayList<Categorie> categories = new ArrayList<>();
            while(rs.next()){
                var id = rs.getInt(1);
                var libelle = rs.getString(2);
                categories.add(new Categorie(id, libelle));
            }
            return categories;
        }catch (SQLException e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Categorie> getAllByParent(ArticleVendu parent) throws BusinessException {
        return null;
    }

    @Override
    public Categorie insert(Categorie object) {
        return null;
    }

    @Override
    public void update(Categorie object) throws BusinessException {

    }

    @Override
    public void delete(int id) throws BusinessException {

    }
}
