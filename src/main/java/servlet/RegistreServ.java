package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Connexion;
import service.TraitementUser;
import entity.User;

/**
 * Servlet implementation class RegistreServ
 */
@WebServlet("/RegistreServ")
public class RegistreServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistreServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String prenom =request.getParameter("prenom");
		String nom =request.getParameter("nom");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		User u = new User(prenom,nom,email,password);
		TraitementUser tu = new TraitementUser();
		tu.Ajouter(u);
		
		//  Page de redirection
		if(u == null) {
			pw.println(" Inscription imcomplete ");
			RequestDispatcher rd= request.getRequestDispatcher("Registre.jsp"); 
			rd.forward(request, response);
		}
		else {
			pw.println("Inscription reussi");
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp"); 
			rd.forward(request, response);
		}
	}

}
