package services;

import exceptions.InsuficientExistences;
import pharmacy.ProductSaleLine;

import java.util.List;

public interface Warehouse {

    void updateStock(List<ProductSaleLine> listOfProducts)
            throws InsuficientExistences;

}
