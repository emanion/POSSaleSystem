/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.sale.system;

/**
 * This class represents a simulation of a product in a retail sales
 * Organization.
 *
 * @author emanion
 * @version 09/29/2014
 *
 */
public class Product {

    private int id;
    private String description;
    private double unitPrice;
    private DiscountStrategy discount;
    private int minId = 0;
    private double minUnitPrice = 0.01;
    private double minQuantityPurchased = 1;

    /**
     *
     * @param id - product id
     * @param description - product description
     * @param unitPrice - product unit price
     * @param discount - product DiscountStrategy object.
     *
     */
    public Product(int id, String description, double unitPrice,
            DiscountStrategy discount) {
        this.id = id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.discount = discount;
                
    }

    public Product() {
    }

    /**
     * gets the id, which is the unique primary key of this item. There is no
     * validation.
     *
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id, which is unique primary key of this item.
     *
     * @throws IllegalArgumentException.
     * @param id - the unique identifier for this product.
     */
    public void setId(int id) {
        if (id < minId) {
            throw new IllegalArgumentException();
        }

        this.id = id;
    }

    /**
     * gets the product description.
     *
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the product description.
     *
     * @throws IllegalArgumentException.
     * @param description
     */
    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    /**
     * 
     * @return unitPrice - price per unit for this product.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Updates unitPrice - price per unit for this product.
     * @throws IllegalArgumentException
     * @param unitPrice 
     */
    public void setUnitPrice(double unitPrice) {
        if (unitPrice < minUnitPrice)
            throw new IllegalArgumentException();
        this.unitPrice = unitPrice;
    }

    /**
     * gets the returnStrategy object for this product.
     * @return discountStrategy object.
     */
    public DiscountStrategy getDiscount() {
        return discount;
    }

    /**
     * Uses the DiscountStrategy interface to calculate the discount amount.
     * @throws IllegalArgumentException.
     * @param quantityPurchased - amount customer purchased.
     * @return - discount amount.
     */
    public double getDiscountAmount(int quantityPurchased) {
        if (quantityPurchased < minQuantityPurchased)
            throw new IllegalArgumentException();
        return discount.getDiscountAmount(unitPrice, quantityPurchased);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id
                + ", description=" + description
                + ", unitPrice=" + unitPrice;
    }

}
