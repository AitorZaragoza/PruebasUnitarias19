package data;


import exceptions.NotFoundValueException;

public class ProductID {
    private final String productID;

    public ProductID(String code){

        this. productID = code;
    }

    public String getProductID(){

        return productID;
    }

    public void checkNumber() throws NotFoundValueException{

        if(productID == null || productID.length() != 12) {
            throw new NotFoundValueException("Product Code Invalid");
        }

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
