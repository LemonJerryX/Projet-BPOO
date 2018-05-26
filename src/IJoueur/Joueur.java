package IJoueur;
import java.util.ArrayList;
import java.util.Iterator;

import HearthstoneException.HearthstoneException;
import HearthstoneException.ManaEpuiseException;
import Hero.Hero;
import ICarte.*;

public class Joueur implements IJoueur{
	
	private String pseudo;
	private Hero hero;
	private int mana;
	private int stockMana;
	private ArrayList<ICarte> jeu;
	private ArrayList<ICarte> main;
	private ArrayList<ICarte> deck;
	private boolean finiTour;
	
	public Joueur(String pseudo, Hero hero) throws HearthstoneException, CloneNotSupportedException {
		setPseudo(pseudo);
		setHero(hero);
		setMana(0);
		setStockMana(0);
		jeu = new ArrayList<ICarte>();
		main = new ArrayList<ICarte>();
		initialiseDeck(hero);
		setFiniTour(false);
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
	
	public void setHero(Hero hero) throws HearthstoneException, CloneNotSupportedException {
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
		this.stockMana = stockMana;
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
	public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException {
		Iterator<ICarte> iterateur = jeu.iterator();
		ICarte eleCarte;
		do {
			if(!iterateur.hasNext())
				throw new HearthstoneException("La carte indiquée n'est pas en jeu");
			eleCarte = iterateur.next();
		}while(!(eleCarte.getNom().equals(nomCarte)));
		
		return eleCarte;
		
	}
	
	@Override
	public ICarte getCarteEnMain(String nomCarteMain) throws HearthstoneException {
		Iterator<ICarte> iterateur = main.iterator();
		ICarte eleCarte;
		do {
			if(!iterateur.hasNext())
				throw new HearthstoneException("La carte indiquée n'est pas en main");
			eleCarte = iterateur.next();
		}while(!(eleCarte.getNom().equals(nomCarteMain)));
		
		return eleCarte;
	}
	
	private void initialiseDeck(Hero hero) {
		deck = hero.getDeckHero();
		deck.add(new AttaqueMental(this));
		
	}

	public void piocher() throws HearthstoneException {
		int lengthList = this.deck.size();
		long ms = System.currentTimeMillis();
		int index;
		if(lengthList > 0) {
			index = (int)(ms%lengthList);
			ICarte cartePiochee = this.deck.get(index);
			this.main.add(cartePiochee);
			this.deck.remove(index);
		}
		
	
	}
	

	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if(!main.contains(carte))
			throw new HearthstoneException("La Carte choisie n'est pas dans ta main");
		else if(stockMana<carte.getCout())
			throw new HearthstoneException("Tu n'as pas assez de mana pour utiliser cette carte");
		else {
			carte.executerEffetMiseEnJeu(null);
			stockMana -= carte.getCout();
			main.remove(carte);
			jeu.add(carte);
		}
		
	}
	
	@Override
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		if(!main.contains(carte))
			throw new HearthstoneException("La Carte choisie n'est pas dans ta main");
		else if(stockMana<carte.getCout())
			throw new HearthstoneException("Tu n'as pas assez de mana pour utiliser cette carte");
		else {
			carte.executerEffetMiseEnJeu(cible);
			stockMana -= carte.getCout();
			main.remove(carte);
			if(!(carte instanceof CarteSort)) {
				jeu.add(carte);
			}
			
		}
		
	}
	
	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if(!jeu.contains(carte))
			throw new HearthstoneException("La Carte choisie n'est pas dans en jeu!");
		else {
			carte.executerAction(cible);
			if(carte.disparait()) {
				carte.executerEffetDisparition(cible);
				perdreCarte(carte);
			}
		}
		
	}
	
	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		if(hero.getCapacite() == null)
			throw new HearthstoneException("Ce héro n'a pas de capacite!");
		else if(hero.isDejaUP())
			throw new HearthstoneException("Vous avez déja utilisé le pouvoir pour ce tour!");
		else if(stockMana<hero.getCapacite().getCoutPouvoir())
			throw new HearthstoneException("Pas assez de mana pour executer le pouvoir du héros");
		hero.utiliserPouvoir(cible);
		hero.setDejaUP(true);
		
	}
	
	@Override
	public void finirTour() throws HearthstoneException {
		Iterator<ICarte> iterateur = jeu.iterator();
		while(iterateur.hasNext()) {
			iterateur.next().setJouable(false);
		}
		
		setFiniTour(true);
	}
	
	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		if(!jeu.contains(carte))
			throw new HearthstoneException("La Carte choisie n'est pas dans en jeu!");
		jeu.remove(carte);
		
	}
	
	@Override
	public void prendreTour() throws HearthstoneException {
		piocher();

		setMana(mana+1);
		setStockMana(mana);
		
		Iterator<ICarte> iterateur = jeu.iterator();
		while(iterateur.hasNext()) {
			iterateur.next().setJouable(true);
		}
		
		hero.setDejaUP(false);;
	}
	
	
	public boolean isFiniTour() {
		return finiTour;
	}

	public void setFiniTour(boolean finiTour) {
		this.finiTour = finiTour;
	}
	
	public String toString() {
		String strJeu ="";
		Iterator<ICarte> iterateur = jeu.iterator();
		while(iterateur.hasNext()) {
			strJeu = strJeu + "\n		" + iterateur.next();
		}
		
		String strMain = "";
		iterateur = main.iterator();
		while(iterateur.hasNext()) {
			strMain = strMain + "\n		" +iterateur.next();
		}
		
		return "Joueur [pseudo : " + this.pseudo + "; Mana: " + this.mana + "; StockMana: " + this.stockMana +  "];\n	Héros:[ " + this.hero + "];\n	Cartes Main: "+ strMain +"; \n	Cartes Jeu: " +strJeu; 
	}

	/* (non-Javadoc)
	 * @see IJoueur.IJoueur#incrementeMana()
	 */
	@Override
	public void incrementeMana() {
		this.mana ++;
		this.stockMana = this.mana;
		
	}
	
	



}
