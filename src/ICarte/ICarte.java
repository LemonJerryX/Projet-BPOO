package ICarte;


import HearthstoneException.HearthstoneException;
import IJoueur.IJoueur;

public interface ICarte extends Cloneable{
	public String getNom();
	public IJoueur getProprietaire();
	public void setProprietaire(IJoueur joueur);
	public int getCout();
	
	/**
	 * Fonction qui teste si les conditions pour que la carte soit encore présente au tour suivant
	 * @return
	 */
	public boolean disparait();
	
	/**
	 * Une carte peut avoir un effet au début de chaque tour où elle est en jeu
	 * @throws HearthstoneException
	 */
	public void executerEffetDebutTour() throws HearthstoneException;
	
	/**
	 * Une carte peut avoir une action qui se commande à n'importe quel moment du tour lorsqu'elle est en jeu
	 * @param cible
	 * @throws HearthstoneException
	 */
	public void executerAction(Object cible) throws HearthstoneException;
	
	/**
	 * Une carte peut avoir un effet au début de sa mise en jeu
	 * @param cible
	 * @throws HearthstoneException
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;	
	
	
	/**
	 * Une carte peut avoir un effet au moment de sa disparition du jeu
	 * @param cible
	 * @throws HearthstoneException
	 */
	public void executerEffetDisparition(Object cible) throws HearthstoneException;
	
	
	/**
	 * Une carte peut avoir un effet à la fin d'un chaque tour où elle est en jeu
	 * @throws HearthstoneException
	 */
	public void executerEffetFinTour()throws HearthstoneException;
	
	/**
	 * @param jouable
	 */
	public void setJouable(boolean jouable);
	
	public boolean estJouable();
	
	
	
}
