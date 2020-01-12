package services;



import java.math.BigDecimal;


public class Payment {

    static BigDecimal importe, quantity;

    public Payment(BigDecimal impor, BigDecimal quantit){
        importe = impor;
        quantity = quantit;

    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }


}
