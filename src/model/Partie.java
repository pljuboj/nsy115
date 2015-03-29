package model;
// default package
// Generated 29 mars 2015 16:42:24 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Partie generated by hbm2java
 */
public class Partie implements java.io.Serializable {

	private Integer idpartie;
	private String x1;
	private String x2;
	private String x3;
	private String y1;
	private String y2;
	private String y3;
	private String z1;
	private String z2;
	private String z3;
	private Set jouers = new HashSet(0);

	public Partie() {
	}

	public Partie(String x1, String x2, String x3, String y1, String y2,
			String y3, String z1, String z2, String z3, Set jouers) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.z1 = z1;
		this.z2 = z2;
		this.z3 = z3;
		this.jouers = jouers;
	}

	public Integer getIdpartie() {
		return this.idpartie;
	}

	public void setIdpartie(Integer idpartie) {
		this.idpartie = idpartie;
	}

	public String getX1() {
		return this.x1;
	}

	public void setX1(String x1) {
		this.x1 = x1;
	}

	public String getX2() {
		return this.x2;
	}

	public void setX2(String x2) {
		this.x2 = x2;
	}

	public String getX3() {
		return this.x3;
	}

	public void setX3(String x3) {
		this.x3 = x3;
	}

	public String getY1() {
		return this.y1;
	}

	public void setY1(String y1) {
		this.y1 = y1;
	}

	public String getY2() {
		return this.y2;
	}

	public void setY2(String y2) {
		this.y2 = y2;
	}

	public String getY3() {
		return this.y3;
	}

	public void setY3(String y3) {
		this.y3 = y3;
	}

	public String getZ1() {
		return this.z1;
	}

	public void setZ1(String z1) {
		this.z1 = z1;
	}

	public String getZ2() {
		return this.z2;
	}

	public void setZ2(String z2) {
		this.z2 = z2;
	}

	public String getZ3() {
		return this.z3;
	}

	public void setZ3(String z3) {
		this.z3 = z3;
	}

	public Set getJouers() {
		return this.jouers;
	}

	public void setJouers(Set jouers) {
		this.jouers = jouers;
	}

}
