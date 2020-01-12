package data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class PatientContrTest {

    BigDecimal num, result;

    @BeforeEach
    void setUp() {
        num = new BigDecimal("25.65");
        result = new BigDecimal("25.65");
    }

    @Test
    public void PatientContrTest() throws Exception{

        PatientContr patientContr1 = new PatientContr(num);
        assertEquals(result, patientContr1.getPatientContr());
    }
}
