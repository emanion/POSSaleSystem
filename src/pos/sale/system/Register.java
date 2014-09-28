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
public class Register {

    private DbStrategy DbStrategy;
    private Receipt receipt;
    private CustomerStrategy customer;
    private Product product;

    public Register() {
        //get Cutomer and Product databases
        DbStrategy = new FakeDB();
        DbStrategy.setCustomerDb();
        DbStrategy.setProductDb();

    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void startNewSale(int customerId) {
        // look up Customer and instantiate Receipt object
        customer = DbStrategy.getCustomerById(customerId);
        receipt = new Receipt(customer);

    }

    public void addLineItem(int productId, int quantity) {

        // look up Product, instantiate Discount, Product, LineItem
        // add to LineItem array in Receipt
        product = DbStrategy.getProductById(productId);

        //  add new lineItem to receipt.
        LineItem lineItem = new LineItem(quantity, product);
        receipt.addLineItem(lineItem);

    }

    public String closeSale() {
        return getPrintedReceipt();

    }

    public String getPrintedReceipt() {
        return "\n\n" 
                + receipt.getReceiptCustomerSection()
                + receipt.getReceiptDetailHeaderSection()
                + receipt.getReceiptDetailSection()
                + receipt.getReceiptTotalSection();
        
        
    }

}
