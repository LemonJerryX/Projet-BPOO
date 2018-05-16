package IPlateau;
import HearthstoneException.HearthstoneException;
import IJoueur.IJoueur;

public interface IPlateau {
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
	public IJoueur getJoueurCourant();
	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException;
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException;
	public void demarrerPartie() throws HearthstoneException;
	public boolean estDemarree();
	public void finTour(IJoueur joueur) throws HearthstoneException;
	public void gagnePartie(IJoueur joueur) throws HearthstoneException;
}
