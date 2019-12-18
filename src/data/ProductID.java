package data;

import exceptions.NotFoundValueException;

public class ProductID {
    private final String productID;

    public ProductID(String code){

        this. productID = code;
    }

    public String getProductID()  throws Exception{
        if(productID == null){
            throw new NotFoundValueException("Product Code Invalid");
        }
        return productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID prodID = (ProductID) o;
        return productID.equals(prodID.productID);
    }

    @Override
    public int hashCode() { return productID.hashCode(); }

    @Override
    public String toString() {
        return "ProductID{" + "product code='" + productID + '\'' + '}';
    }
}