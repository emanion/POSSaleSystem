package pos.sale.system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emanion
 */
public class RetailCustomer implements CustomerStrategy {

    private int id;
    private String name;
    private Address address;

    @Override
    public int getId() {
        return id;
    }

    public RetailCustomer(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public RetailCustomer() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFormatedReceiptCustomerSection() {
        return "Sold To:"
                + "\n" + name + " " + id
                + "\n" + address.getAddressLine1()
                + "\n" + address.getAddressLine2()
                + "\n" + address.getCity()
                + ", " + address.getState()
                + "  " + address.getZip();
    }

}
