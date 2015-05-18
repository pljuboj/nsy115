package service;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import model.Joueur;
import model.Partie;
import dao.JoueurHome;
import dao.PartieHome;

public class PartieService {
	private PartieHome partieDao;
	private JoueurHome joueurDao;
	
	public Integer creerPartie(HttpSession session){
		String username = "";
		if(session!=null){
			username = ((String) session.getAttribute("username")).toUpperCase();			
		}
		Set<Joueur> joueurs = new HashSet<Joueur>();
		joueurDao = new JoueurHome();
		Joueur joueur = joueurDao.findById(username);
		Partie partie = new Partie();
		joueurs.add(joueur);
		partie.setJoueurs(joueurs);
		partieDao = new PartieHome();
		return partieDao.save(partie);
	}
	
	public void rejoindrePartie(HttpSession session, int idPartie){
		String username = "";
		if(session!=null){
			username = ((String) session.getAttribute("username")).toUpperCase();			
		}
		Set<Partie> parties = new HashSet<Partie>();
		joueurDao = new JoueurHome();
		Joueur joueur = joueurDao.findById(username);
		partieDao = new PartieHome();
		Partie partie = partieDao.findById(idPartie);
		parties.add(partie);
		joueur.setParties(parties);
		joueurDao.save(joueur);
	}
	
	public boolean partiePleine(int idpartie) {
		partieDao = new PartieHome();
		Partie partie = partieDao.get(idpartie);
		if(partie.getJoueurs().size()==2){
			return true;
		}else {
			return false;
		}
	}
}
