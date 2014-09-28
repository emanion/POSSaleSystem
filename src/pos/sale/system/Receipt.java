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
public class Receipt {

    private CustomerStrategy customerStrategy;
    private InvoiceLineHeader invoiceLineHeader;
    private LineItem[] lineItems;
    private ReceiptTotal receiptTotal;

    public Receipt(CustomerStrategy customer, InvoiceLineHeader invoiceLineHeader,
            LineItem[] lineItems, ReceiptTotal receiptTotal) {
        this.customerStrategy = customer;
        this.invoiceLineHeader = invoiceLineHeader;
        this.lineItems = lineItems;
        this.receiptTotal = receiptTotal;
    }

    public Receipt(CustomerStrategy customer) {
        this.customerStrategy = customer;
        this.invoiceLineHeader = new InvoiceLineHeader();
        this.lineItems = new LineItem[0];
        this.receiptTotal = new ReceiptTotal();
    }

    public Receipt() {
        customerStrategy = new RetailCustomer();
        invoiceLineHeader = new InvoiceLineHeader();
        this.lineItems = new LineItem[0];
        receiptTotal = new ReceiptTotal();
    }

    public CustomerStrategy getCustomer() {
        return customerStrategy;
    }

    public void setCustomer(CustomerStrategy customer) {
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

    public void addLineItem(LineItem lineItem) {
        //increase array size by 1, and add a new lineItem.

        //create new temp array of 1 position bigger than old
        LineItem[] lineItemsTemp = new LineItem[lineItems.length + 1];

        // copy contents of original array
        int x;
        for (x = 0; x < lineItems.length; x++) {
            lineItemsTemp[x] = lineItems[x];
        }

        //add new line item,  but remember reference is from 0.
        //  (i.e. the first position = 0 as reference, and so on.
        lineItemsTemp[x] = lineItem;

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
