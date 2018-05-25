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
	/**
	 * Le nombre de mana augmente de 1 à chaque tour.
	 * @return
	 */
	public int getMana();
	
	/**
	 * Nombre de manas encore disponibles pendant le tour.
	 * @return
	 */
	public int getStockMana();
	public ArrayList<ICarte> getJeu();
	public ArrayList<ICarte> getMain();
	public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException;
	public ICarte getCarteEnMain(String nomCarteMain) throws HearthstoneException;
	public void piocher() throws HearthstoneException;
	
	/**
	 * Pendant le tour, un joueur peut tenter de prendre une carte de sa main et de la placer sur le board.
	 * @param carte
	 * @throws HearthstoneException
	 */
	public void jouerCarte(ICarte carte) throws HearthstoneException;
	
	/**
	 * Pendant le tour, un joueur peut tenter de prendre une carte de sa main et de la placer sur le board.
	 * @param carte
	 * @param cible
	 * @throws HearthstoneException
	 */
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException;
	
	/**
	 * Lorsque qu'une carte est en jeu, le joueur peut utiliser cette carte.
	 * @param carte
	 * @param cible
	 * @throws HearthstoneException
	 */
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
	public void utiliserPouvoir(Object cible) throws HearthstoneException;
	public void finirTour() throws HearthstoneException;
	public void perdreCarte(ICarte carte) throws HearthstoneException;
	public void prendreTour() throws HearthstoneException;
	
	
}
