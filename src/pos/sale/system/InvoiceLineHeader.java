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
public class InvoiceLineHeader {

    @Override
    public String toString() {

        return "\n\n\n" + "Product ID     "
                + "  Description      "
                + "  Unit Price  "
                + "  Quantity"
                + "  Discount"
                + "  Extended Price";
    }

}
