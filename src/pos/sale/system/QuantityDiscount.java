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
public class QuantityDiscount implements DiscountStrategy {
    
    public double getDiscountAmount(double price, int quantity) {

        double discount;

        if (quantity > 20) {
            discount = price * .20;
        } else if (quantity > 10) {
            discount = price * .10;
        } else if (quantity > 1){
            discount = price * .05;
        } else {
            discount = 0;
        }

        return discount;

    }


}
