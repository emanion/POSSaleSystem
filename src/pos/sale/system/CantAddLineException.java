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
public class CantAddLineException extends IllegalArgumentException {
    private static String msg = "Product Id not found, cant add lineItem";

    public CantAddLineException() {
        super(msg);
    }

    public CantAddLineException(String s) {
        super(msg);
    }

    public CantAddLineException(String message, Throwable cause) {
        super(msg, cause);
    }

    public CantAddLineException(Throwable cause) {
        super(cause);
    }
    
    
    
    
}
