package pl.polsl.report4;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.polsl.report2.Airplane;
import pl.polsl.report2.Report3SesionBeanLocal;

@ManagedBean
@ViewScoped
/**
 *
 * @author Raul hernandez - Zahid Kizmaz
 * @version 1.0
 */
public class AirplaneController implements Serializable{
    
    /**
     * This is an object of the Airplane class
     */
    private Airplane airplane;
    @EJB
    /**
     * This is an object of the Report3SesionBeanLocal class
     */
    private Report3SesionBeanLocal localBean;
    
    @PostConstruct
    /**
     * Initialize the airplane variable
     */
    protected void init(){
        airplane = new Airplane();
    }
    
    /**
     * With this function, we can store the airplane to the database
     * @return We now change the page that is specified in the faces-config.xml
     */
    public String actionSave(){
        localBean.insert(airplane);
        return "airplanes";
    }

    /**
     * With this class, we get the airplanes
     * @return The airplane object already initialized
     */
    public Airplane getAirplane() {
        return airplane;
    }
    
    
}
