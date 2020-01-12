package data;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductIDTest {

    ProductID productID;

    @BeforeEach
    void setUp() {
        productID = new ProductID("212121213487");
    }

    @Test
    public void ProductIDTest() throws Exception{
        productID.checkNumber();
        assertEquals("212121213487", productID.getProductID());
    }
}

