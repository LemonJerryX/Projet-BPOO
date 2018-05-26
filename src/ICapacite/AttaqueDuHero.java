package ICapacite;

import HearthstoneException.*;
import Hero.Hero;
import IJoueur.IJoueur;

public class AttaqueDuHero extends Capacite{
	private final static String nomCapacite = "Attaque du hero";
	private final static String description = "Attaquer le héros adverse en toute circonstance";
	public AttaqueDuHero(int degat) {
		super(nomCapacite,description,degat);
	}

	@Override
	public void executerEffetDebutTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		if(getDejaUtilise())
			throw new HearthstoneException("Vous avez déjà utilisé cette capacité");
		else if(cible instanceof IJoueur){
			Hero hero = ((IJoueur) cible).getHero();
			setDejaUtilise(true);
			hero.etreAttaque(this.getDegat());;
			//TODO À revoir ce qu'il faudra faire quand le hero meurt
			if(hero.perdre()) {
				
			}
		}
		else if(cible instanceof Hero) {
			setDejaUtilise(true);
			((Hero) cible).etreAttaque(this.getDegat());;
			//TODO À revoir ce qu'il faudra faire quand le hero meurt
			if(((Hero) cible).perdre()) {
				
			}
		}
	}
		
		


	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
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
		
		return true;
	}

	/* (non-Javadoc)
	 * @see ICapacite.ICapacite#getCibleSpecifique()
	 */
	@Override
	public String getCibleSpecifique() {
		// TODO Auto-generated method stub
		return "hero";
	}
	

}
