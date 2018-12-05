package org.lip6.struts.domain;

public class Groupe {
	private String id;
	private String nom;
	
	public Groupe(String id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void setId(String id){
		this.id = id;
	}
}
