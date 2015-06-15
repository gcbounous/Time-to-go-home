package Model.Objets;

import Model.Case;
import Model.Coordonne;

import java.util.Vector;

public abstract class Item extends Objet{

    public Item(){
        super("vide");
    }

    public Item(String nom){
        super(nom);
    }

    abstract public Vector<Coordonne> attaquer(Case caseActuelle);
}
