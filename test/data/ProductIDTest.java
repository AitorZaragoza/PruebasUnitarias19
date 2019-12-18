package data;

import exceptions.NotFoundValueException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductIDTest {

    @Test
    public void ExceptionProductIDTest() throws Exception{
        ProductID productID = new ProductID(null);
        assertThrows(NotFoundValueException.class,()->productID.getProductID());
    }

    @Test
    public void Test2() throws Exception{
        ProductID productID1 = new ProductID("21212121");
        assertEquals("21212121", productID1.getProductID());

    }
}

