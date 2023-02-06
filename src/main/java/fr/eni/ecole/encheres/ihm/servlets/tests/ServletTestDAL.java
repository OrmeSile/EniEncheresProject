package fr.eni.ecole.encheres.ihm.servlets.tests;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bll.UtilisateurManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTestDAL", value = "/tests/ServletTestDAL")
public class ServletTestDAL extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var rd = request.getRequestDispatcher("/WEB-INF/tests/testDAL.jsp");
		try {
			var user = UtilisateurManager.getUtilisateurManager().getOneUtilisateurById(3);
			var articles = ArticleManager.getManager().getAllArticlesByUtilisateur(user);
			request.setAttribute("user", user);
			request.setAttribute("articles", articles);
		} catch (BusinessException e) {
			request.setAttribute("errors", e.getExceptionMessages());
		}
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
