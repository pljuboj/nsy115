package sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.PartieService;
import model.Joueur;
import model.Partie;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String form = request.getParameter("pageName");
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		Joueur joueur = new Joueur(login, password, new HashSet<Partie>());
		LoginService logServ = new LoginService();
		
		if (form.equals("loginform")){
			if(logServ.connecter(joueur)){
				PartieService partSer = new PartieService();
				ArrayList<Partie> parties = partSer.partieDispo();
				session.setAttribute("parties", parties);
				session.setAttribute("username", login);
				request.getRequestDispatcher("/menu.jsp").forward(request, response);
			}else{
				request.setAttribute("loginFail", "Incorrect Username/Password");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else{
			if(logServ.enregistrer(joueur)){
				request.setAttribute("registrationSuccess", "Registration successful, please login");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("registrationFail", "Username already exists");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
				
	}

}
