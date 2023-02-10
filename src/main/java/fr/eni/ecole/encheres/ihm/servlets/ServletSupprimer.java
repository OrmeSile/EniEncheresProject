package fr.eni.ecole.encheres.ihm.servlets;

import fr.eni.ecole.encheres.BusinessException;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ServletSupprimer", value = "/profil/modifier/supprimer")
public class ServletSupprimer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.isNull(request.getSession().getAttribute("user"))){
            response.sendError(404);
        }
        try {
            UtilisateurManager.getUtilisateurManager().supprimer((Utilisateur)request.getSession().getAttribute("user"));
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath());
        } catch (BusinessException e) {
            request.setAttribute("errors", e.getExceptionMessages());
            request.getRequestDispatcher("/WEB-INF/homePage/homepage.jsp").forward(request, response);
        }
    }
}