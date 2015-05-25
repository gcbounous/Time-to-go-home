package Model;

import java.util.Vector;

public class Tableau {
	final private double POURCENTAGE_LAVE = 0.20;
	final private int CHANCE_LAVE = 1;
	final private int CHANCE_LAVE_AUTOUR = 6;
	final private int nombreCouches;
	private Vector<Case> cases = new Vector<Case>();

	static int compteurLave;

	/**
	 * Constructeur d'un Tableau
	 * 
	 * @param nbCouches
	 */
	public Tableau(int nbCouches) {
		this.nombreCouches = nbCouches;
		creerTableau();
	}

	/*
	 * TODO: criar verificador de "qualidade" (ver se exite caminho possivel
	 * etc...) testar com mapas pequenos e grandes testar com probabilidade de
	 * lava e numero(ou proporçao) max fazer enum para tipo das cases
	 */
	/**
	 * Methode dediee a remplir le tableau avec cases dans une distribuition
	 * aleatoire
	 */
	private void creerTableau() {
		int x, y, z;
		int ligneActuelle = nombreCouches;
		int maxLave = (int) (nbCasesDuTableau() * POURCENTAGE_LAVE);
		compteurLave = 0;

		while (ligneActuelle >= -nombreCouches) {
			if (ligneActuelle >= 0) {
				x = ligneActuelle;
				y = ligneActuelle - nombreCouches;
				z = nombreCouches;
			} else {
				x = ligneActuelle;
				y = -nombreCouches;
				z = nombreCouches + ligneActuelle;
			}
			// Boucle de contruction ligne par ligne du tableau
			for (int i = 0; i < (2 * nombreCouches + 1)
					- Math.abs(ligneActuelle); i++) {
				Coordonne c = new Coordonne(x, y, z);
				if (ligneActuelle < nombreCouches - 1) {
					remplirLave(c, maxLave);
				} else {
					creerSol(c);
				}
				y++;
				z--;
			}
			ligneActuelle--;
		}
		nettoyerTableau();
		rechercheDeChemin();
		placerSortie();
	}

	/**
	 * Methode qui determine l'algo de calcule pour l'emplacemment des cases
	 * lave dans le tableau en s'en servant des constantes predefinies
	 * "CHANCE_LAVE" et "CHANCE_LAVE_AUTOUR"
	 * 
	 * @param c
	 *            coordonee de la case
	 * @param maxLave
	 *            nombre maximum de cases lave dans le tableau
	 */
	private void remplirLave(Coordonne c, int maxLave) {
		int r = (int) (Math.random() * 10);
		if (compteurLave < maxLave) {
			if (r < CHANCE_LAVE) {
				creerLave(c);
				compteurLave++;
			} else if (existeLaveAutour(c)) {
				r = (int) (Math.random() * 10);
				if (r < CHANCE_LAVE_AUTOUR) {
					creerLave(c);
					compteurLave++;
				} else {
					creerSol(c);
				}
			} else {
				creerSol(c);
			}
		} else {
			creerSol(c);
		}
	}

	/**
	 * Methode qui place la sortie dans une case aleatoire a la premiere ligne
	 * du tableau
	 */
	private void placerSortie() {
		int max = nombreCouches + 1; // car Math.random < max
		int min = 0;
		int index = (int) (Math.random() * (max - min) + min);
		Coordonne coordonneSortie = cases.get(index).getCoordonne();
		cases.set(index, new Sortie(coordonneSortie));
	}

	/**
	 * Methode qui nettoie les cases lave qui sont isolees (entournees que par
	 * du sol)
	 */
	private void nettoyerTableau() {
		for (int i = 0; i < cases.size(); i++) {
			Case uneCase = cases.get(i);
			if (uneCase.getType() == "lave"
					&& laveEntourneeParSol(uneCase.getCoordonne())) {
				cases.set(i, new Sol(uneCase.getCoordonne()));
				compteurLave--;
			}
		}
	}

	/**
	 * Methode qui verifie si la case fait partie du bord gauche du tableau
	 * 
	 * @param c
	 *            coordonne de la case
	 * @return vrai si def de la methode
	 */
	private boolean estBordGauche(Coordonne c) {
		if (c.getZ() == nombreCouches || c.getY() == -nombreCouches) {
			return true;
		}
		return false;
	}

