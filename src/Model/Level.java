package Model;

import Model.Mechants.Mechant;

import java.util.Vector;

/**
 * Created by gabrielcae
 */
public class Level{
    final int NB_COUCHES = 6; // il faut que ça devienne un parametre du constructeur
    Tableau tableau = new Tableau(NB_COUCHES);
    Vector<Mechant> mechants;
    Hero hero;

    /*TODO: liste de todo pour Level
     * liste d'objets
     * voir quoi mettre dans le constructeur
     */

    public Level(){

    }

    public Tableau getTableau(){
        return tableau;
    }
}
