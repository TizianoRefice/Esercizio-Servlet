package it.uniroma3.esercizio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inserisciDati")
public class EsercizioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//gestione della RICHIESTA
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dataNascita = request.getParameter("dataNascita");
		
		//lettura altre informazioni
		
		String address = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String user = request.getRemoteUser();
		int port = request.getRemotePort();
		
		//gestione della RISPOSTA
		//preparazione tipo (HTML)
		response.setContentType("text/html");
		//oggetto su cui scrivere la risposta
		PrintWriter out = response.getWriter();
		
		//scrivo il corpo
		out.println("<!DOCTYPE html>"); out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\" />");
		out.println("<title>mostra parametri</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Dati inseriti nella form</h1>");
		out.println("<ul>");
		out.println("<li>Nome: <b>"+nome+"</b></li>");
		out.println("<li>Cognome: <b>"+cognome+"</b></li>");
		out.println("<li>Data Di Nascita: <b>"+dataNascita+"</b></li>");
		out.println("</ul>");
		out.println("<h1>Altri dati relativi alla richiesta</h1>");
		out.println("<br />IP: <b>"+address+"</b>");
		out.println("<br />Host: <b>"+host+"</b>");
		out.println("<br />User Agent: <b>"+user+"</b>");
		out.println("<br />Port: <b>"+port+"</b>");
		out.println("</body>\n</html> "); 
	}
	
	//commento aggiunto alla fine 20/04/2017 14:45
}
