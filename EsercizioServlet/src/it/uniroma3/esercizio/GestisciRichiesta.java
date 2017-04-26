package it.uniroma3.esercizio;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inserisciDati")
public class GestisciRichiesta extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//gestione della RICHIESTA

		String nome = request.getParameter("nome").toUpperCase();
		String cognome = request.getParameter("cognome").toUpperCase();


		// leggo (alcune) intestazioni http della richiesta
		String address = (String)request.getRemoteAddr();
		String host = (String)request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");

		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/mostraDati");
		rd.forward(request, response);
		return;

	}
	//commento aggiunto alla fine 20/04/2017 14:45!!
}
