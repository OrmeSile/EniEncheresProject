package fr.eni.ecole.encheres.ihm.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.Utilisateur;


/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/loginPage/login.jsp");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UtilisateurManager mngr = UtilisateurManager.getUtilisateurManager();
		String identifiant = request.getParameter("identifiant");
		System.out.println("identifiant  " + identifiant);
		String motDePasse = request.getParameter("mdp");
		System.out.println("mot de passe " + motDePasse);
		
		try {
			Utilisateur utilisateur = UtilisateurManager.getUtilisateurManager().seConnecter(identifiant, motDePasse);
		} catch (BusinessException e) {
			e.getExceptionMessages();
			request.setAttribute("listeCodesErreur",e.getExceptionMessages());
		}

		doGet(request, response);
		

	}

}
