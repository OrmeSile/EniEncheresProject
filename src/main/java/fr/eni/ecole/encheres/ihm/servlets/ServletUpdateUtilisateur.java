package fr.eni.ecole.encheres.ihm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletUpdateUtilisateur
 */
@WebServlet("/UpdateUtilisateur")
public class ServletUpdateUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager mngr = UtilisateurManager.getUtilisateurManager();
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		int id = user.getNoUtilisateur();
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMotDePasse =request.getParameter("confirmationMotDePasse");
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		BusinessException be = new BusinessException();
		try {
			UtilisateurManager.getUtilisateurManager().seConnecter(pseudo, confirmationMotDePasse);
			Utilisateur user = new Utilisateur (//voir classe utilisateur tout prendre id y compris);
					//mettre les champs ici.
		} catch (BusinessException e) {
			request.setAttribute("errors", e.getExceptionMessages());
		}
		request.getRequestDispatcher("/WEB-INF/afficherProfil/afficherProfil.jsp").forward(request, response);

	}

}
