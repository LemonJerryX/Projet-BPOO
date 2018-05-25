
package Hero;

import HearthstoneException.HearthstoneException;
import ICapacite.*;
import ICarte.*;
import IJoueur.IJoueur;

public class Jaina extends Hero{
	
	public Jaina() throws HearthstoneException {
		super("Jaina",15,new AttaqueDuHero(1));
	}
	
	public Jaina(IJoueur joueur) throws HearthstoneException {
		super("Jaina",15,new AttaqueDuHero(1));
		setJoueur(joueur);
	}
	
	public void setDeckHero() {
		deckHero.add(new AttaqueMental(this.getJoueur()));
		deckHero.add(new AttaqueMental(this.getJoueur()));
		deckHero.add(new AttaqueMental(this.getJoueur()));
	}

}
