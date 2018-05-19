package ICarte;
import ICapacite.ICapacite;

public abstract class CarteSort extends CarteBase{
	
	private ICapacite capacite;
	
	public CarteSort(String nom, int cout, ICapacite capacite){
		super(nom,cout);
		setCapacite(capacite);
	}
	
	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}

	public String toString() {
		return super.toString() + capacite +"]";
	}
	
}
