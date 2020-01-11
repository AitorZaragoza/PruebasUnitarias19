package services;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import exceptions.*;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;
import pharmacy.Sale;

import java.math.BigDecimal;
import java.util.List;

public class DispensingTerminal implements NationalHealthService{

    private Sale sale;
    private Dispensing disp;

    public DispensingTerminal() {
        this.sale = sale;
        this.disp = disp;

    }

    public void getePrescription(char option) throws ConnectException, NotValidePrescriptionException, PatientIDException, HealthCardException{

    }

    public void initNewSale() throws DispensingNotAvailableException{

        if (disp.dispensingEnabled() != true){

            throw new DispensingNotAvailableException("No esta en el periodo de dispensacion habilitado");
        }

        sale = new Sale();

    }

    public void enterProduct(ProductID pID) throws ConnectException, SaleClosedException, SaleNotInitiatedException, ProductIDException, ProductNotFoundException, ProductNotInDispensingException{

        if (sale.isClosed()== true){
            throw new SaleClosedException("SaleClosedException");
        }
        if(sale == null){
            throw new SaleNotInitiatedException("SaleNotInitiatedException"); //Inventado
        }
        if (pID.getProductID() == null){
            throw new ProductIDException("ProductIDException");
        }

    }

    public void finalizeSale() throws SaleNotInitiatedException, SaleClosedException{

        if(sale.isClosed() == true){
            throw new SaleClosedException("SaleClosedException");
        }
        if(sale == null){
            throw new SaleNotInitiatedException("SaleNotInitiatedException"); //Inventado
        }
        sale.calculateFinalAmount();
        disp.setCompleted();

    }

    public void realizePayment(BigDecimal quantity) throws SaleNotClosedException { //OPCIONAL
        if (sale.isClosed() != true){
            throw new SaleNotClosedException("SaleNotClosedException");
        }
        Payment pay = new Payment(sale.getAmount(), quantity);
        CashPayment cambio = new CashPayment();

        cambio.getChange();

    }

    public void realizePayment() { //NO SE PIDE IMPLMENTEAR

    }

    public void printNextDispensingSheet() { //NO SE PIDE SU IMPLEMENTACION

    }

    HealthCardID getHealthCardID() throws HealthCardException { //?????????????
        return null;
    }

    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {

        return null;
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        return null;
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null;
    }


}
