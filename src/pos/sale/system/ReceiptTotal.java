/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.sale.system;

import java.text.NumberFormat;

/**
 *
 * @author emanion
 */
public class ReceiptTotal {

    public ReceiptTotal() {
    }

    public double getTotalInvoiceAmount(LineItem[] lineItems) {
        double totalInvoiceAmount = 0;
        for (int i = 0; i < lineItems.length; i++) {
            totalInvoiceAmount = totalInvoiceAmount
                    + lineItems[i].getExtendedPrice();
        }
        return totalInvoiceAmount;
    }

    public double getTotalDiscountAmount(LineItem[] lineItems) {
        double totalDiscountAmount = 0;
        for (int i = 0; i < lineItems.length; i++) {
            totalDiscountAmount = totalDiscountAmount
                    + lineItems[i].getDiscount();
        }
        return totalDiscountAmount;
    }

    public String getPrintedTotalLine(LineItem[] lineItems) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "\n\nReceiptTotal"
                + "                                      "
                + "           "
                + nf.format(getTotalDiscountAmount(lineItems)) + "      "
                + nf.format(getTotalInvoiceAmount(lineItems)) + "\n";
    }

}
