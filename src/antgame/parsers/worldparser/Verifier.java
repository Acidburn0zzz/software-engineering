/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.parsers.worldparser;

import java.util.List;

/**
 *
 * @author rg293
 */
public interface Verifier {
    public World verify(List<Token> world,WorldRequirements requirements);
}
