package Model;

public abstract class Case {
	private Coordonne coordonne;
	
	public Case(Coordonne c) {
		this.coordonne = c;
	}

	public Coordonne getCoordonne() {
		return coordonne;
	}

	public void setCoordonne(Coordonne coordonne) {
		this.coordonne = coordonne;
	}
	
	public abstract String getType();

}
