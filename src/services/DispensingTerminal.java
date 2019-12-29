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
    public DispensingTerminal() {
        this.sale = sale;

    }

    public void getePrescription(char option) throws ConnectException, NotValidePrescriptionException, PatientIDException, HealthCardException{

    }

    public void initNewSale() throws DispensingNotAvailableException{
        sale = new Sale();

    }

    public void enterProduct(ProductID pID) throws ConnectException, SaleClosedException, SaleNotInitiatedException, ProductIDException, ProductNotFoundException, ProductNotInDispensingException{

    }

    public void finalizeSale() throws SaleNotInitiatedException, SaleClosedException{

    }

    public void realizePayment(BigDecimal quantity) { //OPCIONAL

    }

    public void realizePayment() { //NO SE PIDE IMPLMENTEAR

    }

    public void printNextDispensingSheet() { //NO SE PIDE SU IMPLEMENTACION

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
