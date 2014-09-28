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
public class Product {

    private int id;
    private String description;
    private double unitPrice;
    private DiscountStrategy discount;

    public Product(int id, String description, double unitPrice,
            DiscountStrategy discount) {
        this.id = id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscountAmount(QuantityDiscount discount) {
        this.discount = discount;
    }
    
    public double getDiscountAmount(int quantityPurchased){
        return discount.getDiscountAmount(unitPrice, quantityPurchased);
    }


    @Override
    public String toString() {
        return "Product{" + "id=" + id
                + ", description=" + description
                + ", unitPrice=" + unitPrice;
    }

}
