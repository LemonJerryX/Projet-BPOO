package Hero;
import java.util.*;

import HearthstoneException.*;
import ICapacite.*;

public class Hero implements Cloneable{
	private static ArrayList<Hero> listHeros;
	private String nom;
	private int vieMax;
	private int vieActuelle;
	private ICapacite capacite;
	
	
	/**
	 * Générer automatiquement une liste d'heros permettant le joueur de colonner directement depuis la liste
	 * @throws HearthstoneException
	 */
	public static final void setListHeros() throws HearthstoneException {
		listHeros = new ArrayList<Hero>();
		//TODO la capacité de hero reste à modifier, j'ai mis une capacité pour tester
		Hero HeroAjoute = new Hero("Jaina",15,new AttaqueDuHero(1));
		listHeros.add(HeroAjoute);
		
		HeroAjoute = new Hero("Rexxar",15,new AttaqueDuHero(1));
		listHeros.add(HeroAjoute);
	}
	
	/**
	 * Construire un hero en clonnant un héro dans la liste d'heros
	 * @param nom
	 * @throws HearthstoneException 
	 * @throws CloneNotSupportedException 
	 */
	public Hero(String nom) throws HearthstoneException, CloneNotSupportedException {
		Iterator<Hero> iterateur = listHeros.iterator();
		Hero eleHero;
		do {
			if(!iterateur.hasNext())
				throw new HearthstoneException("Le hero indiqué n'existe pas");
			eleHero = iterateur.next();
		}while(!(eleHero.getNom().equals(nom)));
		
		Hero hero = (Hero) eleHero.clone();
		
		setNom(hero.getNom());
		setVieMax(hero.getVieMax());
		setVieActuelle(hero.getVieActuelle());
		this.capacite = hero.getCapacite();	
	}
	
	/**
	 * constructeur interne pour ajouter un hero dans la liste
	 * @param nom
	 * @param vieMax
	 * @param cap
	 * @throws HearthstoneException
	 */
	private Hero(String nom,int vieMax, ICapacite cap) throws HearthstoneException {
		setNom(nom);
		setVieMax(vieMax);
		setVieActuelle(vieMax);
		this.capacite = cap;	
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
	
	protected Object clone() throws CloneNotSupportedException {
	    return (Hero)super.clone();
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
		return "NomHero: " + this.nom + " Vie: " + this.vieActuelle;
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
