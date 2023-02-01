package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.DAOUtilisateur;

import java.time.LocalDate;
import java.util.Objects;

public class UtilisateurManager {
	private DAOUtilisateur dao;
	private static UtilisateurManager manager;

	private UtilisateurManager() {
		dao = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateurManager getUtilisateurManager() {
		if (Objects.isNull(manager)) {
			manager = new UtilisateurManager();
		}
		return manager;
	}

	public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
		BusinessException be = new BusinessException();
		validerConnexionPseudo(pseudo, be);
		validerConnexionMotDePasse(motDePasse, be);

		return dao.seConnecter(pseudo, motDePasse);
	}

	public Utilisateur ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String confirmationMotDePasse)
			throws BusinessException {

		BusinessException be = new BusinessException();
		validerAjouterPseudo(pseudo, be);
		validerAjouterNom(nom, be);
		validerAjouterPrenom(prenom, be);
		validerAjouterEmail(email, be);
		validerAjouterTelephone(telephone, be);
		validerAjouterRue(rue, be);
		validerAjouterCodePostal(codePostal, be);
		validerAjouterVille(ville, be);
		validerAjouterMotDePasse(motDePasse, confirmationMotDePasse, be);
		// TODO : tester la validité de la description et de la note
		// Utilisateur utilisateur = new Utilisateur();
		// return utilisateur;
		return null;
	}

	private void validerConnexionPseudo(String pseudo, BusinessException businessException) {

		if (pseudo==null || pseudo.isBlank()) {
			businessException.addExceptionMessage("Le pseudo doit être renseigné et faire plus de 6 caractères");
		}

	}

	private void validerConnexionMotDePasse(String motDePasse, BusinessException businessException) {

		if (motDePasse.length() < 6 || motDePasse==null || motDePasse.isBlank()) {
			businessException.addExceptionMessage("Le mot de passe doit être renseigné et contenir plus de 6 caractères");
		}

	}

	private void validerAjouterPseudo(String pseudo, BusinessException businessException) {

		if (pseudo == null || pseudo.isBlank()) {
			businessException.addExceptionMessage("Le pseudo doit être renseigné et contenir plus de 4 caractères");
		}

	}

	private void validerAjouterNom(String nom, BusinessException businessException) {
		
		if (nom==null || nom.isBlank()) {
			
		}
		

	}

	private void validerAjouterPrenom(String prenom, BusinessException businessException) {
		
		if (prenom==null || prenom.isBlank()) {
			
		}

	}

	private void validerAjouterEmail(String email, BusinessException businessException) {
		
		if (email==null || email.isBlank() || !email.contains("@")) {
			
		}

	}

	private void validerAjouterTelephone(String telephone, BusinessException businessException) {

	}

	private void validerAjouterRue(String rue, BusinessException businessException) {

	}

	private void validerAjouterCodePostal(String codePostal, BusinessException businessException) {

	}

	private void validerAjouterVille(String ville, BusinessException businessException) {

	}

	private void validerAjouterMotDePasse(String motDePasse, String confirmationMotDePasse, BusinessException businessException) {

	}

}
