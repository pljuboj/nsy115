package model;
// default package
// Generated 29 mars 2015 16:42:24 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Joueur generated by hbm2java
 */
public class Joueur implements java.io.Serializable {

	private String idjoueur;
	private String motdepasse;
	private Set jouers = new HashSet(0);

	public Joueur() {
	}

	public Joueur(String idjoueur) {
		this.idjoueur = idjoueur;
	}

	public Joueur(String idjoueur, String motdepasse, Set jouers) {
		this.idjoueur = idjoueur;
		this.motdepasse = motdepasse;
		this.jouers = jouers;
	}

	public String getIdjoueur() {
		return this.idjoueur;
	}

	public void setIdjoueur(String idjoueur) {
		this.idjoueur = idjoueur;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Set getJouers() {
		return this.jouers;
	}

	public void setJouers(Set jouers) {
		this.jouers = jouers;
	}

}