package pl.polsl.report2;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * This class has Create, Retrieve, Update and the Delete methods that handles 
 * operations in the database for Airplane and Customer objects.
 * @author Kizmaz Zahid - Hernandez Raul
 * @version 1.0
 */
@Stateless
public class Report3SesionBean implements Report3SesionBeanLocal{

    /**
     * This is a connection between database and the netbeans.
     */
    @PersistenceContext(unitName = "Lab2-EJB")
    private EntityManager em;
    
        /////////////////ALL THE AIRPLANE METHODS////////////////////
    
    /**
     * This method looks for all the Airplane objects in the database.
     * @return List of all airplanes in the database.
     */
    public List<Airplane> findAll(){
        return em.createQuery("SELECT a FROM Airplane a").getResultList();
    }
    
    /**
     * This method finds the Airplane by its id
     * @param id The unique number of the Airplane in the database.
     * @return The Airplane that matches the id of the parameter.
     */
    @Override
    public Airplane find(Integer id){
        return  em.find(Airplane.class, id); 
    }
    
    /**
     * This method add an Airplane to the database.
     * @param airplane This parameter is the one that will be added to the database.
     * @return The Airplane object added to the database.
     */
    @Override
    public Airplane insert(Airplane airplane){
        em.persist(airplane);
        return airplane;
    }
    
    /**
     * This method is used for deleting an Airplane object in the database.
     * @param airplane This parameter is the one that will be searched for an airplane
     * and if it is founded it will be deleted from the database.
     */
    @Override
    public void delete(Airplane airplane){
        airplane = find(airplane.getId());
         if (airplane != null) {
            em.remove(airplane);
        }
    }
    
    /**
     * This method will be used for update the Airplane information in the database.
     * @param airplane The parameter a will be updated in the database.
     * @return The updated version of the Airplane object.
     */
    @Override
    public Airplane update(Airplane airplane){
        return em.merge(airplane);
    }
    
    /////////////////ALL THE CUSTOMER METHODS////////////////////

    /**
     * This method looks for all the Customer objects in the database.
     * @return List of all Customers in the database.
     */
    public List<Customer> findAllCustomer(){
        return em.createQuery("SELECT c FROM Customer c").getResultList();
    }

    /**
     * This method finds the Customer by its id
     * @param id The unique number of the Customer in the database.
     * @return The Customer that matches the id of the parameter.
     */
    public Customer findC(Integer id){
        return  em.find(Customer.class, id); 
    }
   
    /**
     * This method add an Customer to the database.
     * @param customer This parameter is the one that will be added to the database.
     * @return The Customer object added to the database.
     */
    public Customer insert(Customer customer){
        em.persist(customer);
        return customer;
    }
    
    /**
     * This method is used for deleting an Customer object in the database.
     * @param customer This parameter is the one that will be searched for an Customer
     * and if it is founded it will be deleted from the database.
     */
    public void deleteC(Customer customer){
        customer = findC(customer.getId());
         if (customer != null) {
            em.remove(customer);
        }
    }
    
    /**
     * This method will be used for update the Customer information in the database.
     * @param customer The parameter a will be updated in the database.
     * @return The updated version of the Customer object.
     */
    public Customer updateC(Customer customer){
        return em.merge(customer);
    }

}
