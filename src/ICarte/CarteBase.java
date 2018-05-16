package ICarte;
import Hero.Hero;

public abstract class CarteBase implements ICarte{
	private String nom;
	private int cout;
	
	public CarteBase (String nom, int cout) {
		setNom(nom);
		setCout(cout);
	}
	
	
	private void setCout(int cout) {
		if(cout <=0)
			throw new IllegalArgumentException("Le cout est trop petit, veuillez donner un cout strictement positif");
		this.cout = cout;
	}


	private void setNom(String nom) {
		// TODO Reste à vérifier si le nom a déjà été pris par une autre carte
		if(nom == null)
			throw new IllegalArgumentException("Le nom de la carte ne doit pas être null!");
		if(nom.equals(""))
			throw new IllegalArgumentException("Le nom de la carte ne doit pas être vide!");
		this.nom = nom;
		
	}
	

	@Override
	public String getNom() {
		return nom;
	}
	
	
	@Override
	public int getCout() {
		return cout;
	}
	
	public String toString() {
		return "Carte[ Nom: " + this.nom + "; Cout: " + this.cout +"]";
	}
	
	public boolean eauqls(Object obj) {
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(!(obj instanceof Hero))
			return false;
		CarteBase carte = (CarteBase) obj;
		//TODO Pour l'instant, je considère que deux cartes de même nom sont identiques, reste à vérifier
		return carte.getNom().equals(this.nom);
	}
	
	
}
