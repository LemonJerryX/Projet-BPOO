package IJoueur;


import java.util.*;

import Hero.Hero;
import ICarte.ICarte;
import HearthstoneException.HearthstoneException;

public interface IJoueur {
	static int MAX_MANA = 10;
	static int TAILLE_DECK = 15;
	
	public String getPseudo();
	public Hero getHero();
	public int getMana();
	public int getStockMana();
	public ArrayList<ICarte> getJeu();
	public ArrayList<ICarte> getMain();
	public ICarte getCarteEnJeu(String nomCarte);
	public ICarte getCarteEnMain(String nomCarteMain);
	public void piocher() throws HearthstoneException;
	public void jouerCarte(ICarte carte) throws HearthstoneException;
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException;
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
	public void utiliserPouvoir(java.lang.Object cible) throws HearthstoneException;
	public void finirTour() throws HearthstoneException;
	public void perdreCarte(ICarte carte) throws HearthstoneException;
	public void prendreTour() throws HearthstoneException;
	
	
}
