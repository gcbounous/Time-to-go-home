package Model;

/**
 * Classe qui definie une case basique
 */
public abstract class Case {
	final private Coordonne coordonne;

	/**
	 * Constructeur d'une case
	 * @param c coordonee de la case
	 */
	public Case(Coordonne c) {
		this.coordonne = c;
	}

	/**
	 * Methode qui verifie si la case est une case voisine de cette case
	 * @param caseAVerifier case a verifier le voisinage
	 * @return vrai si la case est voisine
	 */
	public boolean aPourCaseVoisine(Case caseAVerifier){
		Coordonne c = caseAVerifier.getCoordonne();
		Coordonne[] coordonnesAutour = {
				new Coordonne(coordonne.getX(), coordonne.getY() - 1, coordonne.getZ() + 1),
				new Coordonne(coordonne.getX() + 1, coordonne.getY(), coordonne.getZ() + 1),
				new Coordonne(coordonne.getX() + 1, coordonne.getY() + 1, coordonne.getZ()),
				new Coordonne(coordonne.getX(), coordonne.getY() + 1, coordonne.getZ() - 1),
				new Coordonne(coordonne.getX() - 1, coordonne.getY(), coordonne.getZ() - 1),
				new Coordonne(coordonne.getX() - 1, coordonne.getY() - 1, coordonne.getZ()) };

		for (int i = 0; i < coordonnesAutour.length; i++) {
			if (coordonnesAutour[i].equals(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getter de la coordonne
	 * @return la coordonne de cette case
	 */
	public Coordonne getCoordonne() {
		return coordonne;
	}

	/**
	 * Getter abstract du type de la case
	 * @return String avec le type de la case
	 */
	public abstract String getType();

}
