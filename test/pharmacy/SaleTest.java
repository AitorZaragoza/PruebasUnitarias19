package pharmacy;


import data.PatientContr;
import exceptions.SaleClosedException;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.Date;
import data.ProductID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleTest {

    int saleCode;
    Date date;
    BigDecimal amount;
    boolean isClosed; // flag to know if the sale is closed
    BigDecimal sumaParcial, totalTaxes,totalWithTaxes, price;
    static BigDecimal totalAmount;

    ProductID prodID;
    PatientContr patientContr;
    Sale sale = new Sale();

    @BeforeEach
    void setUp(){
        amount = new BigDecimal(12);
        price = new BigDecimal(5);
        prodID = new ProductID("21212121");
        BigDecimal num = new BigDecimal("0.5");
        patientContr = new PatientContr(num);
        System.out.println(num);

    }



    @Test
    public void getAmoundTest() throws SaleClosedException {

        BigDecimal solucion = new BigDecimal("30");
        sale.addLine(prodID, price, patientContr);
        sale.calculateFinalAmount();

        assertEquals(solucion, sale.getAmount());
    }
}
