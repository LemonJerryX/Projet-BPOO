
package IPlateau;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import IJoueur.IJoueur;

public class Plateau implements IPlateau{

	private IJoueur joueurCourant;
	private ArrayList<IJoueur> listeJoueurs = new ArrayList<IJoueur>();
	private boolean demaree;
	
	/** Constructeur privé */
    private Plateau(){
    }
    
    /** Instance unique pré-initialisée */
    private static IPlateau INSTANCE = new Plateau();
     
    /** Point d'accès pour l'instance unique du singleton */
    public static IPlateau getInstance()
    {   
    		return INSTANCE;
    }
    
    
	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#ajouterJoueur(IJoueur.IJoueur)
	 */
	@Override
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		if(listeJoueurs.size()>=2)
			throw new HearthstoneException("Trop de joueurs! vous ne pouvez pas en ajouter plus.");
		else if(listeJoueurs.contains(joueur))
			throw new HearthstoneException("Vous ne pouvez pas jouer contre vous-même");
		listeJoueurs.add(joueur);	
	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#getJoueurCourant()
	 */
	@Override
	public IJoueur getJoueurCourant() {
		return joueurCourant;
	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#setJoueurCourant(IJoueur.IJoueur)
	 */
	@Override
	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException {
		if(!listeJoueurs.contains(joueur))
			throw new HearthstoneException("Le joueur n'est pas valide, il n'est pas dans la listes des joueurs.");
		this.joueurCourant = joueur;
	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#getAdversaire(IJoueur.IJoueur)
	 */
	@Override
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		if(!listeJoueurs.contains(joueur))
			throw new HearthstoneException("Le joueur n'est pas valide, il n'est pas dans la listes des joueurs.");
		if(listeJoueurs.get(0) == joueur)
			return listeJoueurs.get(1);
		else
			return listeJoueurs.get(0);
	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#demarrerPartie()
	 */
	@Override
	public void demarrerPartie() throws HearthstoneException {
		//TODO À vérifier si aucune opération est oubliée
		if(demaree)
			throw new HearthstoneException("La partie est déjà démarée");
		else if(listeJoueurs.size() != 2)
			throw new HearthstoneException("Vérifiez le nombre de joueurs avant de démarer");
		joueurCourant = listeJoueurs.get(0);
		demaree = true;

	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#estDemarree()
	 */
	@Override
	public boolean estDemarree() {
		return demaree;
	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#finTour(IJoueur.IJoueur)
	 */
	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		if(!demaree)
			throw new HearthstoneException("La partie n'est même pas démarée!");
		else if(joueurCourant != joueur)
			throw new HearthstoneException("Veuillez attendre votre tour");
		else {
			joueur.finirTour();
			setJoueurCourant(getAdversaire(joueur));
		}
			
		
	}

	/* (non-Javadoc)
	 * @see IPlateau.IPlateau#gagnePartie(IJoueur.IJoueur)
	 */
	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		demaree = false;
		String messageGagne = "" + joueur.getPseudo() + "a gagné. Félicitations!";
		System.out.println(messageGagne);
		
	}
	
	public String toString(){
		IJoueur adversaire = null;
		try {
			adversaire = getAdversaire(joueurCourant);
		} catch (HearthstoneException e) {
			e.printStackTrace();
		}
		String str = "**************************************************\n";
		str += "Joueur courant:\n";
		str += joueurCourant+"\n";
		str += joueurCourant.getHero().getCapacite()+"\n";
		str += "**************************************************\n";
		
		str += "\n\n";
		
		str += "==================================\n";
		str += joueurCourant.getJeu();
		str += "==================================\n\n";
		str += "----------------------------------\n\n";
		str += "==================================\n";
		str += adversaire.getJeu();
		str += "==================================\n\n";
		
		str += "\n\n";
		
		str += "**************************************************\n";
		str += "Joueur courant:\n";
		str += adversaire+"\n";
		str += adversaire.getHero().getCapacite()+"\n";
		str += "**************************************************\n";
		
		str += "\n\n";
		
		str += "Que veux-tu faire ?\n" + 
				"1. Finir le tour\n" + 
				"2. Jouer une carte de ta main\n" + 
				"3. Utiliser une carte en jeu\n" + 
				"4. Utiliser le pouvoir du hйros";
		return str;
		
		
	}

}
