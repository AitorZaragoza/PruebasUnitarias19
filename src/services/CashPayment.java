package services;

import exceptions.QuantityMinorThanImport;

import java.math.BigDecimal;

public class CashPayment extends Payment {

    private BigDecimal change;

    public CashPayment(){
        super(importe, quantity);

    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public void calculateChange() throws QuantityMinorThanImport {

        if(importe.compareTo(quantity) == 1){
            throw new QuantityMinorThanImport("QuantityMinorThanImport");
        }

        change = quantity.subtract(importe);

    }
}
