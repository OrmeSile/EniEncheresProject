package fr.eni.ecole.encheres.ihm.servlets;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bll.EnchereManager;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "ServletDetailVente", value = "/afficherEnchere")
public class ServletDetailVente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            var articleId = Integer.parseInt(request.getParameter("id"));
            var article = ArticleManager.getManager().getOneArticleById(articleId);
            request.setAttribute("article", article);
            request.setAttribute("date", LocalDateTime.now());
            request.getRequestDispatcher("/WEB-INF/afficherEnchere/enchere.jsp").forward(request, response);
        }catch (NumberFormatException e){
            response.sendError(404);
        }catch (BusinessException e){
            request.setAttribute("errors", e.getExceptionMessages());
            request.getRequestDispatcher("/WEB_INF/afficherEnchere/enchere.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var bidAmount = Integer.parseInt(request.getParameter("proposition"));
        var articleId = Integer.parseInt(request.getParameter("itemId"));
        var user = (Utilisateur)request.getSession().getAttribute("user");
        try {
            var article = EnchereManager.getManager().addEnchereOnArticle(user, bidAmount, articleId);
        }catch (BusinessException e){
            request.setAttribute("errors", e.getExceptionMessages());
        }
    }
}
