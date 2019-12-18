package services;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import exceptions.ConnectException;
import exceptions.HealthCardException;
import exceptions.NotValidePrescriptionException;
import exceptions.ProductIDException;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;

import java.math.BigDecimal;
import java.util.List;

public class DispensingTerminal implements NationalHealthService{

    public DispensingTerminal() {

    }

    public void getePrescription(char option) {

    }

    public void initNewSale() {

    }

    public void enterProduct(ProductID pID) {

    }

    public void finalizeSale() {

    }

    public void realizePayment(BigDecimal quantity) {

    }

    public void realizePayment() {

    }

    public void printNextDispensingSheet() {

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

// Other methods
}
