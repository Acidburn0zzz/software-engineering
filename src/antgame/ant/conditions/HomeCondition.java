package antgame.ant.conditions;

import antgame.ant.markers.Marker;
import antgame.world.worldTokens.TerrainToken;
import antgame.ant.color.Color;

/**
 *
 * @author ItsTheRai
 */
public class HomeCondition  implements Condition{

    @Override
    public boolean checkCondition(TerrainToken token, Color color, Marker m) {
        if(token.isAnthill()){
            return token.getAnthillColor()==color;
        }
        else return false;
    }
}
