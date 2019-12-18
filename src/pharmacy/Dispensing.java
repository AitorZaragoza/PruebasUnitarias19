package pharmacy;

import data.ProductID;
import exceptions.DispensingNotAvailableException;

import java.util.Date;


public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment
    private Date initDate, finalDate; // The period
    private boolean isCompleted;
    Date dateActual;

    // The set of medicines to dispense and its control, among others
    public Dispensing(ProductID productID, Date dateActual) {
        this.nOrder = nOrder;
        this.isCompleted = isCompleted;
        this.initDate = initDate;
        this.finalDate = finalDate;
        this.dateActual = dateActual;

    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException {
        //Probablemente este mal por el valor de dateActual no se si sera correcto
        if (initDate.getYear() <= dateActual.getYear() && initDate.getMonth() <= dateActual.getMonth() && initDate.getDate() < dateActual.getDate()){
            return true;
        }else{
            throw new DispensingNotAvailableException("No esta en el periodo de dispensacion habilitado");
        }
    }

    public void setProductAsDispensed(ProductID prodID) {

    }

    public void setCompleted(boolean comp) {

    }
  // the rest of getters and setters

}
