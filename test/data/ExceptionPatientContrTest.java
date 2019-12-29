package data;

import exceptions.NotFoundValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionPatientContrTest {

    @Test
    public void ExceptionPatientContrTest(){
        PatientContr patientContr = new PatientContr(null);
        assertThrows(NotFoundValueException.class, () -> patientContr.getPatientContr());

    }
}
