package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DAO;

import java.util.ArrayList;

public class CategorieJDBC implements DAO<Categorie> {
    @Override
    public Categorie getOneById(int id) {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAll() {
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
