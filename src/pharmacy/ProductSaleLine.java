package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;

public class ProductSaleLine {

    /*private ProductID prodID;
    private BigDecimal price;
    private PatientContr contr;*/


    public static BigDecimal Operation(BigDecimal price, PatientContr contr, BigDecimal amount){

        BigDecimal temporal = amount.multiply(price);
        BigDecimal solucion = null;
        try {
            solucion = temporal.multiply(contr.getPatientContr());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return solucion;
    }



}
