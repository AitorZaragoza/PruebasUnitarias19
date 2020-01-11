package data;

import exceptions.NotFoundValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionProductIDTest {

    static ProductID productID;

    @BeforeEach
    void setUp() {
        productID = new ProductID(null);
    }


    @Test
    public void ExceptionProductIDTest(){

        assertThrows(NotFoundValueException.class,()->productID.getProductID());
    }


}
