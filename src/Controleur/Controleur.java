package Controleur;

import java.util.Vector;

import Model.Case;
import Model.Coordonne;
import Model.Level;
import Model.Tableau;

public class Controleur {
	private final int NBCOUCHES = 6;
	private Tableau tableauDeJeu;
	private Level level = new Level();

	/**
	 *
	 */
	public Controleur(){
		this.tableauDeJeu = level.getTableau();
//		this.tableauDeJeu = new Tableau(NBCOUCHES);
	}

	/**
	 *
	 * @return
	 */
	public Vector<String> getTypeCases(){
		Vector<String> types = new Vector<String>();
		for (Case c : tableauDeJeu.getCases()) {
			types.add(c.getType());
		}
		return types;
	}

	/**
	 *
	 * @return
	 */
	public Vector<Coordonne> getCoordonnesCases(){
		Vector<Coordonne> coordonnes = new Vector<Coordonne>();
		for (Case c : tableauDeJeu.getCases()) {
			coordonnes.add(c.getCoordonne());
		}
		return coordonnes;
	}

	/**
	 *
	 * @return
	 */
	public int getNbCouches(){
		return NBCOUCHES;
	}

}
