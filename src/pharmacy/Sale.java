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
    private BigDecimal sumaParcial, totalTaxes,totalWithTaxes;
    private static BigDecimal totalAmount;

    public Sale () {  // Assigns the current date, a code to the sale, etc.
        this.saleCode = saleCode;
        this.date = date;
        this.amount = amount;
        this.isClosed = isClosed;
    }

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException {
        try {
            this.sumaParcial = ProductSaleLine.Operation(prodID, price, contr, amount);
            calculateAmount();
            addTaxes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAmount() {

        totalAmount.add(sumaParcial);

    }

    private void addTaxes() throws SaleClosedException {
        BigDecimal taxes = new BigDecimal(0.21);
        totalTaxes = totalAmount.multiply(taxes);
    }

    public void calculateFinalAmount() throws SaleClosedException {
        totalWithTaxes = totalAmount.add(totalTaxes);
    }

    public BigDecimal getAmount() {

        return totalWithTaxes;
    }

    private void setClosed() {
        this.isClosed= true;
    }

    public boolean isClosed() {

        if (isClosed == true){
            return true;
        }else{ return false; }
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
