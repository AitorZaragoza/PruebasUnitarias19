package mocks;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;
import pharmacy.Sale;
import services.DispensingTerminal;
import services.HealthCardReader;
import services.NationalHealthService;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispensingTerminalTest{

    private static class NationalHealthServiceCorrect implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            ProductID pID = new ProductID("505024578653");
            Dispensing dispensing = new Dispensing();
            dispensing.setProductAsDispensed(pID);
            dispensing.setCompleted();

            return dispensing;
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            BigDecimal code = new BigDecimal("12345678");
            PatientContr patientContr = new PatientContr(code);
            return patientContr;
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            ProductSpecification productSpecification = new ProductSpecification();
            BigDecimal price = new BigDecimal("10");
            productSpecification.setPrice(price);
            productSpecification.setDescription("Muy chulo");

            return productSpecification;
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            List<Dispensing> lista = new ArrayList<>();
            return lista;
        }
    }

    private static class ConnectExceptionError implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            throw new ConnectException("ConnectException");
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            throw new ConnectException("ConnectException");
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            throw new ConnectException("ConnectException");
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            throw new ConnectException("ConnectException");
        }
    }

    private static class HealthCardExceptionError implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            throw new HealthCardException("HealthCardException");

        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            return null;
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            return null;
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            return null;
        }
    }

    private static class NotValidePrescriptionExceptionError implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            throw new NotValidePrescriptionException("NotValidePrescriptionException");
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            return null;
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            return null;
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            return null;
        }
    }

    private static class ProductIDExceptionError implements NationalHealthService{

        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            ProductID pID = new ProductID("50502345");
            Dispensing dispensing = new Dispensing();
            dispensing.setProductAsDispensed(pID);
            dispensing.setCompleted();

            return dispensing;
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            BigDecimal code = new BigDecimal("12345678");
            PatientContr patientContr = new PatientContr(code);
            return patientContr;
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            throw new ProductIDException("ProductIDException");

        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            return null;
        }
    }

    private static class HealthCardReaderCorrect implements HealthCardReader{

        @Override
        public HealthCardID getHealthCardID() throws HealthCardException {
            HealthCardID healthCardID = new HealthCardID("12345678");
            return healthCardID;
        }
    }

    private static class HealthCardReaderException implements HealthCardReader{

        @Override
        public HealthCardID getHealthCardID() throws HealthCardException {
            throw new HealthCardException("HealthCardException");
        }
    }

    private static class NationalHealthServiceSpy implements NationalHealthService{

        private boolean prescripcion = false, patientContr = false, productSpecific = false;

        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
            this.prescripcion = true;
            return null;
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            this.patientContr = true;
            BigDecimal contribucion = new BigDecimal("0.5");
            PatientContr patientContr = new PatientContr(contribucion);
            return patientContr;
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            this.productSpecific = true;
            ProductSpecification productSpecification = new ProductSpecification();
            BigDecimal precio = new BigDecimal("10");
            productSpecification.setPrice(precio);
            return productSpecification;
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            return null;
        }
    }

    private static class HealthCardReaderSpy implements HealthCardReader{

        private boolean healthCardId = false;

        @Override
        public HealthCardID getHealthCardID() throws HealthCardException {
            this.healthCardId = true;
            return null;
        }
    }

    private NationalHealthServiceCorrect nhsCorrect;
    private ConnectExceptionError conectExError;
    private HealthCardID hcID;
    private ProductID pID;
    private PatientContr pContr;
    private Dispensing dispensing;
    private Sale sale;
    private ProductSpecification pSpecification;
    private List<Dispensing> lista;
    private HealthCardReaderCorrect healthCardReaderCorrect;
    private HealthCardReaderException healthCardReaderException;
    private HealthCardExceptionError healthCardExceptionError;
    private NotValidePrescriptionExceptionError notValidePrescriptionException;
    private ProductIDExceptionError productIDExceptionError;

    private NationalHealthServiceSpy nhsSpy;
    private HealthCardReaderSpy hcrSpy;
    private DispensingTerminal dispensingTerminal;


    @BeforeEach
    void setUp() throws ParseException {
        nhsCorrect = new NationalHealthServiceCorrect();
        conectExError = new ConnectExceptionError();
        sale = new Sale();

        pSpecification = new ProductSpecification();
        lista = new ArrayList<>();
        healthCardReaderCorrect = new HealthCardReaderCorrect();
        healthCardReaderException = new HealthCardReaderException();
        healthCardExceptionError = new HealthCardExceptionError();
        notValidePrescriptionException = new NotValidePrescriptionExceptionError();
        productIDExceptionError = new ProductIDExceptionError();
        nhsSpy = new NationalHealthServiceSpy();
        hcrSpy = new HealthCardReaderSpy();


        pID = new ProductID("505024578653");
        hcID = new HealthCardID("12345678");
        BigDecimal num = new BigDecimal("12345678");
        pContr = new PatientContr(num);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date initDate = sdf.parse("2009-12-31");
        Date saleDate = sdf.parse("2010-01-25");
        sale.setDate(saleDate);
        dispensing = new Dispensing(sale);

        dispensing.setInitDate(initDate);
        dispensing.setProductAsDispensed(pID);
        dispensing.setCompleted();


        BigDecimal price = new BigDecimal("10");
        pSpecification.setPrice(price);
        pSpecification.setDescription("Muy chulo");

        dispensingTerminal = new DispensingTerminal();
        dispensingTerminal.setSns(nhsSpy);
        dispensingTerminal.setHealthCardIDr(hcrSpy);
        dispensingTerminal.setDisp(dispensing);
        dispensingTerminal.setSale(sale);


    }

    @Test
    void NationalHealthServiceCorrectTest() throws NotValidePrescriptionException, HealthCardException, ConnectException, ProductIDException {

        assertEquals(dispensing.isCompleted(), nhsCorrect.getePrescription(hcID).isCompleted());
        assertEquals(pContr, nhsCorrect.getPatientContr(hcID));
        assertEquals(pSpecification.getPrice(), nhsCorrect.getProductSpecific(pID).getPrice());
        assertEquals(pSpecification.getDescription(), nhsCorrect.getProductSpecific(pID).getDescription());
        assertEquals(lista, nhsCorrect.updateePrescription(hcID, dispensing));
    }

    @Test
    void ConnectExceptionErrorTest(){

        assertThrows(ConnectException.class,()->conectExError.getePrescription(hcID));
        assertThrows(ConnectException.class,()->conectExError.getPatientContr(hcID));
        assertThrows(ConnectException.class,()->conectExError.getProductSpecific(pID));
        assertThrows(ConnectException.class,()->conectExError.updateePrescription(hcID, dispensing));

    }

    @Test
    void HealthCardExceptionErrorTest(){

        assertThrows(HealthCardException.class,()->healthCardExceptionError.getePrescription(hcID));
    }

    @Test
    void NotValidePrescriptionExceptionErrorTest(){

        assertThrows(NotValidePrescriptionException.class,()->notValidePrescriptionException.getePrescription(hcID));
    }

    @Test
    void ProductIDExceptionErrorTest() throws NotValidePrescriptionException, HealthCardException, ConnectException {

        assertEquals(dispensing.isCompleted(), productIDExceptionError.getePrescription(hcID).isCompleted());
        assertEquals(pContr, productIDExceptionError.getPatientContr(hcID));
        assertThrows(ProductIDException.class,()-> productIDExceptionError.getProductSpecific(pID));

    }

    @Test
    void getHealthCardIDTest() throws HealthCardException {
        assertEquals(hcID,healthCardReaderCorrect.getHealthCardID());
    }

    @Test
    void HealthCardReaderExceptionTest(){

        assertThrows(HealthCardException.class,()->healthCardReaderException.getHealthCardID());

    }

    @Test
    void getePrescriptionSpyTest() throws HealthCardException, PatientIDException, ConnectException, NotValidePrescriptionException {

        dispensingTerminal.getePrescription('a');

        assertTrue(nhsSpy.prescripcion);
        assertTrue(hcrSpy.healthCardId);
    }

    @Test
    void enterProductSpyTest() throws ConnectException, SaleClosedException, NotFoundValueException, ProductNotFoundException, ProductIDException, ProductNotInDispensingException, SaleNotInitiatedException, DispensingNotAvailableException {

        dispensingTerminal.initNewSale();
        dispensingTerminal.enterProduct(pID);

        assertTrue(nhsSpy.productSpecific);
        assertTrue(nhsSpy.patientContr);
    }

    @Test
    void finalizeSaleTest() throws SaleNotInitiatedException, SaleClosedException {
        dispensing.setCompleted();
        dispensingTerminal.finalizeSale();

        assertEquals(dispensing.isCompleted(), dispensingTerminal.getDisp().isCompleted());
    }

}
