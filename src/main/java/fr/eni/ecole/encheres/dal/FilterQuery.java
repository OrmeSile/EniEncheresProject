package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.utils.FilterPayload;
import java.util.ArrayList;

public interface FilterQuery<T> {
	public ArrayList<T> getFilteredObjects(FilterPayload payload) throws BusinessException;
}
