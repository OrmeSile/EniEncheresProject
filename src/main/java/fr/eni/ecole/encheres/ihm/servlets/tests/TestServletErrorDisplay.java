package fr.eni.ecole.encheres.ihm.servlets.tests;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestServletErrorDisplay", value = "/TestServletErrorDisplay")
public class TestServletErrorDisplay extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var errors = new ArrayList<>(List.of("error 1", "error 2", "error 3"));
		for(String e : errors){
			System.out.println(e);
		}
        request.setAttribute("errors", errors);
        request.getRequestDispatcher("/WEB-INF/tests/error-dummy-container.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
