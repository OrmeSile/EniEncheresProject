package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;

import java.util.ArrayList;

public interface BiItemFetchable <T, P, Q> extends ItemFetchable<T,P>{
	public ArrayList<T> getAllBySecondParent(Q parent) throws BusinessException;
}
