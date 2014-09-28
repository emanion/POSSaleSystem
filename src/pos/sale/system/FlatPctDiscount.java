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
public class FlatPctDiscount implements DiscountStrategy {
    
    
    @Override
    public double getDiscountAmount(double price, int quantity) {

        double discount = price * .10;
        
        return discount;

    }
    
}
