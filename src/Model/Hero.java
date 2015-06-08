package Model;

import Model.Items.Item;

import java.util.Vector;

public class Hero extends Personnage{
    int vieTotale = 3;
    int energieTotale = 3;
    int vie;
    int energie;
    //Mallette mallette = new Mallette;
    Vector<Item> items = new Vector();
    Item itemEnMain = new Item();

    public Hero(Case c){
        super(c);
        this.vie = vieTotale;
        this.energie = energieTotale;
    }

    /*public Vector<Case> casesASauter(){

    }*/

    public void augmenterVieTotale(){
        vieTotale++;
        reinitializerVie();

    }

    public void augmenterEnergieTotale(){
        energieTotale++;
        reinitializerEnergie();

    }

    public Vector<Case> attaquer(){
        Vector<Case> attaquePossible = new Vector();
        return attaquePossible;
    }

    private void reinitializerVie(){
        vie = vieTotale;
    }

    private void reinitializerEnergie(){
        energie = energieTotale;
    }

}
