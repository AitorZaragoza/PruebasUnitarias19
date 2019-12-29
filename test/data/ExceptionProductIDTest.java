package data;

import exceptions.NotFoundValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionProductIDTest {

    @Test
    public void ExceptionProductIDTest(){
        ProductID productID = new ProductID(null);
        assertThrows(NotFoundValueException.class,()->productID.getProductID());
    }
}
