package data;

import exceptions.NotFoundValueException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HealthCardIDTest {


    @Test
    public void ExceptionHealthCardIDTest() throws Exception{
        HealthCardID healthCardID = new HealthCardID(null);
        assertThrows(NotFoundValueException.class,()->healthCardID.getPersonalID());
    }

    @Test
    public void Test2() throws Exception{
        HealthCardID healthCardID1 = new HealthCardID("73215736C");
        assertEquals("73215736C", healthCardID1.getPersonalID());

    }
}
