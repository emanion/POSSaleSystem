/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.sale.system;

import java.text.NumberFormat;

/**
 *
 * @author emanion
 */
public class LineItem {

    private int quantity;
    private Product product;
    private double discount;
    private double extendedPrice;

    public LineItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDiscount() {
        discount = product.getDiscountAmount(quantity);
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getExtendedPrice() {
        extendedPrice = (product.getUnitPrice() * quantity)
                - product.getDiscountAmount(quantity);

        return extendedPrice;

    }

    public String getFormatedDetailLine() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        return product.getId() + "          "
                + product.getDescription() + "           "
                + nf.format(product.getUnitPrice()) + "      "
                + quantity + "      "
                + nf.format(getDiscount()) + "     "
                + nf.format(getExtendedPrice()) + "\n";

    }

    @Override
    public String toString() {
        return "LineItem{" + "quantity=" + quantity
                + ", product=" + product + ", discount=" + discount
                + ", extendedPrice=" + extendedPrice + '}';
    }

}
