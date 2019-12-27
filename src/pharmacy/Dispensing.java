package pharmacy;

import data.ProductID;
import exceptions.DispensingNotAvailableException;

import java.util.Date;


public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment
    private Date initDate, finalDate; // The period
    private boolean isCompleted;
    private Date dateActual;

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

    public byte getnOrder() {
        return nOrder;
    }

    public Date getInitDate() {
        return initDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setnOrder(byte nOrder) {
        this.nOrder = nOrder;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
}
