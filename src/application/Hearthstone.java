package application;
import HearthstoneException.*;
import Hero.*;
import ICarte.*;
import IJoueur.*;
import IPlateau.*;
import io.Console;

public class Hearthstone {
	public static void main(String[] args) throws HearthstoneException, CloneNotSupportedException {
		IPlateau plateau = Plateau.getInstance();
		Hero heroJ1 = new Jaina();
		IJoueur joueur1 = new Joueur("Joueur1",heroJ1);
		heroJ1.setJoueur(joueur1);
		plateau.ajouterJoueur(joueur1);
		
		
		Hero heroJ2 = new Jaina();
		IJoueur joueur2 = new Joueur("Joueur1",heroJ2);
		heroJ1.setJoueur(joueur2);
		plateau.ajouterJoueur(joueur2);
		
		Console s = new Console();
		int choix;
		String nomCarte;
		boolean choixInvalid;
		String nomCible;
		Object cible = null;
		ICarte carte = null;
		
		while(plateau.estDemarree()) {
			String choixText = "Que veux-tu faire ?\n";
			choixText += "1. Finir le tour\n";
			choixText += "2. Jouer une carte de ta main\n";
			choixText += "3. Utiliser une carte en jeu\n";
			choixText += "4. Utiliser le pouvoir du héros\n";
			choixText += "Votre choix :";
			System.out.print(choixText);
			
			s = new Console();
		    choix = s.readInt();
		    
		   
		    
		    
		    while(choix < 1 || choix > 4) {
		    		System.out.print("Choix invalide, veuillez rechoisir: ");
		    		choix = s.readInt();
		    }
		    
		    switch(choix) {
		    		case 1:
		    			plateau.getJoueurCourant().finirTour();
		    			plateau.setJoueurCourant(plateau.getAdversaire(plateau.getJoueurCourant()));
		    			break;
		    		case 2:
		    			System.out.print("Donnez le nom de la carte:");
		    			nomCarte = s.readLine();
		    			choixInvalid = true;
		    			while(choixInvalid) {
		    				try {
		    					choixInvalid = false;
			    				carte = plateau.getJoueurCourant().getCarteEnMain(nomCarte);
			    			}catch(HearthstoneException e) {
			    				choixInvalid = true;
			    				e.printStackTrace();
			    				System.out.print("Donnez le nom de la carte:");
				    			nomCarte = s.readLine();
			    			}
		    			}
		    			
		    			if(carte instanceof CarteSort) {
		    				System.out.print("Donnez le nom du cible:");
			    			nomCible = s.readLine();
			    			choixInvalid = true;
			    			while(choixInvalid) {
			    				try {
			    					choixInvalid = false;
			    					if(!nomCible.equals("hero")) {
			    						cible = plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(nomCible);
			    					}
			    					else {
			    						cible = plateau.getAdversaire(plateau.getJoueurCourant()).getHero();
			    					}
				    				
				    			}catch(HearthstoneException e) {
				    				choixInvalid = true;
				    				e.printStackTrace();
				    				System.out.print("Donnez le nom du cible:");
					    			nomCarte = s.readLine();
				    			}
			    			}
			    			
			    			try {
			    				plateau.getJoueurCourant().jouerCarte(carte, cible);
			    			}catch(HearthstoneException e) {
			    				e.printStackTrace();
			    			}
		    			}
		    			
		    			else {
		    				plateau.getJoueurCourant().jouerCarte(carte);
		    			}
		    			
		    			
		    			
		    		
		    			
		    			
		    			break;
		    		case 3:
		    			break;
		    		case 4:
		    			break;
		    }
			
			
			
			
		}
	}
	
	public void setCartesCommunes(IPlateau plateau) {
		
	}
}
