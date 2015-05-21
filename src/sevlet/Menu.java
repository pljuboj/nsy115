package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Partie;
import service.PartieService;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = ((String) session.getAttribute("username")).toUpperCase();
		int idPartie = Integer.parseInt(request.getParameter("idpartie"));
		PartieService partSer = new PartieService();
		
		if (partSer.partiePleine(idPartie)) {
			request.setAttribute("message", "La partie est pleine");
			ArrayList<Partie> parties = partSer.partieDispo();
			session.setAttribute("parties", parties);
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} else {
			request.setAttribute("idpartie", idPartie);
			request.setAttribute("username", username);
			request.setAttribute("yourturn", "no");
			partSer.rejoindrePartie(session, idPartie);
			request.getRequestDispatcher("/grille.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeOp = request.getParameter("CODE_OP");
		PartieService partSer = new PartieService();
		HttpSession session;
		if(codeOp.equals("DECO")){
			session = request.getSession(false);
			if(session!=null){
				session.invalidate();				
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (codeOp.equals("CREER")) {
			session = request.getSession(true);
			String username = ((String) session.getAttribute("username")).toUpperCase();
			int idPartie = partSer.creerPartie(session);
			request.setAttribute("idpartie", idPartie);
			request.setAttribute("username", username);
			request.setAttribute("yourturn", "yes");
			request.getRequestDispatcher("/grille.jsp").forward(request, response);			
		}
		else if (codeOp.equals("REJOINDRE")) {
			session = request.getSession(true);
			String username = ((String) session.getAttribute("username")).toUpperCase();
			int idPartie = Integer.parseInt(request.getParameter("ID_PARTIE"));
			
			if (partSer.partiePleine(idPartie)) {
				request.setAttribute("message", "La partie est pleine");
				ArrayList<Partie> parties = partSer.partieDispo();
				session.setAttribute("parties", parties);
				request.getRequestDispatcher("/menu.jsp").forward(request, response);
			} else {
				request.setAttribute("idpartie", idPartie);
				request.setAttribute("username", username);
				request.setAttribute("yourturn", "no");
				partSer.rejoindrePartie(session, idPartie);
				request.getRequestDispatcher("/grille.jsp").forward(request, response);
			}
		}
	}

}
