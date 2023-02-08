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
import fr.eni.ecole.encheres.bo.utils.FilterPayload;
import fr.eni.ecole.encheres.bo.utils.FilterTags;

@WebServlet(name = "ServletHome", value = "/home")
public class ServletHome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var user = (Utilisateur)request.getSession().getAttribute("user");
		var payload =(FilterPayload) request.getSession().getAttribute("filterPayload");
		var isUser = !Objects.isNull(user);
		var isPayload = !Objects.isNull(payload);
		System.out.println("isUser, isPayload -> "+isUser+"  -  "+isPayload);
		try {
			if (Objects.isNull(request.getAttribute("categories"))) {
				var categories = CategorieManager.getManager().getCategories();
				request.setAttribute("categories", categories);
			}
			if (!isPayload) {
				System.out.println("entered !isPayload");
				if (!isUser) {
					System.out.println("!isUser in !isPayload");
					var articles = ArticleManager.getManager().getLoggedOutObjects();
					request.setAttribute("articles", articles);
				} else {
					System.out.println("else in !isPayload>!isUser");
					request.setAttribute("articles",ArticleManager.getManager().getFilteredResults(user));
				}
			}else{
				System.out.println("else in !isPayload");
				var articles = ArticleManager.getManager().getFilteredResults(payload);
				request.setAttribute("articles", articles);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getExceptionMessages());
		}
		request.getRequestDispatcher("/WEB-INF/homePage/homepage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			var categorieParam = Integer.parseInt(request.getParameter("selectedCategory"));
			var queryParam = request.getParameter("search-field");
			var categorie = categorieParam != 0 ? CategorieManager.getManager().getOneById(categorieParam) : null;
			if (Objects.isNull(request.getSession().getAttribute("user"))) {
				var payload = FilterPayload.getVisitorPayload(queryParam, categorie);
				request.getSession().setAttribute("filterPayload", payload);
				request.getSession().setAttribute("tags", payload.getTags());
				doGet(request, response);
			}else {
				var radioValueParam = request.getParameter("radio-filter");
				var buyOpenParam = request.getParameter("bopen");
				var buySelfParam = request.getParameter("bself");
				var buyWonParam = request.getParameter("bwon");
				var sellOpenParam = request.getParameter("sopen");
				var sellSelfParam = request.getParameter("sself");
				var sellWonParam = request.getParameter("swon");
				var isQuery = (!Objects.isNull(queryParam) && queryParam.isBlank());
				var isCategory = !Objects.isNull(categorie);
				var isSell = radioValueParam.equals("sell");
				var isOpen = (!Objects.isNull(buyOpenParam) && Objects.isNull(sellOpenParam)) || (Objects.isNull(buyOpenParam) && !Objects.isNull(sellOpenParam));
				var isBuySelf = !Objects.isNull(buySelfParam);
				var isBuyWon = !Objects.isNull(buyWonParam);
				var isSellSelf = !Objects.isNull(sellSelfParam);
				var isSellWon = !Objects.isNull(sellWonParam);
				var tags = new FilterTags(isQuery, isCategory, isSell, isOpen, isBuySelf, isBuyWon, isSellSelf, isSellWon);
				var user = (Utilisateur) request.getSession().getAttribute("user");
				var payload = new FilterPayload(tags, queryParam, categorie, user);
				request.getSession().setAttribute("filterPayload", payload);
				request.getSession().setAttribute("tags", payload.getTags());
				doGet(request, response);
			}
		} catch (BusinessException e) {
			throw new RuntimeException(e);
		}
	}
}
