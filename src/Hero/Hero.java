package Hero;
import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import HearthstoneException.VieEpuiseeException;
import ICapacite.ICapacite;

public class Hero implements Cloneable{
	private static ArrayList<Hero> listHeros;
	private String nom;
	private int vieMax;
	private int vieActuelle;
	private ICapacite capacite;
	
	public static final void setListHeros() {
		//TODO
		listHeros = new ArrayList<Hero>();
	}
	
	public Hero(String nom,int vieMax, ICapacite cap) throws HearthstoneException {
		setNom(nom);
		setVieMax(vieMax);
		setVieActuelle(vieMax);
		this.capacite = cap;	
	}
	
	public Hero(String nom,int vieMax) throws HearthstoneException {
		setNom(nom);
		setVieMax(vieMax);
		setVieActuelle(vieMax);
		this.capacite = null;	
	}
	
	public Hero(Hero hero) throws HearthstoneException{
		setNom(hero.getNom());
		setVieMax(hero.getVieMax());
		setVieActuelle(hero.getVieActuelle());
		this.capacite = hero.getCapacite();	
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

	
	public void setVieActuelle(int vieActuelle) throws HearthstoneException{
		if(vieActuelle<=0) {
			throw new VieEpuiseeException("Vie nulle ou négative");
		}
		
		this.vieActuelle = vieActuelle;
	}
	
	public int getVieActuelle() {
		return vieActuelle;
	}
	
	public ICapacite getCapacite() {
		return capacite;
	}
	
	protected Object clone() throws CloneNotSupportedException {
	    return (Hero)super.clone();
	}
	
	public void etreAttaque(int degat) {
		if(degat<0) {
			throw new IllegalArgumentException("Error: Degat negatif!");
		}
	}
	
	public boolean perdre() {
		return (vieActuelle <= 0);
	}
	
	public String toString() {
		return "NomHero " + this.nom + " Vie: " + this.vieActuelle;
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
	
	
}
