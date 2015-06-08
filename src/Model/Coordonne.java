package Model;

import java.util.Vector;

/**
 * Classe qui definie une coordonne
 */
public class Coordonne {

	private int x,y,z;

	/**
	 * Constructeur d'une coordonne
	 * @param x valeur de x
	 * @param y valeur de y
	 * @param z valeur de z
	 */
	public Coordonne(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Getter de toutes les coordonnes apartennant a une couche precise
	 * @param couche couche a verifier
	 * @return tableau avec les coordonnes de la couche
	 */
	public Vector<Coordonne> getCoordonnesCouche(int couche){
		//TODO: tester!!!!
		Vector<Coordonne> coordonnes = new Vector();
		Coordonne nouvelleCoordonne = new Coordonne(x+couche, y, z+couche);
		coordonnes.add(nouvelleCoordonne);
		int deltaX, deltaY, deltaZ;
		while(nouvelleCoordonne.getZ() != z){
			deltaX = 0;
			deltaY = 1;
			deltaZ = -1;
			nouvelleCoordonne = nouvelleCoordonne.addicionnerALaCoordonne(deltaX,deltaY,deltaZ);
			coordonnes.add(nouvelleCoordonne);
		}
		while(nouvelleCoordonne.getX() != x){
			deltaX = -1;
			deltaY = 0;
			deltaZ = -1;
			nouvelleCoordonne = nouvelleCoordonne.addicionnerALaCoordonne(deltaX,deltaY,deltaZ);
			coordonnes.add(nouvelleCoordonne);
		}
		while(nouvelleCoordonne.getY() != y){
			deltaX = -1;
			deltaY = -1;
			deltaZ = 0;
			nouvelleCoordonne = nouvelleCoordonne.addicionnerALaCoordonne(deltaX,deltaY,deltaZ);
			coordonnes.add(nouvelleCoordonne);
		}
		while(nouvelleCoordonne.getZ() != z){
			deltaX = 0;
			deltaY = -1;
			deltaZ = 1;
			nouvelleCoordonne = nouvelleCoordonne.addicionnerALaCoordonne(deltaX,deltaY,deltaZ);
			coordonnes.add(nouvelleCoordonne);
		}
		while(nouvelleCoordonne.getX() != x){
			deltaX = 1;
			deltaY = 0;
			deltaZ = 1;
			nouvelleCoordonne = nouvelleCoordonne.addicionnerALaCoordonne(deltaX,deltaY,deltaZ);
			coordonnes.add(nouvelleCoordonne);
		}
		while(nouvelleCoordonne.getY() != (y-1)){
			deltaX = 1;
			deltaY = 1;
			deltaZ = 0;
			nouvelleCoordonne = nouvelleCoordonne.addicionnerALaCoordonne(deltaX,deltaY,deltaZ);
			coordonnes.add(nouvelleCoordonne);
		}
		return coordonnes;
	}

	/**
	 * Getter de toutes les coordonnes apartennant a une couche precise contenant celles des couches plus petites
	 * @param couche couche a verifier
	 * @return tableau avec les coordonnes de la couche
	 */
	public Vector<Coordonne> getToutesCoordonnesDansCouche(int couche){
		Vector<Coordonne> coordonnes = new Vector();
		for(int i = 1; i <= couche; i++){
			coordonnes = getCoordonnesCouche(i);
		}
		return coordonnes;
	}

	/**
	 * Getter de la coordonne x
	 * @return valeur de x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter de la coordonne y
	 * @return valeur de y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter de la coordonne z
	 * @return valeur de z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Methode qui definie l'egalité de deux coordonnes
	 * @param c coordonne a vezrifier
	 * @return vrai si coordonnes sont egales
	 */
	public boolean equals(Coordonne c){
		if(this.getX()== c.getX() && this.getY()== c.getY() && this.getZ()== c.getZ()){
			return true;
		} else{
			return false;
		}
	}

	/**
	 * Methode qui surcharge la methode toString
	 * @return une string decrivant les coordonnes
	 */
	@Override
	public String toString() {
		return "Coordonne [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * Methode qui change les valeurs des variables de la coordonne en sommant un delta a chacune
	 * @param deltaX
	 * @param deltaY
	 * @param deltaZ
	 * @return une coordonne avec les nouvelles valeurs
	 */
	private Coordonne addicionnerALaCoordonne(int deltaX, int deltaY, int deltaZ){
		Coordonne c = new Coordonne(x+deltaX, y+deltaY,z+deltaZ);
		return c;
	}
}
