package service;

import javax.servlet.http.HttpSession;

import dao.JoueurHome;
import dao.PartieHome;

public class PartieService {
	private JoueurHome joueurDao;
	private PartieHome partieDao;
	
	public boolean creerPartie(HttpSession session){
		String username = "";
		if(session!=null){
			username = (String) session.getAttribute("username");			
		}
	}
}
