package fr.eni.ecole.encheres.tools;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.EtatVente;

public class ArticleStateConverter {
	public static String getStringFromEnum(EtatVente e){
		return e.getState();
	}
	public static EtatVente getEnumFromString(String state) throws BusinessException {
		switch(state){
			case "CR":
				return EtatVente.CREE;
			case "EC":
				return EtatVente.EN_COURS;
			case "VD":
				return EtatVente.VENDU;
			case "RT":
				return EtatVente.RETIRE;
			default:
				throw new BusinessException("invalid item sell state");
		}
	}
}
