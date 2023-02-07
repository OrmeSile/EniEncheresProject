package fr.eni.ecole.encheres.dal.tests;

import fr.eni.ecole.encheres.bo.utils.FilterTags;
import fr.eni.ecole.encheres.dal.jdbc.ArticleJDBC;

public class DALTests {
	public static void main(String[] args) {
		var params = new FilterTags(true, true, true, true, false, false, true, false);
		var dao = new ArticleJDBC();
	}
	public void printQuery(){

	}
}
