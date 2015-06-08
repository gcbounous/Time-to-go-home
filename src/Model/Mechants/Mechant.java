package Model.Mechants;

import Model.Case;
import Model.Personnage;

import java.util.Vector;

public class Mechant extends Personnage {
	Case caseActuelle;

	public Mechant(Case c){
		super(c);
	}

	public Vector<Case> attaquer(){
		Vector<Case> attaquePossible = new Vector();
		return attaquePossible;
	}
}
