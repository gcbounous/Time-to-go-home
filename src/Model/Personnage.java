package Model;

import java.util.Vector;

/**
 * Classe qui definie un personnage
 */
public abstract class Personnage {
	Case caseActuelle;

	/**
	 * Constructeur d'un personnage
	 * @param c caseActuelle du personnage
	 */
	public Personnage(Case c){
		this.caseActuelle = c;
	}

	/**
	 * Methode qui prevoit le deplacement au tour de la case actuelle
	 * @param nouvelleCase la nouvelle case a se deplacer
	 * @return vrai si la case est au tour et est "deplaceable"
	 */
	public boolean deplacementBasique(Case nouvelleCase){
		if(caseActuelle.aPourCaseVoisine(nouvelleCase)){
			setCaseActuelle(nouvelleCase);
			return true;
		}else{
			return false;
			/*TODO
			 * voir plus court chemin entre la caseActuelle et la nouvelleCase
			 * voir ou mettre cette methode
			 */
		}
	}

	/**
	 * Getter de la case actuelle
	 * @return la caseActuelle
	 */
	public Case getCaseActuelle() {
		return caseActuelle;
	}

	/**
	 * Setter de la caseActuelle
	 * @param caseActuelle nouvelle case du personnage
	 */
	private void setCaseActuelle(Case caseActuelle) {
		this.caseActuelle = caseActuelle;
	}

	/**
	 * Methode qui calcule les cases ateignables par l'attaque
	 * @return un vecteur de cases "attacables"
	 */
	public abstract Vector<Coordonne> attaquer();
}
