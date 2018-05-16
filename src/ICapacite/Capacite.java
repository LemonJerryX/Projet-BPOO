package ICapacite;
public abstract class Capacite implements ICapacite{

	private String nomCapacite;
	private String description;
	private int degat;
	
	public Capacite(String nom, String description, int degat) {
		setNomCapacite(nom);
		setDescription(description);
		setDegat(degat);
	}
	
	public Capacite(String nom, String description) {
		setNomCapacite(nom);
		setDescription(description);
		setDegat(0);
	}
	
	private void setDegat(int degat) {
		if(degat < 0)
			throw new IllegalArgumentException("Erreur: degat negatif!");
		this.degat = degat;
		
	}

	private void setDescription(String description) {
		if(description == null)
			throw new IllegalArgumentException("La descroption de la capacité ne doit pas être null!");
		if(description.equals(""))
			throw new IllegalArgumentException("La descroption de la capacité ne doit pas être vide!");
		this.description = description;
		
	}

	private void setNomCapacite(String nom) {
		if(nom == null)
			throw new IllegalArgumentException("Le nom de la capacité ne doit pas être null!");
		if(nom.equals(""))
			throw new IllegalArgumentException("Le nom de la capacité ne doit pas être vide!");
		this.nomCapacite = nom;
		
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getNomCapacite() {
		return nomCapacite;
	}

	@Override
	public int getDegat() {
		return degat;
	}

	
	public String toString() {
		String str;
		if(degat == 0)
			str = "";
		else
			str = "; Degat: " + degat; 
		return "Capacite : [Nom: " + this.nomCapacite+"; Description: " + this.description + str + "]"; 
	}

}
