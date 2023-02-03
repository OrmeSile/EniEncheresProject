package fr.eni.ecole.encheres.ihm.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
@WebServlet(name = "ServletHome", value = "/home")
public class ServletHome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			var articles = ArticleManager.getManager().getAll();
		}catch (BusinessException e){
			request.setAttribute("errors", e.getExceptionMessages());
		}
		request.getRequestDispatcher("/WEB-INF/homePage/homepage.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
