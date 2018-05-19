package ICarte;
import ICapacite.ICapacite;


public abstract class CarteServiteur extends CarteBase{
	private int attaque;
	private int vieMax;
	private int vieActuelle;
	private ICapacite capacite;
	private boolean jouable;
	
	public CarteServiteur(String nom, int cout, int attaque, int vieMax){
		super(nom,cout);
		setAttaque(attaque);
		setVieMax(vieMax);
		setVieActuelle(vieMax);
		this.capacite = null;
		setJouable(true);
	}
	
	public CarteServiteur(String nom, int cout, int attaque, int vieMax, ICapacite capacite){
		super(nom,cout);
		setAttaque(attaque);
		setVieMax(vieMax);
		setVieActuelle(vieMax);
		setCapacite(capacite);
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		if(attaque<0)
			throw new IllegalArgumentException("Error: Attaque négatif");
		this.attaque = attaque;
	}

	public int getVieMax() {
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		if(vieMax <= 0)
			throw new IllegalArgumentException("Error: vieMax doit être strictement positive");
		this.vieMax = vieMax;
	}

	public int getVieActuelle() {
		return vieActuelle;
	}

	public void setVieActuelle(int vieActuelle) {
		this.vieActuelle = vieActuelle;
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}
	
	public boolean isJouable() {
		return jouable;
	}

	public void setJouable(boolean jouable) {
		this.jouable = jouable;
	}

	public String toString() {
		String str;
		if(capacite == null)
			str =";]";
		else
			str = ";" + capacite +"]";
		return super.toString() + " Attaque: "+ this.attaque + "; VieActuelle: "+ this.vieActuelle + str;
	}

	

}
