package Hero;
import java.util.*;

import HearthstoneException.*;
import ICapacite.*;
import ICarte.ICarte;
import IJoueur.IJoueur;

public class Hero{
	private String nom;
	private int vieMax;
	private int vieActuelle;
	private ICapacite capacite;
	protected ArrayList<ICarte> deckHero;
	private IJoueur joueur;
	private boolean dejaUP;
	
	/**
	 * @param nom
	 * @param vieMax
	 * @param cap
	 * @throws HearthstoneException
	 */
	public Hero(String nom,int vieMax, ICapacite cap) throws HearthstoneException {
		setNom(nom);
		setVieMax(vieMax);
		setVieActuelle(vieMax);
		this.capacite = cap;	
		setDeckHero();
		setDejaUP(false);
		joueur = null;
	}
	



	//Setters et getters
	private void setNom(String nom) {
		if(nom == null)
			throw new IllegalArgumentException("Le nom ne doit pas être null!");
		if(nom.equals(""))
			throw new IllegalArgumentException("Le nom ne doit pas être vide!");
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	private void setVieMax(int vieMax) {
		if(vieMax<=0)
			throw new IllegalArgumentException("La vie ne peut pas être vide ou négative!");
		this.vieMax = vieMax;
	}
	
	public int getVieMax() {
		return vieMax;
	}

	
	public void setVieActuelle(int vieActuelle){
		this.vieActuelle = vieActuelle;
	}
	
	public int getVieActuelle() {
		return vieActuelle;
	}
	
	public ICapacite getCapacite() {
		return capacite;
	}
	
	public void etreAttaque(int degat) {
		if(degat<0) {
			throw new IllegalArgumentException("Error: Degat negatif!");
		}
		setVieActuelle(this.vieActuelle - degat);
	}
	
	public boolean perdre() {
		return (vieActuelle <= 0);
	}
	
	public String toString() {
		return "NomHero: " + this.nom + " Vie: " + this.vieActuelle + this.capacite;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(!(obj instanceof Hero))
			return false;
		Hero hero = (Hero) obj;
		//Pour l'instant, je considère que deux héros de même nom sont identiques, reste à vérifier
		return hero.getNom().equals(this.nom);
	}


	public ArrayList<ICarte> getDeckHero() {
		return (new ArrayList<ICarte>(deckHero));
	}


	public void setDeckHero() {
		
	}

	public IJoueur getJoueur() {
		return joueur;
	}

	public void setJoueur(IJoueur joueur) {
		this.joueur = joueur;
	}
	
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		capacite.executerAction(cible);
	}

	public boolean isDejaUP() {
		return dejaUP;
	}

	public void setDejaUP(boolean dejaUP) {
		this.dejaUP = dejaUP;
	}
	
	
}
