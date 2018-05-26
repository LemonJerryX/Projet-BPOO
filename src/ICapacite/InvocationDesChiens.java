package ICapacite;

import HearthstoneException.HearthstoneException;

public class InvocationDesChiens extends Capacite{

	private static String nomCapacite = "Invocation des chiens";
	private static String description = "Au moment de sa mise en jeu, la carte va créer autant de chiens (+1/+1 avec \"Charge\") que le joueur adverse a de serviteurs";
	
	public InvocationDesChiens() {
		super(nomCapacite,description);
	}

	@Override
	public void executerEffetDebutTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO besoin de plus de méthodes pour la réaliser
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ICapacite.ICapacite#cibleSpecifique()
	 */
	@Override
	public boolean cibleSpecifique() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see ICapacite.ICapacite#getCibleSpecifique()
	 */
	@Override
	public String getCibleSpecifique() {
		// TODO Auto-generated method stub
		return null;
	}

}
