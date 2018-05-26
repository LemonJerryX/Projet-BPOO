package ICapacite;
import HearthstoneException.HearthstoneException;

public interface ICapacite {
	public String getDescription();
	public String getNomCapacite();
	public int getDegat();
	public void executerEffetDebutTour() throws HearthstoneException;
	public void executerAction(Object cible) throws HearthstoneException;
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;	
	public void executerEffetDisparition(Object cible) throws HearthstoneException;
	public void executerEffetFinTour()throws HearthstoneException;
	/**
	 * Renvoie le cout du pouvoir de l'héros (UNIQUEMENT pour l'héros)
	 * @return
	 */
	public int getCoutPouvoir();
	/**
	 * @return
	 */
	public boolean cibleSpecifique();
	
	public String getCibleSpecifique();
	
		
}
