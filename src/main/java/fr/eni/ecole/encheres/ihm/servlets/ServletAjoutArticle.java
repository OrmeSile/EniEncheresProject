package fr.eni.ecole.encheres.ihm.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bll.CategorieManager;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.utils.EtatVente;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.bo.Utilisateur;

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
		if(Objects.isNull(request.getSession().getAttribute("user"))){
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("date", LocalDateTime.now());
			try {
				var requestId = request.getParameter("id");
				if (!Objects.isNull(requestId) && !requestId.isBlank()) {
					var id = Integer.parseInt(requestId);
					ArticleVendu art = ArticleManager.getManager().getOneArticleById(id);
					request.setAttribute("article", ArticleManager.getManager().getOneArticleById(id));
				}
				ArrayList<Categorie> categories = CategorieManager.getManager().getCategories();
				request.setAttribute("categories", categories);
				request.getRequestDispatcher("/WEB-INF/ajoutArticle/ajoutArticle.jsp").forward(request, response);
			} catch (BusinessException e) {
				request.setAttribute("errors", e.getExceptionMessages());
				request.getRequestDispatcher("/WEB-INF/ajoutArticle/ajoutArticle.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				response.sendError(404);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Objects.isNull(request.getSession().getAttribute("user"))){
			doGet(request, response);
		}else {
			var user = request.getSession().getAttribute("user");
			ArticleManager mngr = ArticleManager.getManager();
			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			String miseAPrix = request.getParameter("miseAPrix");
			String dateDebutEncheres = request.getParameter("dateDebutEncheres");
			String dateFinEncheres = request.getParameter("dateFinEncheres");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String categories = request.getParameter("selectedCategory");


			try {
				int miseAPrixInt = Integer.parseInt(miseAPrix);
				LocalDateTime datedeb = LocalDateTime.parse(dateDebutEncheres);
				LocalDateTime datefin = LocalDateTime.parse(dateFinEncheres);
				ArrayList<Categorie> cats = CategorieManager.getManager().getCategories();
				Categorie cat = cats.stream().filter(x -> x.getLibelle().equals(categories)).collect(Collectors.toList()).get(0);
				var sessionUser = (Utilisateur) request.getSession().getAttribute("user");
				System.out.println(sessionUser);
				if (Stream.of(rue, codePostal, ville).anyMatch(Objects::isNull) || Stream.of(rue, codePostal, ville).anyMatch(String::isBlank)) {
					rue = sessionUser.getRue();
					codePostal = sessionUser.getCodePostal();
					ville = sessionUser.getVille();
				}
				ArticleVendu a = new ArticleVendu(nomArticle, description, datedeb, datefin, miseAPrixInt, miseAPrixInt, EtatVente.CREE, (Utilisateur) user, new Retrait(rue, codePostal, ville), cat, "");
				ArticleManager.getManager().addArticle(a);
				doGet(request, response);
			} catch (BusinessException e) {
				request.setAttribute("errors", e.getExceptionMessages());
				doGet(request, response);
			}
		}
	}
}
