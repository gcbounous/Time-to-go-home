package Model.Objets;

import Model.Case;
import Model.Coordonne;

import java.util.Vector;

/**
 * Created by gabrielcae.
 */
public class Mallette extends Item{

    private Item [] items = new Item[4];

    public Mallette(){
        super("Mallette");
    }

    public Vector<Case> bloquer(Case caseDirection){
        Vector<Case> cases = new Vector<>();
        //TODO a voir comment faire
        return cases;
    }

    public Vector<Case> attaquer(Case caseActuelle){
        Vector<Case> cases = new Vector<>();
        //TODO il manque le tableau
        return cases;
    }

    public void enleverItem(Item item){
        for(int i = 0; i < items.length; i++){
            if(items[i] != null && items[i].getID() == item.getID()){
                items[i] = null;
            }
        }
    }

    public void ajouterItem(Item item){
        for(int i = 0; i<items.length; i++){
            if(items[i] == null){
                items[i] = item;
            }
        }
    }

    public void listerItems(){
        for(int i = 0; i < items.length; i++){
            if(items[i] != null){
                System.out.println(items[i].toString());
            }
        }
    }

    public int compterItems(){
        int compteur = 0;
        for(int i = 0; i < items.length; i++){
            if(items[i] != null){
                compteur++;
            }
        }
        return compteur;
    }

    public Item getItemByID(int id){
        for(int i = 0; i < items.length; i++){
            if(items[i] != null && items[i].getID() == id){
                return items[i];
            }
        }
        return null;
    }

    public Item[] getItems(){
        return items;
    }

}