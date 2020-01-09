package pharmacy;

import data.ProductID;
import pharmacy.Dispensing;
import exceptions.DispensingNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTest {

    static byte nOrder; // n. of order for this dispensing inside the treatment
    static Date initDate, finalDate; // The period
    static boolean isCompleted;
    Sale sale = new Sale();
    SimpleDateFormat sdf;
    static Dispensing disp;


    @BeforeEach
    void setUp(){
        nOrder = 12;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }


    @Test
    public void DispensingNotAvailableExceptionTest() throws Exception{


        Date act = sdf.parse("2009-12-31");
        initDate = sdf.parse("2010-12-31");

        sale.setDate(act);
        Dispensing disp = new Dispensing(sale);
        disp.setInitDate(initDate);
        assertThrows(DispensingNotAvailableException.class,()->disp.dispensingEnabled());
    }

    @Test
    public void dispensingEnabledTest() throws DispensingNotAvailableException, ParseException {

        Date act = sdf.parse("2019-12-28");
        initDate = sdf.parse("2019-12-20");

        sale.setDate(act);
        disp = new Dispensing(sale);
        disp.setInitDate(initDate);

        assertEquals(true, disp.dispensingEnabled());

    }

}
