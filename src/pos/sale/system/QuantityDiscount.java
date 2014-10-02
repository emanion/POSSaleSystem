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
    
    private double highDiscountRate = .20;
    private double midDiscountRate = .10;
    private double lowDiscountRate = .05;
    private double noDiscountRate = 0;
    
    public double getDiscountAmount(double price, int quantity) {

        double discount;

        if (quantity > 20) {
            discount = price * highDiscountRate;
        } else if (quantity > 10) {
            discount = price * midDiscountRate;
        } else if (quantity > 1){
            discount = price * lowDiscountRate;
        } else {
            discount = noDiscountRate;
        }

        return discount;

    }


}
