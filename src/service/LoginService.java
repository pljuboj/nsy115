package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import dao.JoueurHome;
import model.Joueur;


public class LoginService {
	private JoueurHome joueurDao;
	Logger logger = Logger.getLogger(getClass().getName());
	
	public boolean connecter(Joueur joueur){
		joueurDao = new JoueurHome();
		String id = joueur.getIdjoueur();
		String password = joueur.getMotdepasse();
		password = encoder(password);
		Joueur joueurTemp = joueurDao.findById(id);
		String idTemp = joueurTemp.getIdjoueur();
		String pwdTemp = joueurTemp.getMotdepasse();
		
		if(id.equals(idTemp) && password.equals(pwdTemp)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean enregistrer(Joueur joueur){
		
		joueurDao = new JoueurHome();
		String id = joueur.getIdjoueur();
		String password = joueur.getMotdepasse();
		String encPwd = encoder(password);
		joueur.setMotdepasse(encPwd);
		Joueur joueurTemp = joueurDao.findById(id);		
		
		if(joueurTemp != null){
			joueurDao.persist(joueur);	
			return true;
		}
		else{
			return false;
		}
	}
	
	public String encoder(String password){
		MessageDigest md;
		String encPwd="";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++){
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			encPwd = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.severe("L'algorithme MD5 n'existe pas dans cet environnement");
		}
		
		return encPwd;		
	}
}
