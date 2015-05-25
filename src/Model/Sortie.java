package Model;

public class Sortie extends Case {
	private final String TYPE = "sortie";
	
	public Sortie(Coordonne c) {
		super(c);
	}
	
	public String getType(){
		return TYPE;
	}

}
