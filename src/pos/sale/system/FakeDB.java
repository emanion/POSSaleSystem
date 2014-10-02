
package pos.sale.system;

/**
 *
 * @author emanion
 */
public class FakeDB implements DbStrategy {

    CustomerStrategy[] customers;
    Product[] products;

    public FakeDB() {

        // instantiate and initialize the customer DB 
        customers = new RetailCustomer[3];

        Address addressOne = new Address("103 Elm Street", "unit 4",
                "CityOne", "FL", 55321);
        RetailCustomer customerOne = new RetailCustomer(111, "Donald Duck",
                addressOne);
        customers[0] = customerOne;

        Address addressTwo = new Address("222 Cross Street", "Apt 9",
                "Anywhere", "KS", 38373);
        RetailCustomer customerTwo = new RetailCustomer(222, "Sinbad the Sailor", addressTwo);
        customers[1] = customerTwo;

        Address addressThree = new Address("333 High Street", "",
                "Someplace", "AL", 34578);
        RetailCustomer customerThree = new RetailCustomer(333, "Jimmy the Greek", addressThree);
        customers[2] = customerThree;

        // instantiate and initialize the product DB 
        products = new Product[5];

        DiscountStrategy qtyDiscountOne = new FlatPctDiscount();
        Product productOne = new Product(3578, "Jeans           ", 45.67, qtyDiscountOne);
        products[0] = productOne;

        DiscountStrategy qtyDiscountTwo = new FlatPctDiscount();
        Product productTwo = new Product(3762, "White Dress Shirt", 30.35, qtyDiscountTwo);
        products[1] = productTwo;

        DiscountStrategy qtyDiscountThree = new QuantityDiscount();
        Product productThree = new Product(2827, "Dress socks     ", 12.87, qtyDiscountThree);
        products[2] = productThree;

        DiscountStrategy qtyDiscountFour = new QuantityDiscount();
        Product productFour = new Product(4487, "T Shirt Pack    ", 39.58, qtyDiscountFour);
        products[3] = productFour;

        DiscountStrategy qtyDiscountFive = new QuantityDiscount();
        Product productFive = new Product(9313, "Wisconsin Shirt ", 97.53, qtyDiscountFive);
        products[4] = productFive;

    }
    public CustomerStrategy getCustomerById(int CustomerId) {
        CustomerStrategy customer = new RetailCustomer();

        for (int x = 0; x < customers.length; x++) {
            if (CustomerId == customers[x].getId()) {
                customer = customers[x];
            }
        }

        return customer;
    }
    public Product getProductById(int ProductId) {
        Product product = new Product();

        for (int x = 0; x < products.length; x++) {
            if (ProductId == products[x].getId()) {
                product = products[x];
            }
        }

        return product;
    }

}
