package pharmacy;

import data.ProductID;
import pharmacy.Dispensing;
import exceptions.DispensingNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTest {

    static byte nOrder; // n. of order for this dispensing inside the treatment
    static Date initDate, finalDate; // The period
    static boolean isCompleted;


    @BeforeEach
    void setUp(){
        nOrder = 12;
        initDate = new Date(119, 11,27);
    }


    @Test
    public void DispensingNotAvailableExceptionTest() throws Exception{
        ProductID pd = new ProductID("12341234");
        Date act = new Date(119, 11, 18);
        Dispensing disp = new Dispensing(pd,act);
        assertThrows(DispensingNotAvailableException.class,()->disp.dispensingEnabled());
    }
}
