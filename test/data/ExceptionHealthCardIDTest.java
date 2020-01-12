package data;

import exceptions.NotFoundValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHealthCardIDTest {

    @Test
    public void ExceptionHealthCardIDNullTest(){
        HealthCardID healthCardID = new HealthCardID(null);
        assertThrows(NotFoundValueException.class,()->healthCardID.checkNumber());
    }

    @Test
    public void ExceptionHealthCardIDFormatTest(){
        HealthCardID healthCardID = new HealthCardID("73215736C");
        assertThrows(NotFoundValueException.class,()->healthCardID.checkNumber());
    }
}
