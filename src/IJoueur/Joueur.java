package IJoueur;
import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import HearthstoneException.ManaEpuiseException;
import Hero.Hero;
import ICarte.ICarte;

public class Joueur implements IJoueur{
	
	private String pseudo;
	private Hero hero;
	private int mana;
	private int stockMana;
	private ArrayList<ICarte> jeu;
	private ArrayList<ICarte> main;
	private ArrayList<ICarte> deck;
	private boolean finiTour;
	
	public Joueur(String pseudo, Hero hero) throws HearthstoneException {
		setPseudo(pseudo);
		setHero(hero);
		setMana(1);
		setStockMana(1);
		jeu = new ArrayList<ICarte>();
		main = new ArrayList<ICarte>();
		initialiseDeck(hero);
		finiTour = false;
	}
	
	@Override
	public String getPseudo() {
		return this.pseudo;
	}
	
	private void setPseudo(String pseudo) {
		if(pseudo == null)
			throw new IllegalArgumentException("Le pseudo ne doit pas être null!");
		if(pseudo.equals(""))
			throw new IllegalArgumentException("Le pseudo ne doit pas être vide!");
		this.pseudo = pseudo;
	}
	
	@Override
	public Hero getHero() {
		return this.hero;
	}
	
	public void setHero(Hero hero) {
		if(hero == null)
			throw new IllegalArgumentException("Le hero ne doit pas être null!");
		this.hero = hero;
	}

	@Override
	public int getMana() {
		return this.mana;
	}
	
	public void setMana(int mana) {
		if(mana<0)
			throw new IllegalArgumentException("Le mana ne doit pas être nagatif");
		this.mana = mana;
	}
	
	@Override
	public int getStockMana() {
		return this.stockMana;
	}
	
	public void setStockMana(int stockMana) throws HearthstoneException{
		if(stockMana < 0)
			throw new ManaEpuiseException("Error: mana négatif");
			
	}
	
	@Override
	public ArrayList<ICarte> getJeu() {
		return this.jeu;
	}
	
	@Override
	public ArrayList<ICarte> getMain() {
		return this.main;
	}
	
	@Override
	public ICarte getCarteEnJeu(String nomCarte) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ICarte getCarteEnMain(String nomCarteMain) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void initialiseDeck(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	public void piocher() throws HearthstoneException {
		//TODO
	
	}
	

	public void jouerCarte(ICarte carte) throws HearthstoneException {
		//TODO
		
		// On ajoute la carte au jeu (terrain)
		this.jeu.add(carte);
		// On supprime la carte de la main
		this.main.add(null);
		// On détruit la carte
		
	}
	
	@Override
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void finirTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void prendreTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		//TODO
		return null;
	}
	
	public boolean equals(Object obj) {
		//TODO
		return false;
	}
	


}
