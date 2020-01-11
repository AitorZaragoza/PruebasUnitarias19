package services;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import exceptions.*;
import jdk.jshell.Snippet;
import pharmacy.Dispensing;
import pharmacy.ProductSaleLine;
import pharmacy.ProductSpecification;
import pharmacy.Sale;

import java.math.BigDecimal;
import java.util.List;

public class DispensingTerminal {

    private Sale sale;
    private Dispensing disp;
    NationalHealthService SNS;
    HealthCardReader healthCardIDr;
    HealthCardID healthCardIDactual;

    public DispensingTerminal() {
        this.sale = sale;
        this.disp = disp;
    }

    public void getePrescription(char option) throws ConnectException, NotValidePrescriptionException, PatientIDException, HealthCardException{

        healthCardIDactual = healthCardIDr.getHealthCardID();
        disp = SNS.getePrescription(healthCardIDactual);
    }

    public void initNewSale() throws DispensingNotAvailableException{

        if (disp.dispensingEnabled() != true){ throw new DispensingNotAvailableException("No esta en el periodo de dispensacion habilitado"); }
        sale = new Sale();
        disp = new Dispensing(sale);
    }

    public void enterProduct(ProductID pID) throws ConnectException, SaleClosedException, SaleNotInitiatedException, ProductIDException, ProductNotFoundException, ProductNotInDispensingException, NotFoundValueException {

        ProductSpecification producto;
        PatientContr contribucion;
        if (sale.isClosed()== true){ throw new SaleClosedException("SaleClosedException"); }
        if(sale == null){ throw new SaleNotInitiatedException("SaleNotInitiatedException"); }
        if (pID.getProductID() == null){
            throw new ProductIDException("ProductIDException");
        }
        producto = SNS.getProductSpecific(pID);
        contribucion = SNS.getPatientContr(healthCardIDactual);
        sale.addLine(pID, producto.getPrice(), contribucion);
        disp.setProductAsDispensed(pID);
    }

    public void finalizeSale() throws SaleNotInitiatedException, SaleClosedException{

        if(sale.isClosed() == true){ throw new SaleClosedException("SaleClosedException"); }
        if(sale == null){ throw new SaleNotInitiatedException("SaleNotInitiatedException"); }
        sale.calculateFinalAmount();
        disp.setCompleted();
    }

    public void realizePayment(BigDecimal quantity) throws SaleNotClosedException { //OPCIONAL
        if (sale.isClosed() != true){ throw new SaleNotClosedException("SaleNotClosedException"); }

        Payment pay = new Payment(sale.getAmount(), quantity);
        CashPayment cambio = new CashPayment();
        cambio.getChange();
    }

    public void realizePayment() { //NO SE PIDE IMPLMENTEAR

    }

    public void printNextDispensingSheet() { //NO SE PIDE SU IMPLEMENTACION

    }


}
