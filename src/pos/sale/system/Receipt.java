package pos.sale.system;

/**
 *
 * This class represents a simulation of a receipt in a retail sales
 * Organization.
 *
 *
 * @author emanion
 * @version 10/01/2014
 */
public class Receipt {

    private CustomerStrategy customerStrategy;
    private InvoiceLineHeader invoiceLineHeader;
    private LineItem[] lineItems;
    private ReceiptTotal receiptTotal;
    private int minCustomerId = 0;
    private int minLineItemsLength = 0;

    /**
     * constructor for receipt object. Full constructor with customer
     * instantiation and first line item.
     *
     * @param dbStrategy
     * @param customerId
     * @param invoiceLineHeader
     * @param lineItems
     * @param receiptTotal
     * @throws IllegalArgumentException
     */
    public Receipt(DbStrategy dbStrategy, int customerId,
            InvoiceLineHeader invoiceLineHeader,
            LineItem[] lineItems, ReceiptTotal receiptTotal) {
        if (dbStrategy == null) {
            throw new IllegalArgumentException();
        }
        if (customerId < minCustomerId) {
            throw new IllegalArgumentException();
        }
        if (invoiceLineHeader == null) {
            throw new IllegalArgumentException();
        }
        if (lineItems.length < minLineItemsLength) {
            throw new IllegalArgumentException();
        }
        if (receiptTotal == null) {
            throw new IllegalArgumentException();
        }

        this.customerStrategy = dbStrategy.getCustomerById(customerId);
        this.invoiceLineHeader = invoiceLineHeader;
        this.lineItems = lineItems;
        this.receiptTotal = receiptTotal;
    }

    /**
     * constructor for receipt - customer instantiation
     *
     * @param dbStrategy
     * @param customerId
     * @throws IllegalArgumentException();
     */
    public Receipt(DbStrategy dbStrategy, int customerId) {
        if (dbStrategy == null) {
            throw new IllegalArgumentException();
        }
        if (customerId < minCustomerId) {
            throw new IllegalArgumentException();
        }

        this.customerStrategy = dbStrategy.getCustomerById(customerId);
        this.invoiceLineHeader = new InvoiceLineHeader();
        this.lineItems = new LineItem[0];
        this.receiptTotal = new ReceiptTotal();
    }

    /**
     * constructor for receipt - no arguments.
     */
    public Receipt() {
        customerStrategy = new RetailCustomer();
        invoiceLineHeader = new InvoiceLineHeader();
        this.lineItems = new LineItem[0];
        receiptTotal = new ReceiptTotal();
    }

    /**
     * returns the customer object for this receipt.
     *
     * @return
     */
    public CustomerStrategy getCustomer() {
        return customerStrategy;
    }

    /**
     * Sets the customer object for this receipt.
     *
     * @param customer
     * @throws IllegalArgumentException
     */
    public void setCustomer(CustomerStrategy customer) {
        if (customer == null) {
            throw new IllegalArgumentException();
        }
        this.customerStrategy = customer;
    }

    public InvoiceLineHeader getInvoiceLineHeader() {
        return invoiceLineHeader;
    }

    public void setInvoiceLineHeader(InvoiceLineHeader invoiceLineHeader) {
        this.invoiceLineHeader = invoiceLineHeader;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }

    public ReceiptTotal getReceiptTotal() {
        return receiptTotal;
    }

    public void setReceiptTotal(ReceiptTotal receiptTotal) {
        this.receiptTotal = receiptTotal;
    }

    public void addLineItem(DbStrategy dbStrategy, int productId, int quantity) {

        /* The following logic will create a new array that is 1 slot
         larger than the original
         */
        //increase array size by 1, and add a new lineItem.
        //create new temp array of 1 position bigger than old
        LineItem[] lineItemsTemp = new LineItem[lineItems.length + 1];

        // copy contents of original array
        int x;
        for (x = 0; x < lineItems.length; x++) {
            lineItemsTemp[x] = lineItems[x];
        }

        /* The following logic will load the NEW SLOT with a new lineitem 
         object
         */
        //add new line item,  but remember reference is from 0.
        //  (i.e. the first position = 0 as reference, and so on.
        lineItemsTemp[x] = new LineItem(quantity, dbStrategy.getProductById(productId));

        // set original array = new temp
        lineItems = lineItemsTemp;

    }

    public String getReceiptCustomerSection() {
        return "\n\n ============ NEW RECEIPT =========== \n"
                + customerStrategy.getFormatedReceiptCustomerSection();
    }

    public String getReceiptDetailHeaderSection() {
        return invoiceLineHeader.toString();
    }

    public String getReceiptDetailSection() {
        String receiptPrintedDetail = "\n";

        for (int x = 0; x < lineItems.length; x++) {
            receiptPrintedDetail = receiptPrintedDetail
                    + lineItems[x].getFormatedDetailLine();
        }

        return receiptPrintedDetail;

    }

    public String getReceiptTotalSection() {
        return "\n" + receiptTotal.getPrintedTotalLine(lineItems)
                + "\n  ========== END RECEIPT =============== \n";
    }

}
