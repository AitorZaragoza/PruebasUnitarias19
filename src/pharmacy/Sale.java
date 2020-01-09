package pharmacy;

import data.PatientContr;
import data.ProductID;
import exceptions.SaleClosedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Sale {

    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed; // flag to know if the sale is closed
    private BigDecimal totalTaxes,totalWithTaxes;
    private BigDecimal taxes = new BigDecimal("0.21");
    static BigDecimal totalAmount = new BigDecimal("0");
    List<ProductSaleLine> listaVenta= new ArrayList<>();

    public Sale () {  // Assigns the current date, a code to the sale, etc.
        this.saleCode = saleCode;
        this.date = date;
        this.amount = new BigDecimal("0");
        this.isClosed = isClosed;

    }

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException {


        if (isClosed == true){

            throw new SaleClosedException("Sale Closed Exception");
        }

        BigDecimal solucion = price.multiply(contr.getPatientContr());
        ProductSaleLine product = new ProductSaleLine(prodID, solucion);

        listaVenta.add(product);

    }

    private void calculateAmount() {
        Iterator<ProductSaleLine> it = listaVenta.iterator();

        while (it.hasNext()) {
            ProductSaleLine p = it.next();
            amount = amount.add(p.getSubtotal());

        }
    }

    private void addTaxes() throws SaleClosedException {

        if (isClosed == true){
            throw new SaleClosedException("Sale Closed Exception");
        }
        totalTaxes = amount.multiply(taxes);
    }

    public void calculateFinalAmount() throws SaleClosedException {
        calculateAmount();
        addTaxes();
        totalWithTaxes = amount.add(totalTaxes);
        setClosed();
    }

    public BigDecimal getAmount() {

        return totalWithTaxes;
    }

    private void setClosed() {
        this.isClosed= true;
    }

    public boolean isClosed() {

        return this.isClosed;
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
