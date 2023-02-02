package fr.eni.ecole.encheres.dal;

import java.util.ArrayList;

public interface UserFetchable<T> {
	public ArrayList<T> getAllByUserId(int id);
}
