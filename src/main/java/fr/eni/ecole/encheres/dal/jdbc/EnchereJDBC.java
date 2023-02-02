package fr.eni.ecole.encheres.dal.jdbc;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.UserFetchable;

import java.util.ArrayList;

public class EnchereJDBC implements DAO<Enchere>, UserFetchable<Enchere> {

    @Override
    public Enchere getOneById(int id) {
    }

    @Override
    public ArrayList<Enchere> getAll() {
        return null;
    }

    @Override
    public Enchere insert(Enchere object) {
        return null;
    }

    @Override
    public ArrayList<Enchere> getAllByUserId(int id) throws BusinessException {
        return null;
    }
}
