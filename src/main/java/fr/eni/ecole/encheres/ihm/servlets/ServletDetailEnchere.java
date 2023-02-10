package fr.eni.ecole.encheres.ihm.servlets;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;
import fr.eni.ecole.encheres.bll.EnchereManager;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.bo.utils.EtatVente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@WebServlet(name = "ServletDetailEnchere", value = "/afficherEnchere")
public class ServletDetailEnchere extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.isNull(request.getSession().getAttribute("user"))){
            response.sendError(404);
        }else {
            try {
                var parId = request.getParameter("id");
                var attId = request.getAttribute("id");
                var id = !Objects.isNull(parId) ? Integer.parseInt(parId) : !Objects.isNull(attId) ? (int) attId : -1;
                if (id > 0) {
                    var article = ArticleManager.getManager().getOneArticleById(id);
                    System.out.println(article.getEtatVente());
                    if (article.getEtatVente().equals(EtatVente.CREE)) {
                        response.sendRedirect(request.getContextPath() + "/AjoutArticle?id=" + article.getNoArticle());
                    } else {
                        request.setAttribute("article", article);
                        request.setAttribute("date", LocalDateTime.now());
                        request.getRequestDispatcher("/WEB-INF/afficherEnchere/enchere.jsp").forward(request, response);
                    }
                } else {
                    response.sendError(404);
                }
            } catch (BusinessException e) {
                request.setAttribute("errors", e.getExceptionMessages());
                request.getRequestDispatcher("/WEB_INF/afficherEnchere/enchere.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var bidAmount = Integer.parseInt(request.getParameter("proposition"));
        var articleId = Integer.parseInt(request.getParameter("itemId"));
        var user = (Utilisateur)request.getSession().getAttribute("user");

        try {
            var previous = EnchereManager.getManager().getEnchere(articleId);
            EnchereManager.getManager().addEnchere(user, bidAmount, articleId, previous);
            request.setAttribute("article", ArticleManager.getManager().getOneArticleById(articleId));
        }catch (BusinessException e){
            request.setAttribute("errors", e.getExceptionMessages());
        }
        request.setAttribute("id", articleId);
        doGet(request, response);
    }
}
