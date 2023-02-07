package fr.eni.ecole.encheres.ihm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
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
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.EtatVente;
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
		var user = request.getSession().getAttribute("user");
		System.out.println("user + user");
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
		String categories = request.getParameter("selectedCategory");
		System.out.println("selectedCategory" + categories);
		
		
			try {
				int miseAPrixInt = Integer.parseInt("miseAPrix");
				LocalDate datedeb = LocalDate.parse(dateDebutEncheres);
				LocalDateTime dateDebutFormatted = LocalDateTime.of(datedeb, LocalTime.now()); 
				LocalDate datefin = LocalDate.parse(dateFinEncheres);
				LocalDateTime dateFinFormatted = LocalDateTime.of(datefin, LocalTime.now());
				ArrayList<Categorie> cats = CategorieManager.getManager().getCategories();
				Categorie cat = cats.stream().filter(x -> x.getLibelle().equals(categories)).collect(Collectors.toList()).get(0);	
				var userAdd = (Utilisateur)request.getSession().getAttribute("user");
				if (Stream.of(rue, codePostal, ville).anyMatch(Objects::isNull) || Stream.of(rue, codePostal, ville).anyMatch(String::isBlank)) {
					rue = userAdd.getRue();
					codePostal = userAdd.getCodePostal();
					ville = userAdd.getVille();
				}
				ArticleVendu a = new ArticleVendu(nomArticle, description, dateDebutFormatted, dateFinFormatted, miseAPrixInt, miseAPrixInt, EtatVente.CREE,(Utilisateur)user,new Retrait(rue, codePostal, ville), cat, "");
				ArticleManager.getManager().addArticle(a);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}

}
