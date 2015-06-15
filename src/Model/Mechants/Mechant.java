package Model.Mechants;

import Model.Case;
import Model.Coordonne;
import Model.Personnage;

import java.util.Vector;

public class Mechant extends Personnage {
	Case caseActuelle;

	public Mechant(Case c){
		super(c);
	}

	public Vector<Coordonne> attaquer(){
		Vector<Coordonne> attaquePossible = new Vector();
		return attaquePossible;
	}
}
