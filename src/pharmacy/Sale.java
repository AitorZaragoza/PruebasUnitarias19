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
    private BigDecimal sumaParcial;
    BigDecimal totalTaxes,totalWithTaxes;
    BigDecimal taxes = new BigDecimal("0.21");
    static BigDecimal totalAmount = new BigDecimal("0");

    public Sale () {  // Assigns the current date, a code to the sale, etc.
        this.saleCode = saleCode;
        this.date = date;
        this.amount = amount;
        this.isClosed = isClosed;
    }

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException {

        if (isClosed == true){

            throw new SaleClosedException("Sale Closed Exception");
        }

        this.sumaParcial = ProductSaleLine.Operation(price, contr, amount);
        calculateAmount();


    }

    private void calculateAmount() {

        totalAmount = totalAmount.add(sumaParcial);

    }

    private void addTaxes() throws SaleClosedException {

        if (isClosed == true){
            throw new SaleClosedException("Sale Closed Exception");
        }
        totalTaxes = totalAmount.multiply(taxes);

    }

    public void calculateFinalAmount() throws SaleClosedException {
        addTaxes();
        totalWithTaxes = totalAmount.add(totalTaxes);
    }

    public BigDecimal getAmount() {
        setClosed();
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

}
