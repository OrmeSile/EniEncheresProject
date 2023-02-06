package fr.eni.ecole.encheres.ihm.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bll.CategorieManager;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.Categorie;

/**
 * Servlet implementation class ServletAjoutArticle
 */
@WebServlet("/AjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager mngr = ArticleManager.getManager();
		String nomArticle = request.getParameter("nomArticle");
		System.out.println(nomArticle);
		String description = request.getParameter("description");
		System.out.println(description);
		String miseAPrix = request.getParameter("miseAPrix");
		System.out.println(miseAPrix);
		String dateDebutEncheres = request.getParameter("dateDebutEncheres");
		System.out.println(dateDebutEncheres);
		String dateFinEncheres = request.getParameter("dateFinEncheres");
		System.out.println(dateFinEncheres);
		String rue = request.getParameter("rue");
		System.out.println("rue"+ rue);
		String codePostal = request.getParameter("codePostal");
		System.out.println("codePostal" + codePostal);
		String ville = request.getParameter("ville");
		System.out.println("ville" + ville);
		
		
		try {
			ArrayList<Categorie> categories = CategorieManager.getManager().getCategories();
			request.setAttribute("categories", categories);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/ajoutArticle/ajoutArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
