package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.DAOUtilisateur;
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
	public void supprimer(Utilisateur user) throws BusinessException {
		dao.delete(user.getNoUtilisateur());
	}
	public Utilisateur seConnecter(String pseudo, String motDePasse) throws BusinessException {
		BusinessException be = new BusinessException();
		validerConnexionPseudo(pseudo, be);
		validerConnexionMotDePasse(motDePasse, be);

		return dao.seConnecter(pseudo, motDePasse);
	}

	public Utilisateur ajouter(Utilisateur user) throws BusinessException {
		BusinessException be = new BusinessException();
		validerAjouterPseudo(user.getPseudo(), be);
		validerAjouterNom(user.getNom(), be);
		validerAjouterPrenom(user.getPrenom(), be);
		validerAjouterEmail(user.getEmail(), be);
		validerAjouterTelephone(user.getTelephone(), be);
		validerAjouterRue(user.getRue(), be);
		validerAjouterCodePostal(user.getCodePostal(), be);
		validerAjouterVille(user.getVille(), be);
		if (be.getExceptionMessages().size() > 0) {
			throw be;
		} else {
			return dao.insert(user);
		}
	}
	public Utilisateur getOneUtilisateurById(int id) throws BusinessException{
		return dao.getOneById(id);
	}
	public void updateUser(Utilisateur user) throws BusinessException{
		dao.update(user);
	}
	private void validerConnexionPseudo(String pseudo, BusinessException businessException) {
		if (pseudo == null || pseudo.isBlank()) {
			businessException.addExceptionMessage("Le pseudo doit être renseigné et faire plus de 6 caractères");
		}
	}

	private void validerConnexionMotDePasse(String motDePasse, BusinessException businessException) {
		if (Objects.isNull(motDePasse) ||motDePasse.length() < 6 || motDePasse.isBlank()) {
			businessException.addExceptionMessage("Le mot de passe doit être renseigné et contenir plus de 6 caractères");
		}
	}

	private void validerAjouterPseudo(String pseudo, BusinessException businessException) {
		if (pseudo == null || pseudo.isBlank()) {
			businessException.addExceptionMessage("Le pseudo doit être renseigné et contenir plus de 4 caractères");
		}
	}

	private void validerAjouterNom(String nom, BusinessException businessException) {
		if (nom == null || nom.isBlank()) {
			businessException.addExceptionMessage("Le nom doit être renseigné");
		}
	}

	private void validerAjouterPrenom(String prenom, BusinessException businessException) {
		if (prenom == null || prenom.isBlank()) {
			businessException.addExceptionMessage("Le prenom doit être renseigné");
		}
	}

	private void validerAjouterEmail(String email, BusinessException businessException) {
		if (email == null || email.isBlank() || !email.contains("@")) {
			businessException.addExceptionMessage("L'email doit être renseigné et doit être au format @");
		}
	}

	private void validerAjouterTelephone(String telephone, BusinessException businessException) {
		if (telephone == null || telephone.isBlank()) {
			businessException.addExceptionMessage("Le numéro de téléphone doit être renseigné");
		}
	}

	private void validerAjouterRue(String rue, BusinessException businessException) {
		if (rue == null || rue.isBlank()) {
			businessException.addExceptionMessage("La rue doit être renseigné");
		}
	}

	private void validerAjouterCodePostal(String codePostal, BusinessException businessException) {
		if (codePostal == null || codePostal.isBlank()) {
			businessException.addExceptionMessage("Le code postal doit être renseigné");
		}
	}

	private void validerAjouterVille(String ville, BusinessException businessException) {
		if (ville == null || ville.isBlank()) {
			businessException.addExceptionMessage("La ville doit être renseigné");
		}
	}
}
