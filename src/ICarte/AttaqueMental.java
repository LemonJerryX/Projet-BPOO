/**
 * 
 */
package ICarte;

import HearthstoneException.HearthstoneException;
import ICapacite.*;
import IJoueur.IJoueur;

public final class AttaqueMental extends CarteSort{
	
	private static final String nom = "Attaque Mental";
	private static final int cout = 2;
	private static final ICapacite capacite = new AttaqueDuHero(5);
	
	
	public AttaqueMental() {
		super(nom,cout, capacite);
		setProprietaire(null);
		
	}
	
	public AttaqueMental(IJoueur proprietaire) {
		super(nom,cout, capacite);
		setProprietaire(proprietaire);
	}
	
	/* (non-Javadoc)
	 * @see ICarte.ICarte#disparait()
	 */
	@Override
	public boolean disparait() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see ICarte.ICarte#executerEffetDebutTour()
	 */
	@Override
	public void executerEffetDebutTour() throws HearthstoneException {
		
	}
	
	/* (non-Javadoc)
	 * @see ICarte.ICarte#executerAction(java.lang.Object)
	 */
	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		
	}
	
	/* (non-Javadoc)
	 * @see ICarte.ICarte#executerEffetMiseEnJeu(java.lang.Object)
	 */
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see ICarte.ICarte#executerEffetDisparition(java.lang.Object)
	 */
	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		AttaqueMental.capacite.executerAction(cible);
	}
	
	/* (non-Javadoc)
	 * @see ICarte.ICarte#executerEffetFinTour()
	 */
	@Override
	public void executerEffetFinTour() throws HearthstoneException {
		
	}

	
	

}
