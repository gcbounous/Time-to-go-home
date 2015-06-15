package Model;

import java.util.Map;

/**
 * Created by gabrielcae
 */
public class TimeToGoHome{
    Map<double, Level> tousLesLevels = new Map<>();

    public TimeToGoHome(){
        Level level1 = new Level();
        tousLesLevels.put(1, level1);
    }
}