	/**
	 * Methode qui verifie si la case fait partie du bord droit du tableau
	 * 
	 * @param c
	 *            coordonne de la case
	 * @return vrai si def de la methode
	 */
	private boolean estBordDroit(Coordonne c) {
		if (c.getZ() == -nombreCouches || c.getY() == nombreCouches) {
			return true;
		}
		return false;
	}

	/**
	 * Methode qui verifie si la case, si lave, est completement entournee par
	 * des cases sol
	 * 
	 * @param c
	 *            coordonee de la case a verifier
	 * @return true si la case est entournee par des cases type sol
	 */
	private boolean laveEntourneeParSol(Coordonne c) {
		if (getCaseParCoordonne(c).getType() == "lave") {
			Coordonne[] coordonnesAutour = {
					new Coordonne(c.getX(), c.getY() - 1, c.getZ() + 1),
					new Coordonne(c.getX() + 1, c.getY(), c.getZ() + 1),
					new Coordonne(c.getX() + 1, c.getY() + 1, c.getZ()),
					new Coordonne(c.getX(), c.getY() + 1, c.getZ() - 1),
					new Coordonne(c.getX() - 1, c.getY(), c.getZ() - 1),
					new Coordonne(c.getX() - 1, c.getY() - 1, c.getZ() - 1) };

			for (int i = 0; i < coordonnesAutour.length; i++) {
				if (caseExiste(coordonnesAutour[i])) {
					Case caseAVerifier = getCaseParCoordonne(coordonnesAutour[i]);
					if (caseAVerifier.getType() == "lave") {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Methode qui verifie si il y a au moins une case type lave au tour
	 * 
	 * @param c
	 *            coordonee de la case a verifier
	 * @return true si on trouve au moins une case type lave au tour
	 */
	private boolean existeLaveAutour(Coordonne c) {
		Coordonne[] coordonnesAutour = {
				new Coordonne(c.getX(), c.getY() - 1, c.getZ() + 1),
				new Coordonne(c.getX() + 1, c.getY(), c.getZ() + 1),
				new Coordonne(c.getX() + 1, c.getY() + 1, c.getZ()) };

		for (int i = 0; i < coordonnesAutour.length; i++) {
			if (caseExiste(coordonnesAutour[i])) {
				Case caseAVerifier = getCaseParCoordonne(coordonnesAutour[i]);
				if (caseAVerifier.getType() == "lave") {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Methode qui verifie si la case existe
	 * 
	 * @param c
	 *            Coordonee de la case recherchee
	 * @return true si la case existe
	 */
	private boolean caseExiste(Coordonne c) {
		if (getCaseParCoordonne(c) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Methode qui recherche si le tableau a un chemin existant, sinon il
	 * reinitialize le tableau (ou cree un chemin)
	 */
	private void rechercheDeChemin() {
		Vector<Lave> laves = getLaves();
		
		System.out.print("existeDeuxCotes: ");
		System.out.println(existeLaveDesDeuxCotes(laves));
		
		if (!existeLaveDesDeuxCotes(laves)) {
			return;
		}
		for (int i = 0; i < laves.size(); i++) {
			Coordonne c = laves.get(i).getCoordonne();
			if (estBordGauche(c)) {
				if (laveBloque(laves.get(i), laves)) {
					System.out.println("BLOQUEIAAA");
//					reinitializerTableau();
				}
			}
		}
	}

	/**
	 * Methode qui verifie si la lave traverse le tableau en blocant les chemins
	 * possibles de passage
	 * 
	 * @param laves
	 *            vector avec toutes les laves du tableau
	 * @return vrai si lave traverse le tableau en blocant
	 */
	private boolean laveBloque(Lave lave, Vector<Lave> laves) {
		boolean bloque = true;
		laves.remove(lave);
		if(laves.size()>0){
			for (int i = 0; i < laves.size(); i++) {
				if(estLaveVoisin(lave.getCoordonne(), laves.get(i))){
					Coordonne c = laves.get(i).getCoordonne();
					if(estBordDroit(c)){
						bloque = true;
						break;
					}
					bloque = laveBloque(lave, laves);
				}
			}
		}else{
			bloque = false;
		}
		return bloque;
	}

	/**
	 * Methode qui verifie si la lave est voisine de la case actuelle
	 * 
	 * @param coordonne coordonne de la case actuelle
	 * @param lave lave a verifier
	 * @return vrai si lave voisine
	 */
	private boolean estLaveVoisin(Coordonne c, Lave lave) {
		Coordonne cLave = lave.getCoordonne();
		Coordonne[] coordonnesAutour = {
				new Coordonne(c.getX(), c.getY() - 1, c.getZ() + 1),
				new Coordonne(c.getX() + 1, c.getY(), c.getZ() + 1),
				new Coordonne(c.getX() + 1, c.getY() + 1, c.getZ()),
				new Coordonne(c.getX(), c.getY() + 1, c.getZ() - 1),
				new Coordonne(c.getX() - 1, c.getY(), c.getZ() - 1),
				new Coordonne(c.getX() - 1, c.getY() - 1, c.getZ() - 1) };

		for (int i = 0; i < coordonnesAutour.length; i++) {
			if (caseExiste(coordonnesAutour[i]) && cLave == coordonnesAutour[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifie s'il exite au moins une lave de chaque un des cotes
	 * 
	 * @param vector
	 *            avec toutes les cases laves du tableau
	 * @return boolean qui verifie la definition
	 */
	private boolean existeLaveDesDeuxCotes(Vector<Lave> laves) {
		boolean gauche = false;
		boolean droit = false;
		for (int i = 0; i < laves.size(); i++) {
			Coordonne c = laves.get(i).getCoordonne();
			if(estBordGauche(c)){
				gauche = true;
			}else if(estBordDroit(c)){
				droit = true;
			}
			if (gauche && droit)
				return true;
		}
		return false;
	}

	/**
	 * Liste toutes les cases avec leur type et leur coordonee
	 */
	public void listerCases() {
		for (int i = 0; i < cases.size(); i++) {
			Case c = cases.get(i);

			if (c instanceof Lave) {
				System.out.println(c.getType() + " : "
						+ c.getCoordonne().toString());
			} else if (c instanceof Sol) {
				System.out.println(c.getType() + " : "
						+ c.getCoordonne().toString());
			}
		}
	}

	/**
	 * Methode qui calcule le nombre de cases du tableau en prennant en compte
	 * le nombre de couches
	 * 
	 * @return le nombre de cases
	 */
	private int nbCasesDuTableau() {
		int nbCases = 1;
		for (int i = 0; i <= nombreCouches; i++) {
			nbCases += i * 6;
		}
		return nbCases;
	}

	/**
	 * @return le nombre de couches du tableau
	 */
	public int getNbCouches() {
		return nombreCouches;
	}

	/**
	 * @return le vector avec les cases du tableau
	 */
	public Vector<Case> getCases() {
		return cases;
	}

	/**
	 * Methode qui cherche la case en prennant en compte ses coordonees
	 * 
	 * @param c
	 *            coordonee de case recherchee
	 * @return la case avec les coordonees c, si pas trouvee on retourne null
	 */
	private Case getCaseParCoordonne(Coordonne c) {
		for (int i = 0; i < cases.size(); i++) {
			if (cases.get(i).getCoordonne().equals(c))
				return cases.get(i);
		}
		return null;
	}

	/**
	 * Methode qui retourne la liste des laves du tableau
	 * 
	 * @return vector contenant les laves du tableau
	 */
	private Vector<Lave> getLaves() {
		Vector<Lave> laves = new Vector<Lave>();

		for (int i = 0; i < cases.size(); i++) {
			if (cases.get(i).getType() == "lave") {
				laves.add((Lave) cases.get(i));
			}
		}
		return laves;
	}

	/**
	 * Methode qui vide le Tableau actuel et le recalcule
	 */
	private void reinitializerTableau() {
		cases.clear();
		creerTableau();
	}

	/**
	 * Methode de creation d'une case type sol
	 * 
	 * @param c
	 *            coordonee de la case a etre cree
	 */
	private void creerSol(Coordonne c) {
		Sol s = new Sol(c);
		cases.add(s);
	}

	/**
	 * Methode de creation d'une case type lave
	 * 
	 * @param c
	 *            coordonee de la case a etre cree
	 */
	private void creerLave(Coordonne c) {
		Lave l = new Lave(c);
		cases.add(l);
	}

}
