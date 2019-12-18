package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {

    private ProductID UPCcode;
    private String description;
    private BigDecimal price;

    public ProductSpecification(){
        this.UPCcode = UPCcode;
        this.description = description;
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
