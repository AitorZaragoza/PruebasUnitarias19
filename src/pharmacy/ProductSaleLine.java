package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;

public class ProductSaleLine {

    /*private ProductID prodID;
    private BigDecimal price;
    private PatientContr contr;*/

    public static BigDecimal Operation(ProductID prodID, BigDecimal price, PatientContr contr, BigDecimal amount) throws Exception {
        BigDecimal temporal = amount.multiply(price);
        BigDecimal solucion = temporal.multiply(contr.getPatientContr());
        return solucion;
    }



}
