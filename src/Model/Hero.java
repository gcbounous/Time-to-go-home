package Model;

import Model.Objets.Item;
import Model.Objets.Mallette;

import java.util.Vector;

public class Hero extends Personnage{
    int vieTotale = 3;
    int energieTotale = 3;
    int vie;
    int energie;
    Mallette mallette = new Mallette();
    Vector<Item> items = new Vector();
    Item itemEnMain;

    public Hero(Case c){
        super(c);
        this.vie = vieTotale;
        this.energie = energieTotale;
    }

    public Vector<Case> deplacementSaut(){
        Vector<Case> cases = new Vector<>();
        Vector<Coordonne> coordonnes = new Vector<>();
        coordonnes = caseActuelle.getCoordonne().getCoordonnesCouche(2);
        return cases;
    }

    public Vector<Coordonne> attaquer(){
        Vector<Coordonne> attaquePossible = new Vector();
        attaquePossible = mallette.attaquer(caseActuelle);
        return attaquePossible;
    }

    public Vector<Case> bloquer(Case caseDirection){
        Vector<Case> attaquePossible = new Vector();
        attaquePossible = mallette.bloquer(caseDirection);
        return attaquePossible;
    }

    public Vector<Coordonne> attaquerItem(){
        Vector<Coordonne> attaquePossible = new Vector();
        attaquePossible = itemEnMain.attaquer(caseActuelle);
        return attaquePossible;
    }

    public void changerItemEnMain(Item i){
        itemEnMain = i;
    }

    public void perdreUneVie(){
        vie--;
    }

    public void gagnerUneVie(){ vie++; }

    public void perdreUneEnergie(){
        energie--;
    }

    public void gagnerUneEnergie(){
        energie++;
    }

    public void augmenterVieTotale(){
        vieTotale++;
        reinitializerVie();
    }

    public void augmenterEnergieTotale(){
        energieTotale++;
        reinitializerEnergie();
    }

    public void ajouterItem(Item i){
        items.add(i);
    }

    public void ajouterItemDansMallette(Item i){
        if(mallette.aDeLaPlace()){
            mallette.ajouterItem(i);
        }
    }

    public void enleverItemDeMallette(Item i){
        mallette.enleverItem(i);
    }

    public void changerItemDansMallette(Item itemAncien, Item nouveauItem){
        enleverItemDeMallette(itemAncien);
        ajouterItemDansMallette(nouveauItem);
    }

    public Vector<Item> getItems(){
        return items;
    }

    private void reinitializerVie(){
        vie = vieTotale;
    }

    private void reinitializerEnergie(){
        energie = energieTotale;
    }

}
