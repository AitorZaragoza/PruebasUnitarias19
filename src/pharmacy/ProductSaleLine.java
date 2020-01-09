package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSaleLine{

    private BigDecimal subtotal;


    public ProductSaleLine(ProductID prodID, BigDecimal solution){

        this.subtotal = solution;


    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
}
