package pl.polsl.report4;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
public class CustomerController implements Serializable{
    
    /**
     * This is an instance for the Customer class
     */
    private Customer customer;
    @EJB
    /**
     * This is an instance for the Report3SesionBeanLocal class
     */
    private Report3SesionBeanLocal localBean;
    
    @PostConstruct
    /**
     * Here we are initializing the customer
     */
    protected void init(){
        customer = new Customer();
    }
    
    /**
     * With this method, we save the new customer in the database.
     * @return We now change the page that is specified in the faces-config.xml
     */
    public String actionSave(){
        localBean.insert(customer);
        return "customers";
    }
    
    /**
     * We get the customers from the database.
     * @return 
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * This method will find all airplanes in the database.
     * @return We get all the airplanes.
     */
    public List<Airplane> getAirplanes(){
        return localBean.findAll();
    }
    
    
}
