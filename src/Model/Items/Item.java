package Model.Items;

import Model.Case;

import java.util.Vector;

public abstract class Item {

    static int ID = 0;
    final String nom;

    public Item(){
        ID = -1;
        nom = "vide";
    }

    public Item(String nom){
        this.nom = nom;
        ID++;
    }

    public int getID(){
        return ID;
    }

    public String getNom(){
        return nom;
    }

    @Override
    public String toString(){
        return "Item{" +
               "Id= " + ID +","+
               "nom= " + nom +
               '}';
    }

    abstract public Vector<Case> attaquer();
}
