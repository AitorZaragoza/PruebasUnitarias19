package pharmacy;


import data.PatientContr;
import exceptions.SaleClosedException;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.Date;
import data.ProductID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SaleTest {

    int saleCode;
    Date date;
    boolean isClosed; // flag to know if the sale is closed
    BigDecimal sumaParcial, totalTaxes,totalWithTaxes, price, price2;
    static BigDecimal totalAmount;

    ProductID prodID, prodID2;
    PatientContr patientContr, patientContr2;
    Sale sale = new Sale();

    @BeforeEach
    void setUp() throws SaleClosedException {
        //PRODUCTO 1
        price = new BigDecimal("5");
        prodID = new ProductID("21212121");
        BigDecimal num = new BigDecimal("0.5");
        patientContr = new PatientContr(num);
        sale.addLine(prodID, price, patientContr);

        //PRODUCTO 2
        price2 = new BigDecimal("2");
        prodID2 = new ProductID("20202020");
        BigDecimal num2 = new BigDecimal("0.5");
        patientContr2 = new PatientContr(num2);

        sale.addLine(prodID2, price2, patientContr2);


        sale.setSaleCode(1);
        sale.calculateFinalAmount();
        sale.getAmount();
    }


    @Test
    public void getAmoundTest(){

        BigDecimal solucion = new BigDecimal("4.235");
        assertEquals(solucion, sale.getAmount());
    }

    @Test
    public void isClosedTest(){

        assertEquals(true, sale.isClosed());
    }

    @Test
    public void SaleClosedExceptionTest(){
        assertThrows(SaleClosedException.class,()->sale.addLine(prodID, price, patientContr));
        assertThrows(SaleClosedException.class,()->sale.calculateFinalAmount());

    }

    @Test
    public void getSaleCodeTest(){
        assertEquals(1, sale.getSaleCode());
    }
}
