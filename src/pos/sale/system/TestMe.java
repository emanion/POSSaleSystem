/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.sale.system;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author emanion
 */
public class TestMe {
    public static void main(String[] args) {
        
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        DbStrategy dbStrategy = new FakeDB();
        
        
        /*
        DiscountStrategy ds = new QuantityDiscount();
        Product pd = new Product(3762,"misc",12.90,ds);
        LineItem lineItem = new LineItem(20,pd);
        Receipt rc = new Receipt();
        rc.addLineItem(dbStrategy, 1234, 20);
        */
        
        double x = 0;
        System.out.println(" here it is.." + nf.format(x));
        
        /*
        System.out.println(pd.getDiscountAmount(20));
        System.out.println(lineItem.getFormatedDetailLine());
        System.out.println(rc.getReceiptTotalSection());
        */
        
        
        //int y;
        //System.out.println("\n unintialized y = " + y);
        
        
        
        
        /*
        DecimalFormat numFormat;
        String number;
       // 2 digits before decimal point and then 2 digits (rounded)
        numFormat = new DecimalFormat("000.##");
        number = numFormat.format(-15.567);
        System.out.println("1. DecimalFormat with .: " + number);
        
        double numberCurrency = 125.36;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("NumberFormat = " + nf.format(numberCurrency));

      */  
        
        
        System.out.println("TESTME is now ending...");
        
    }
    
}
