package pharmacy;

import data.PatientContr;
import data.ProductID;
import exceptions.SaleClosedException;

import java.math.BigDecimal;
import java.util.Date;

public class Sale {

    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed; // flag to know if the sale is closed

    public Sale () {  // Assigns the current date, a code to the sale, etc.
        this.saleCode = saleCode;
        this.date = date;
        this.amount = amount;
        this.isClosed = isClosed;
    }

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr)
            throws SaleClosedException {

    }

    private void calculateAmount() {

    }

    private void addTaxes() throws SaleClosedException {

    }

    public void calculateFinalAmount() throws SaleClosedException {

    }

    public BigDecimal getAmount() {

        return null;
    }

    private void setClosed() {

    }

    public boolean isClosed() {

        return false;
    }

    public int getSaleCode() {
        return saleCode;
    }

    public Date getDate() {
        return date;
    }

    public void setSaleCode(int saleCode) {
        this.saleCode = saleCode;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
