package pl.polsl.report4;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import pl.polsl.report2.Airplane;
import pl.polsl.report2.Customer;
import pl.polsl.report2.Report3SesionBeanLocal;

@ManagedBean
@ViewScoped
/**
 *
 * @author Raul Hernandez - Zahid Kizmaz
 * @version 1.0
 */
public class CustomersController implements Serializable{
    /**
     * This is the list of customers.
     */
    private List<Customer> customers;
    @EJB
    /**
     * This is an object of the Report3SesionBeanLocal class.
     */
    private Report3SesionBeanLocal localBean;
       
    @PostConstruct
    /**
     * We update the table every time we make an operation 
     */
    protected void init(){
        findCustomers();
    }
    
    /**
     * Here we initialize the customer variable.
     */
    public void findCustomers(){
        customers=localBean.findAllCustomer();
    }
    
    /**
     * Here we get all the customers from the database.
     * @return Gives all the customers.
     */
    public List<Customer> getCustomers(){
        return customers;
    }
    
    /**
     * This method will be used for deleting a customer from the database.
     * @param customer This is the customer that will be deleted.
     */
    public void deleteCustomer(Customer customer){
        localBean.deleteC(customer);
        findCustomers();
    }
    /**
     * Here we will update the information of a customer
     * @param rowEditor This will be which customer we want to edit
     */
    public void updateCustomer(RowEditEvent rowEditor){
        Customer customer = (Customer) rowEditor.getObject();
        localBean.updateC(customer);
        findCustomers();
    }
    
    /**
     * With this method, we get all the airplanes from the database.
     * @return Gets the airplanes.
     */
    public List<Airplane> getAirplanes(){
        return localBean.findAll();
    }
}
