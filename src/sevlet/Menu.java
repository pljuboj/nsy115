package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			request.setAttribute("idpartie", idPartie);
			request.setAttribute("username", username);
			request.setAttribute("yourturn", "no");
			partSer.rejoindrePartie(session, idPartie);
			request.getRequestDispatcher("/grille.jsp").forward(request, response);
		}
	}

}
