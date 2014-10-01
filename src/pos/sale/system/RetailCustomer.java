package pos.sale.system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class represents a simulation of a Retail Customer in a retail sales
 * Organization.
 *
 *
 * @author emanion
 * @version 09/30/2014
 *
 */
public class RetailCustomer implements CustomerStrategy {

    private int id;
    private String name;
    private Address address;
    private int minCustomerId = 1;

    @Override
    public int getId() {
        return id;
    }

    /**
     * Constructor for new RetailCustomer object.
     *
     * @param id
     * @param name
     * @param address
     * @throws IllegalArgumentException
     */
    public RetailCustomer(int id, String name, Address address) {

        setId(id);
        setName(name);
        setAddress(address);
    }

    public RetailCustomer() {
    }

    /**
     * Set customerId
     *
     * @param id
     * @throws IllegalArgumentException
     */
    public void setId(int id) {
        if (id < minCustomerId) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * set Customer Name
     *
     * @param name
     * @throws IllegalArgumentException
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * sets address object for this customer
     *
     * @param address
     * @throws IllegalArgumentException
     *
     */
    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException();
        }
        this.address = address;
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
