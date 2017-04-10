package pl.polsl.report4;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import pl.polsl.report2.Airplane;
import pl.polsl.report2.Report3SesionBean;
import pl.polsl.report2.Report3SesionBeanLocal;

@ManagedBean
@ViewScoped
/**
 *
 * @author Raul Hernandez - Zahid Kizmaz
 * @version 1.0
 */

public class AirplanesController implements Serializable{
    /**
     * This is a list of airplanes in the database
     */
    private List<Airplane> airplanes;
    /**
     * This is an object for the Airplane class
     */
    private Airplane airplane;
    @EJB
    /**
     * This is an object for the Report3SesionBeanLocal class
     */
    private Report3SesionBeanLocal localBean;
    
    @PostConstruct
    /**
     * We call the method findAirplanes which will refresh the page
     */
    protected void init(){
        findAirplanes();
    }
    /**
     * With this, we will get the list of airplanes that are in the database
     * @return Gives the airplanes
     */
    public List<Airplane> getAirplanes(){
        return airplanes;
    }

    /**
     * With this method, we initialize the airplanes variable
     */
    private void findAirplanes(){
        airplanes=localBean.findAll();
    }
    /**
     * With this method, we can find all the airplanes that are stored in the database
     * @return Gets all the list of airplanes
     */
    public Airplane getAirplane() {
        return airplane;
    }

    /**
     * With this method, we set which airplane will be used
     * @param airplane 
     */
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    
    /**
     * With this method, we will delete an airplane from the database
     * @param airplane This is the airplane that will be deleted from the database
     */
    public void deleteAirplane(Airplane airplane){
        localBean.delete(airplane);
        findAirplanes();
    }
    /**
     * With this method, we will update an airplane from the database
     * @param rowEditor This will be used for updating the airplane from the database
     */
    public void updateAirplane(RowEditEvent rowEditor){
        Airplane airplane = (Airplane) rowEditor.getObject();
        localBean.update(airplane);
        findAirplanes();
    }
    
}
