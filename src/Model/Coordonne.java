package Model;

public class Coordonne {

	private int x,y,z;
	
	public Coordonne(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}	

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public boolean equals(Coordonne c){
		if(this.getX()== c.getX() && this.getY()== c.getY() && this.getZ()== c.getZ()){
			return true;
		} else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Coordonne [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	

}
