package antgame.ant.instructions;

import antgame.ant.conditions.Condition;
import antgame.ant.direction.sensedireciton.Direction;
import antgame.ant.markers.Marker;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionSense extends InstructionSet implements Instruction{
    private final int state1;
    private final int state2;
    Direction sensedirection;
    Condition condition;
    Marker marker;

    /**
     *
     * @param state1 state the ant is to be put in if the Condition holds
     * @param state2 state the ant is to be put in if the Condition does not hold
     * @param sensedirection the Direction the nearest TerrainToken is sensed in
     * @param condition a Condition object that represents the condition to be met
     * @param marker a Marker object used to sense markers
     */
    public InstructionSense(int state1, int state2, Direction sensedirection, Condition condition, Marker marker) {
        this.state1 = state1;
        this.state2 = state2;
        this.sensedirection = sensedirection;
        this.condition = condition;
        this.marker = marker;
    }
    
    @Override
    public void executeInstruction(Ant ant){
            //Go to state state1 if cond holds in sensedirection;
            //and to state state2 otherwise
        if (condition.checkCondition(ant.senseTile(sensedirection),ant.getColour(),marker)){              
            ant.setState(state1);
        }
        else ant.setState(state2);
        
    }

    public int getState1(){
        return state1;
    }
    
    public int getState2() {
        return state2;
    }

    public Direction getSensedirection() {
        return sensedirection;
    }

    public Condition getCondition() {
        return condition;
    }
}
