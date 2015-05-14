package Model;

import java.util.Vector;

public class Chemin {
	Coordonne coordonneInit;
	Coordonne coordonneFin;
	//TODO: cases du chemin ou cases du tableau (ou on a besoin des deux?)
	Vector<Case> cases = new Vector();
	
	public Chemin(){
		
	}
	
	//TODO: Voir si besoin de la creation d'un graphe
	public Chemin(Coordonne cInit, Coordonne cFin){
		coordonneInit = cInit;
		coordonneFin = cFin;		
	}
	
	private void calculerChemin(){
		//TODO: reflechir comment en faire
	}

}
