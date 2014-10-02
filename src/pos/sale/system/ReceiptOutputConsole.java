
package pos.sale.system;

/**
 * This class represents a receipt output object.
 * Print the receipt to the console.
 *
 * @author emanion
 * @version 09/29/2014
 *
 */
public class ReceiptOutputConsole implements ReceiptOutputStrategy {
    
    public ReceiptOutputConsole() {
    }

    @Override
    public void outputFormattedReceipt(String formattedReceipt) {
        System.out.println(formattedReceipt);
    }

}
