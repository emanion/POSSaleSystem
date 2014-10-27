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
public class Startup {

    public static void main(String[] args) {

        Register register = new Register();

        // FIRST SALE.....
        // FIRST SALE.....
        // FIRST SALE.....
        // FIRST SALE.....
        //start first test case
        //start a sale with a customer id -  Jimmy the Greek
        register.startNewSale(333);
        // add new items the customer is purchasing
        // white shirt
        try {
            register.addLineItem(3762, 2);
        } catch (InvalidIdException iie){
            System.out.println("!!error!!" +  iie.getMessage());
        } catch (CantAddLineException cale){
            System.out.println("!!error!!" +  cale.getMessage());
        }
        //close out sale
        ReceiptOutputStrategy receiptOutputStrategy = new ReceiptOutputConsole();
        receiptOutputStrategy.outputFormattedReceipt(register.closeSale());

        
        
        
        // SECOND SALE.....
        // SECOND SALE.....
        // SECOND SALE.....
        // SECOND SALE.....
        // SECOND SALE.....
        //start first test case
        //start a sale with a customer id -  Donald Duck
        register.startNewSale(111);
        // add new items the customer is purchasing
        // dress socks
        try {
            register.addLineItem(2827, 5);
        } catch (InvalidIdException iie){
            System.out.println("!!error!!" +  iie.getMessage());
        } catch (CantAddLineException cale){
            System.out.println("!!error!!" +  cale.getMessage());
        }
        // add new items the customer is purchasing
        // badger shirt
        try {
            register.addLineItem(9313, 1);
        } catch (InvalidIdException iie){
            System.out.println("!!error!!" +  iie.getMessage());
        } catch (CantAddLineException cale){
            System.out.println("!!error!!" +  cale.getMessage());
        }
        //close out sale
        receiptOutputStrategy.outputFormattedReceipt(register.closeSale());

        // THIRD SALE.....
        // THIRD SALE.....
        // THIRD SALE.....
        // THIRD SALE.....
        // THIRD SALE.....
        // THIRD SALE.....
        // THIRD SALE.....
        // THIRD SALE.....
        //start first test case
        //start a sale with a customer id -  Sinbad the Sailor
        register.startNewSale(222);
        // add new items the customer is purchasing
        // T Shirt Pack
        try {
            register.addLineItem(4487, 2);
        } catch (InvalidIdException iie){
            System.out.println("!!error!!" +  iie.getMessage());
        } catch (CantAddLineException cale){
            System.out.println("!!error!!" +  cale.getMessage());
        }
        // add new items the customer is purchasing
        // Dress socks 
        try {
            register.addLineItem(2827, 7);
        } catch (InvalidIdException iie){
            System.out.println("!!error!!" +  iie.getMessage());
        } catch (CantAddLineException cale){
            System.out.println("!!error!!" +  cale.getMessage());
        }
        // add new items the customer is purchasing
        // Dress socks 
        try {
            register.addLineItem(3578, 1);
        } catch (InvalidIdException iie){
            System.out.println("!!error!!" +  iie.getMessage());
        } catch (CantAddLineException cale){
            System.out.println("!!error!!" +  cale.getMessage());
        }
        //close out sale
        receiptOutputStrategy.outputFormattedReceipt(register.closeSale());

        System.out.println("\n\nStartup class is now ending.");

          
                
    }

}
