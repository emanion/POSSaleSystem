
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
        int productIndex = 0;

        DiscountStrategy qtyDiscountOne = new FlatPctDiscount();
        Product productOne = new Product(3578, "Jeans           ", 45.67, qtyDiscountOne);
        products[productIndex] = productOne;
        productIndex++;

        DiscountStrategy qtyDiscountTwo = new FlatPctDiscount();
        Product productTwo = new Product(3762, "White Dress Shirt", 30.35, qtyDiscountTwo);
        products[productIndex] = productTwo;
        productIndex++;

        DiscountStrategy qtyDiscountThree = new QuantityDiscount();
        Product productThree = new Product(2827, "Dress socks     ", 12.87, qtyDiscountThree);
        products[productIndex] = productThree;
        productIndex++;

        DiscountStrategy qtyDiscountFour = new QuantityDiscount();
        try {
            Product productFour = new Product(4487, "T Shirt Pack    ", 39.58, qtyDiscountFour);
            products[productIndex] = productFour;
            productIndex++;
        } catch (InvalidIdException iie){
            System.out.println("Can't set up product: " + iie.getMessage());
        }
        
        DiscountStrategy qtyDiscountFive = new QuantityDiscount();
        Product productFive = new Product(9313, "Wisconsin Shirt ", 97.53, qtyDiscountFive);
        products[productIndex] = productFive;
        productIndex++;

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

        String foundResult = "notfound";
        for (int x = 0; x < products.length; x++) {
            if (products[x] == null)
                break;
            if (ProductId == products[x].getId()) {
                product = products[x];
                foundResult = "found";
                break;
            }
        }
        
        if (foundResult == "notfound") {
                throw new InvalidIdException();
        }

        return product;
    }

}
