package Model.Objets;

/**
 * Created by gabrielcae
 */
public class Objet{
    static int ID = 0;
    final String nom;

    public Objet(){
        ID = -1;
        nom = "vide";
    }

    public Objet(String nom){
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
        return "Objet{" +
               "Id= "+ID+","+
               "nom= " + nom +
               '}';
    }
}
