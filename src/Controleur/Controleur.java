package Controleur;

import java.util.Vector;

import Model.Case;
import Model.Coordonne;
import Model.Tableau;

public class Controleur {
	private final int NBCOUCHES = 6;
	private Tableau tableauDeJeu;
	
	public Controleur(){
		this.tableauDeJeu = new Tableau(NBCOUCHES);
	}
	
	public Vector<String> getTypeCases(){
		Vector<String> types = new Vector<String>();
		for (Case c : tableauDeJeu.getCases()) {
			types.add(c.getType());
		}
		return types;
	}
	
	public Vector<Coordonne> getCoordonnesCases(){
		Vector<Coordonne> coordonnes = new Vector<Coordonne>();
		for (Case c : tableauDeJeu.getCases()) {
			coordonnes.add(c.getCoordonne());
		}
		return coordonnes;
	}
	
	public int getNbCouches(){
		return NBCOUCHES;
	}

}
