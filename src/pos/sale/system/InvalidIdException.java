/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.sale.system;

/**
 *
 * @author emanion
 */
public class InvalidIdException extends IllegalArgumentException {
    
    private static String msg = "Invalid Product ID";

    public InvalidIdException() {
    }

    public InvalidIdException(String s) {
        super(msg);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(msg, cause);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }
    
    
    
}
