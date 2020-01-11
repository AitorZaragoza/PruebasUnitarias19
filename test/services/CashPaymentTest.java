package services;

import exceptions.QuantityMinorThanImport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

public class CashPaymentTest {

    static Payment payment;
    static CashPayment cashPayment;
    static BigDecimal importe, quantity;

    @BeforeEach
    void setUp(){
        quantity = new BigDecimal("12");

        cashPayment = new CashPayment();
    }

    @Test
    void calculateChangeTest() throws QuantityMinorThanImport {
        importe = new BigDecimal("10");
        payment = new Payment(importe, quantity);

        BigDecimal sol = new BigDecimal("2");
        cashPayment.calculateChange();
        assertEquals(sol, cashPayment.getChange());
    }

    @Test
    void QuantityMinorThanImportTest(){
        importe = new BigDecimal("14");
        payment = new Payment(importe, quantity);


        assertThrows(QuantityMinorThanImport.class,()->cashPayment.calculateChange());
    }

}
