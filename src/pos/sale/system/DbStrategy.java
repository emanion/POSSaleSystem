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
public interface DbStrategy {

    CustomerStrategy getCustomerById(int CustomerId);

    Product getProductById(int ProductId);

    void setCustomerDb();

    void setProductDb();

}
