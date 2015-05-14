package Model;

public class Escalier extends Case {
	private final String TYPE = "escalier";
	
	public Escalier(Coordonne c) {
		super(c);
	}
	
	public String getType(){
		return TYPE;
	}

}
