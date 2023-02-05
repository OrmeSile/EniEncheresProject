package fr.eni.ecole.encheres.ihm.servlets.tests;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.ArticleManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTestCssCard", value = "/testcss")
public class ServletTestCssCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            var articles = ArticleManager.getManager().getAll();
            request.setAttribute("articles", articles);
            System.out.println(articles.size());
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/tests/testcsscard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
