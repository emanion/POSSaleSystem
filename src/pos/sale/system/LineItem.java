/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.sale.system;

import java.text.NumberFormat;

/**
 *
 * This class represents a simulation of a line item in a retail sales
 * Organization.
 *
 *
 * @author emanion
 * @version 09/29/2014
 */
public class LineItem {

    private int quantity;
    private Product product;
    private double discount;
    private double extendedPrice;
    private int minLineItemQuantity = 0;

    /**
     *
     * @param quantity
     * @param product
     * @throws IllegalArgumentException
     */
    public LineItem(int quantity, Product product) {
        setQuantity(quantity);
        setProduct(product);
    }

    /**
     * returns quantity purchased.
     *
     * @return - line item quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * set the line item quantity.
     *
     * @param quantity
     * @throws IllegalArgumentException
     */
    public void setQuantity(int quantity) {
        if (quantity < minLineItemQuantity) {
            throw new IllegalArgumentException();
        }
        this.quantity = quantity;
    }

    /**
     * returns the product object for this line item
     *
     * @return Product object
     */
    public Product getProduct() {
        return product;
    }

    /**
     * set the product class for this line item.
     *
     * @param product
     * @throws IllegalArgumentException
     */
    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        this.product = product;
    }

    /**
     * use the discount object for the product to get calculated discount amount
     *
     * @return - discount amount.
     */
    public double getDiscount() {
        discount = product.getDiscountAmount(quantity);
        return discount;
    }

    /**
     * return calculated extended price - with discount amount factored in.
     *
     * @return - line item extended price after discount.
     */
    public double getExtendedPrice() {
        extendedPrice = (product.getUnitPrice() * quantity)
                - product.getDiscountAmount(quantity);

        return extendedPrice;

    }

    /**
     * return line item formatted detail line. - to be used on receipt.
     *
     * @return - a formatted detail line.
     */
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
