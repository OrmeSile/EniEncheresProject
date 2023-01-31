package fr.eni.ecole.encheres.bo;

import java.time.LocalDateTime;

public class Enchere {
	LocalDateTime dateEnchere;
	double montantEnchere;

	public Enchere(LocalDateTime dateEnchere, double montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	
}