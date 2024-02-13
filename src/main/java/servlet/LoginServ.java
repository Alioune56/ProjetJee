package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.TraitementUser;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		TraitementUser tu = new TraitementUser();
		User u = tu.TestLogin(email, password);
		if(u == null) {
			pw.println("Email ou Password incorrect ");
			RequestDispatcher rd= request.getRequestDispatcher("LoginForm.jsp"); 
			rd.forward(request, response);
		}
		else {
			pw.println("Connexion Reussi");
			RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp"); 
			rd.forward(request, response);
		}
	}

}
