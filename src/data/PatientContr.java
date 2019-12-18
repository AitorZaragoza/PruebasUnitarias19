package data;

import exceptions.NotFoundValueException;

import java.math.BigDecimal;

public class PatientContr {

    private final BigDecimal patientContr;

    public PatientContr(BigDecimal code) {

        this. patientContr = code;
    }


    public BigDecimal getPatientContr() throws Exception{
        if(patientContr == null){
            throw new NotFoundValueException("PatientContr Invalid");
        }

        return patientContr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContr patContr = (PatientContr) o;
        return patientContr.equals(patContr.patientContr);
    }

    @Override
    public int hashCode() { return patientContr.hashCode(); }

    @Override
    public String toString() {
        return "PatientContr{" + "PatientContr ='" + patientContr + '\'' + '}';
    }
}
