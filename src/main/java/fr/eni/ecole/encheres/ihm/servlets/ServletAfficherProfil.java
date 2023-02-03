package fr.eni.ecole.encheres.ihm.servlets;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.Utilisateur;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAfficherProfil
 */
@WebServlet("/profil")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		if(Objects.isNull(id)||id.isBlank()){
			request.setAttribute("user", request.getSession().getAttribute("user"));
			request.getRequestDispatcher("/WEB-INF/afficherProfil/afficherProfil.jsp").forward(request, response);
		}else {
			try {
				Utilisateur user = UtilisateurManager.getUtilisateurManager().getOneUtilisateurById(Integer.parseInt(id));
				request.setAttribute("user", user);
			} catch (BusinessException e) {
				request.setAttribute("errors", e.getExceptionMessages());
			}
			request.getRequestDispatcher("/WEB-INF/afficherProfilPage/afficherProfil.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
