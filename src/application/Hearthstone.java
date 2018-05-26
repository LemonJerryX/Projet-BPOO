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
		IJoueur joueur2 = new Joueur("Joueur2",heroJ2);
		heroJ1.setJoueur(joueur2);
		plateau.ajouterJoueur(joueur2);
		
		plateau.setJoueurCourant(joueur1);
		
		Console s = new Console();
		int choix;
		String nomCarte;
		boolean choixInvalid;
		String nomCible;
		Object cible = null;
		ICarte carte = null;
		plateau.demarrerPartie();
		plateau.nouvelTour(plateau.getJoueurCourant());
		IJoueur joueurCourant;
		Hero heroCourant;
		
		while(plateau.estDemarree()) {
			System.out.print(plateau.toString());
			String choixText = "Que veux-tu faire ?\n";
			choixText += "1. Finir le tour\n";
			choixText += "2. Jouer une carte de ta main\n";
			choixText += "3. Utiliser une carte en jeu\n";
			choixText += "4. Utiliser le pouvoir du héros\n";
			choixText += "Votre choix :";
			System.out.print(choixText);
			
			s = new Console();
		    choix = s.readInt();
		    joueurCourant = plateau.getJoueurCourant();
		    heroCourant = plateau.getJoueurCourant().getHero();
		    
		    while(choix < 1 || choix > 4) {
		    		System.out.print("Choix invalide, veuillez rechoisir: ");
		    		choix = s.readInt();
		    }
		    
		    switch(choix) {
		    		case 1:
		    			joueurCourant.finirTour();
		    			plateau.setJoueurCourant(plateau.getAdversaire(joueurCourant));
		    			plateau.nouvelTour(plateau.getJoueurCourant());
		    			break;
		    		case 2:
		    			System.out.print("Donnez le nom de la carte:");
		    			nomCarte = s.readLine();
		    			choixInvalid = true;
		    			
		    			//Tester l'existence d'une carte
		    			while(choixInvalid) {
		    				try {
		    					choixInvalid = false;
			    				carte = joueurCourant.getCarteEnMain(nomCarte);
			    			}catch(HearthstoneException e) {
			    				choixInvalid = true;
			    				e.printStackTrace();
			    				System.out.print("Donnez le nom de la carte:");
				    			nomCarte = s.readLine();
			    			}
		    			}
		    			
		    			//si c'est une carte sort, il peut avoie un effet tout de suite;
		    			if(carte instanceof CarteSort) {
		    				if(((CarteSort) carte).getCapacite().cibleSpecifique())
		    					nomCible = ((CarteSort) carte).getCapacite().getCibleSpecifique();
		    				else {
		    					System.out.print("Donnez le nom du cible:");
		    					nomCible = s.readLine();
		    				}
		    				
			    			choixInvalid = true;
			    			while(choixInvalid) {
			    				try {
				    					choixInvalid = false;
				    					if(!nomCible.equals("hero")) {
				    						cible = plateau.getAdversaire(joueurCourant).getCarteEnJeu(nomCible);
				    					}
				    					else {
				    						cible = plateau.getAdversaire(joueurCourant).getHero();
			    					}
				    				
				    			}catch(HearthstoneException e) {
				    				choixInvalid = true;
				    				e.printStackTrace();
				    				System.out.print("Donnez le nom du cible:");
					    			nomCarte = s.readLine();
				    			}
			    			}
			    			
			    			try {
			    				joueurCourant.jouerCarte(carte, cible);
			    			}catch(HearthstoneException e) {
			    				e.printStackTrace();
			    			}
		    			}
		    			
		    			//si c'est un serviteur, il suffit de le poser sur le plateau
		    			else {
		    				joueurCourant.jouerCarte(carte);
		    			}		
		    			break;
		    		case 3:
		    			System.out.print("Donnez le nom de la carte:");
		    			nomCarte = s.readLine();
		    			choixInvalid = true;
		    			while(choixInvalid) {
		    				try {
		    					choixInvalid = false;
			    				carte = joueurCourant.getCarteEnJeu(nomCarte);
			    			}catch(HearthstoneException e) {
			    				choixInvalid = true;
			    				e.printStackTrace();
			    				System.out.println("Donnez le nom de la carte:");
				    			nomCarte = s.readLine();
			    			}
		    			}
		    			
		    			if(!carte.estJouable()) {
		    				System.out.println("Cette carte n'est pas jouable, choissiez une autre catre:");
		    			}
		    			else {
		    				System.out.print("Donnez le nom du cible:");
	    					nomCible = s.readLine();
	    					choixInvalid = true;
	    					try {
		    					choixInvalid = false;
		    					if(!nomCible.equals("hero")) {
		    						cible = plateau.getAdversaire(joueurCourant).getCarteEnJeu(nomCible);
		    					}
		    					else {
		    						cible = plateau.getAdversaire(joueurCourant).getHero();
		    					}
		    				
			    			}catch(HearthstoneException e) {
			    				choixInvalid = true;
			    				e.printStackTrace();
			    				System.out.println("Donnez le nom du cible:");
				    			nomCarte = s.readLine();
			    			}
	    					
		    			}
		    			
		    			break;
		    		case 4:
		    			if(heroCourant.isDejaUP()) {
		    				System.out.println("Vous avez déjà utilisé le pouvoir!");
		    			}
		    			else if(heroCourant.getCoutPouvoir()>joueurCourant.getStockMana()){
		    				System.out.println("Vous avez pas assez de mana pour exécuter le pouvoir!");
		    			}
		    			else {
		    				//Tester si le cible est unique
		    				if(heroCourant.getCapacite().cibleSpecifique())
		    					nomCible = heroCourant.getCapacite().getCibleSpecifique();
		    				else {
		    					System.out.print("Donnez le nom du cible:");
		    					nomCible = s.readLine();
		    				}
		    				//determiner le cible
		    				try {
		    					choixInvalid = false;
		    					if(!nomCible.equals("hero")) {
		    						cible = plateau.getAdversaire(joueurCourant).getCarteEnJeu(nomCible);
		    					}
		    					else {
		    						cible = plateau.getAdversaire(joueurCourant).getHero();
		    					}
		    				
			    			}catch(HearthstoneException e) {
			    				choixInvalid = true;
			    				e.printStackTrace();
			    				System.out.println("Donnez le nom du cible:");
				    			nomCarte = s.readLine();
			    			}
			    			
		    				
			    			try {
			    				heroCourant.utiliserPouvoir(cible);
			    				System.out.print(joueurCourant.getStockMana());
			    				
			    				System.out.print(heroCourant.getCoutPouvoir());
			    				joueurCourant.setStockMana(joueurCourant.getStockMana()-heroCourant.getCoutPouvoir());
			    			}catch(HearthstoneException e) {
			    				e.printStackTrace();
			    			}
		    			}
		    			break;
		    }
			
			if(plateau.getAdversaire(joueurCourant).getHero().getVieActuelle()<=0)
				plateau.gagnePartie(joueurCourant);
			
			
		}
	}
	
		
	
}
