package data;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductIDTest {

    ProductID productID;

    @BeforeEach
    void setUp() {
        productID = new ProductID("21212121");
    }

    @Test
    public void ProductIDTest() throws Exception{

        assertEquals("21212121", productID.getProductID());

    }
}

