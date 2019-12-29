package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HealthCardIDTest {

    HealthCardID healthCardID1;

    @BeforeEach
    void setUp(){
        healthCardID1 = new HealthCardID("73215736C");
    }

    @Test
    public void HealthCardIDTest() throws Exception{

        assertEquals("73215736C", healthCardID1.getPersonalID());

    }
}
