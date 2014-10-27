package pos.sale.system;

/**
 *
 * @author emanion
 */
public class Register {

    private DbStrategy dbStrategy;
    private Receipt receipt;

    public Register() {
        //get Cutomer and Product databases
        dbStrategy = new FakeDB();
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void startNewSale(int customerId) {
        // instantiate Receipt object which will look up the customer
        receipt = new Receipt(dbStrategy, customerId);

    }

    public void addLineItem(int productId, int quantity) 
        throws InvalidIdException, CantAddLineException {
        receipt.addLineItem(dbStrategy, productId, quantity);
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
