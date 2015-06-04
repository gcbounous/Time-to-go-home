package Model;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by gabrielcae on 04/06/15.
 */
public enum Deplacement {
    NO(1,0,1),
    NE(1,1,0),
    SO(-1,-1,0),
    SE(-1,0,-1),
    O(0,-1,+1),
    E(0,1,-1);


    final private int x;
    final private int y;
    final private int z;

    Deplacement(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
