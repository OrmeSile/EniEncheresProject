package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;

import java.util.ArrayList;

public interface UserFetchable<T> {
	public ArrayList<T> getAllByUserId(int id) throws BusinessException;
}
