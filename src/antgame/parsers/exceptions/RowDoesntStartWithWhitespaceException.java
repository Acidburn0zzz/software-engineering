/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.exceptions;

/**
 *
 * @author Main User
 */
public class RowDoesntStartWithWhitespaceException extends Exception{

    public RowDoesntStartWithWhitespaceException(String message) {
        super(message);
    }
    
}