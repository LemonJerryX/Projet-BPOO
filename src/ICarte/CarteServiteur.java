package ICarte;
import HearthstoneException.HearthstoneException;
import IJoueur.IJoueur;

public abstract class CarteServiteur extends CarteBase{
	
	public CarteServiteur(String nom, int cout){
		super(nom,cout);
	}
	

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IJoueur getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean disparait() {
		// TODO Auto-generated method stub
		return false;
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
