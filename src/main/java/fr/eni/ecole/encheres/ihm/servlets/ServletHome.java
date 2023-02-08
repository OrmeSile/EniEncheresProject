package fr.eni.ecole.encheres.ihm.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bll.CategorieManager;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
@WebServlet(name = "ServletHome", value = "/home")
public class ServletHome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(Objects.isNull(request.getAttribute("categories"))) {
				var categories = CategorieManager.getManager().getCategories();
				request.setAttribute("categories", categories);
			}
			if(!Objects.isNull(request.getSession().getAttribute("user"))) {
				var articles = ArticleManager.getManager().getLoggedOutObjects();
				request.setAttribute("articles", articles);
			}else{

			}
		} catch (BusinessException e) {
			System.out.println(e.getExceptionMessages());
			request.setAttribute("errors", e.getExceptionMessages());
		}
		request.getRequestDispatcher("/WEB-INF/homePage/homepage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var categorie = request.getParameter("selectedCategory");
		var searchName = request.getParameter("searchfield");
		var radioValue = request.getParameter("filter");
		var buyOpen = request.getParameter("bopen");
		var buySelf = request.getParameter("bself");
		var buyWon = request.getParameter("bwon");
		var sellOpen = request.getParameter("sopen");
		var sellSelf = request.getParameter("sself");
		var sellWon = request.getParameter("swon");

  }
}

