package data;

import exceptions.NotFoundValueException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class PatientContrTest {

    @Test
    public void ExceptionPatientContrTest() throws Exception{
        PatientContr patientContr = new PatientContr(null);
        assertThrows(NotFoundValueException.class,()->patientContr.getPatientContr());
    }

    @Test
    public void Test2() throws Exception{
        BigDecimal num = new BigDecimal("25.65");
        BigDecimal result = new BigDecimal("25.65");

        PatientContr patientContr1 = new PatientContr(num);
        assertEquals(result, patientContr1.getPatientContr());
    }
}
