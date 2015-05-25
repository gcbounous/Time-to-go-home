package VueConsole;

import java.util.Vector;

import Model.Coordonne;
import Model.Sol;

public class TableauConsole {

	public TableauConsole(int nbCouches, Vector<String> types, Vector<Coordonne> coordonnes){
		dessinerTableau(nbCouches, types, coordonnes);
	}
	
	private void dessinerTableau(int nbCouches, Vector<String> types, Vector<Coordonne> coordonnes){
		int ligneActuelle = nbCouches;
		int cpt=0;
		String tableau ="";
		while(ligneActuelle>=-nbCouches){

			for (int i = 0; i < Math.abs(ligneActuelle); i++) {
				tableau+=" ";				
			}			
			//Contruction d'une ligne du tableau
			for(int i=0; i<(2*nbCouches+1)- Math.abs(ligneActuelle); i++, cpt++){
				switch(types.get(cpt)){
				case "lave":
					tableau+="~ ";
					break;
				case "sol":
					tableau+=". ";
					break;
				case "sortie":
					tableau+="# ";
					break;
				default:
					break;	
				}				
			}
			tableau+="\n";
			ligneActuelle--;
		}
		System.out.println(tableau);
	}
	
	private void listerTableau(Vector<String> types, Vector<Coordonne> coordonnes){
		String tableau ="";
		tableau +=" _______ \n";
		for(int i=0; i<types.size(); i++){			
			if(types.get(i) == "sol"){
				tableau +="/  "+types.get(i)+"  \\ \n";
			} else {
				tableau +="/  "+types.get(i)+" \\ \n";
			}
			if(i<10){
				tableau +="("+coordonnes.get(i).getX()+","+coordonnes.get(i).getY()+","+coordonnes.get(i).getZ()+")\n";
			} else{
				tableau +="("+coordonnes.get(i).getX()+","+coordonnes.get(i).getY()+","+coordonnes.get(i).getZ()+")\n";
			}
			tableau +="\\_______/ \n";
		}
		System.out.println(tableau);
	}
}
