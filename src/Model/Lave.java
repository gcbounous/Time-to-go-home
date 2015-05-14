package Model;

public class Lave extends Case implements Mortel {
	private final String TYPE = "lave";
	
	public Lave(Coordonne c) {
		super(c);
	}
	
	public String getType(){
		return TYPE;
	}

}
