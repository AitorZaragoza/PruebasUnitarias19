package pharmacy;

import data.ProductID;
import exceptions.DispensingNotAvailableException;

import java.util.Date;


public class Dispensing {

    private byte nOrder; // n. of order for this dispensing inside the treatment
    private Date initDate, finalDate, actualDate; // The period
    private boolean isCompleted;


    // The set of medicines to dispense and its control, among others
    public Dispensing() {
        this.nOrder = nOrder;
        this.isCompleted = isCompleted;
        this.initDate = initDate;
        this.finalDate = finalDate;
    }

    public Dispensing(Sale sale){
        this();
        this.actualDate = sale.getDate();
    }

    public boolean dispensingEnabled() throws DispensingNotAvailableException {
        //Probablemente este mal por el valor de dateActual no se si sera correcto
        if (actualDate.compareTo(initDate) > 0){
            return true;
        }else{
            throw new DispensingNotAvailableException("No esta en el periodo de dispensacion habilitado");
        }
    }

    public void setProductAsDispensed(ProductID prodID) {
        boolean productAdquired = false;

        productAdquired = MedicineDispensingLine.adquired(prodID, productAdquired);

    }

    public void setCompleted() {
        this.isCompleted = true;
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
