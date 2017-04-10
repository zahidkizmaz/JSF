package pl.polsl.report4;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pl.polsl.report2.Airplane;
import pl.polsl.report2.Report3SesionBeanLocal;

@FacesConverter(value = "airplaneConverter")
/**
 *
 * @author Raul Hernandez - Zahid Kizmaz
 * @version 1.0
 */
public class AirplaneConverter implements Converter{
    /**
     * This is an initialization to localBean.
     */
    private static Report3SesionBeanLocal localBean = lookup();

    /**
     * Here we will perform the lookup method.
     * @return Gets all the lookup context.
     */
    private static Report3SesionBeanLocal lookup(){
        try {
            InitialContext context = new InitialContext();
            return (Report3SesionBeanLocal) context.lookup("java:global/Lab4-EAR/Lab4-EAR-ejb/Report3SesionBean!pl.polsl.report2.Report3SesionBeanLocal");
        } catch (NamingException ex) {
            Logger.getLogger(AirplaneConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    /**
     * With this method, we get the list of all airplanes.
     */
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            List<Airplane> airplanes = localBean.findAll();
            for (Iterator<Airplane> iterator = airplanes.iterator(); iterator.hasNext();) {
                Airplane next = iterator.next();
                if (next.getId().toString().equals(value)) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override
    /**
     * Here we get the id of the airplane.
     */
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            if (value instanceof Airplane) {
                if (((Airplane)value).getId() != null) {
                    return ((Airplane)value).getId().toString();
                }             
            }
        }
        return "";
    }
    
}
