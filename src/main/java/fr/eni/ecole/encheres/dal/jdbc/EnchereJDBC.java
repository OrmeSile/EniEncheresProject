package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.BiItemFetchable;
import java.util.ArrayList;

public class EnchereJDBC implements BiItemFetchable<Enchere, Utilisateur, ArticleVendu> {
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

    @Override
    public void update(Enchere object) throws BusinessException {

    }

    @Override
    public ArrayList<Enchere> getAllByParent(Utilisateur parent) throws BusinessException {
        return null;
    }

    @Override
    public ArrayList<Enchere> getAllBySecondParent(ArticleVendu parent) throws BusinessException {
        return null;
    }
}
