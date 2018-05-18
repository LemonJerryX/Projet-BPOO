package ICapacite;

import HearthstoneException.*;
import Hero.Hero;
import IJoueur.IJoueur;

public class AttaqueDuHero extends Capacite{
	private static String nomCapacite = "Attaque du hero";
	private static String description = "Attaquer le héros adverse en toute circonstance";
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
	

}
