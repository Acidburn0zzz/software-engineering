package antgame.world.requirements;

import antgame.model.World;
import antgame.world.worldTokens.RockToken;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.Token;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class RequirementBorder implements CheckRequirement{
    private static Token borderToken = new RockToken(null);
    private static int borderSize;

    
    public RequirementBorder(int borderSize){
        this.borderSize = borderSize;
    }
    @Override
    public boolean checkRequirements(World world){
        boolean match = true;
        int i =0;
        while(match && i<world.getWorldTokens().size()){
            if(     //check left column  
                    i%world.getWidth()<borderSize
                    //check right column
                    ||i%world.getWidth()>world.getWidth()-borderSize - 1
                    //check top row
                    ||i/world.getWidth()<borderSize
                    //check bottom row
                    ||i/world.getWidth()>world.getWidth()-borderSize - 1
                    ){
                if(!(world.getWorldTokens().get(i)  instanceof RockToken)||world.getWorldTokens().get(i) instanceof TerrainToken &&!((TerrainToken)world.getWorldTokens().get(i)).isRocky()){
                    return false;
                }
            }
            i++;
        }
        return match;
    }
}