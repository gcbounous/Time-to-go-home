package Lanceur;

import java.io.ObjectInputStream.GetField;
import java.util.Vector;

import Controleur.Controleur;
import Model.Coordonne;
import VueConsole.TableauConsole;

public class MainConsole {

	public static void main(String[] args) {
		Controleur ctrl = new Controleur();
		TableauConsole console = new TableauConsole(ctrl.getNbCouches(), ctrl.getTypeCases(), ctrl.getCoordonnesCases());
	}
	
}
