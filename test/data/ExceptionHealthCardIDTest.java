package data;

import exceptions.NotFoundValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHealthCardIDTest {

    @Test
    public void ExceptionHealthCardIDTest(){
        HealthCardID healthCardID = new HealthCardID(null);
        assertThrows(NotFoundValueException.class,()->healthCardID.getPersonalID());
    }
}
