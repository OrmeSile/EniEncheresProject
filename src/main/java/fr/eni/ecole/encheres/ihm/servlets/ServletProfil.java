package fr.eni.ecole.encheres.ihm.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
@WebServlet(name="ServletProfil", value="/profil/modifier")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil/profil.jsp");

		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager mngr = UtilisateurManager.getUtilisateurManager();
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
		BusinessException be = new BusinessException();
		if(!confirmationMotDePasse.equals(motDePasse)) {
			be.addExceptionMessage("Les mots de passe ne sont pas identiques");
			request.setAttribute("errors", be.getExceptionMessages());
			doGet(request, response);
		} else {
			try {
				UtilisateurManager.getUtilisateurManager().ajouter(new Utilisateur (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse));
        	response.sendRedirect(request.getContextPath());
			} catch (BusinessException e) {
				request.setAttribute("errors", e.getExceptionMessages());
        		doGet(request, response);
			}
		}
	}
}
