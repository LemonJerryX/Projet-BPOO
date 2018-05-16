package ICarte;


import HearthstoneException.HearthstoneException;
import IJoueur.IJoueur;

public interface ICarte extends Cloneable{
	public String getNom();
	public IJoueur getProprietaire();
	public int getCout();
	public boolean disparait();
	public void executerEffetDebutTour() throws HearthstoneException;
	public void executerAction(Object cible) throws HearthstoneException;
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;	
	public void executerEffetDisparition(Object cible) throws HearthstoneException;
	public void executerEffetFinTour()throws HearthstoneException;
	
	
}
