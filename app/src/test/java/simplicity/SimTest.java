package simplicity;
import com.simplicity.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimTest {

    Sim sim1;
    Sim sim2;

    @BeforeAll public void createSim() {
            sim1 = new Sim("Default");
            sim2 = new Sim("Test");
    }

    @Test @Order(1) public void checkName() throws Exception  {
        assertEquals("Default",sim1.getNama());
        assertEquals("Test",sim2.getNama());
    }

    @Test @Order(2) public void checkJob() throws Exception{
        assertEquals("Programmer",sim1.getPekerjaan().getPekerjaan());
        assertEquals("Programmer",sim2.getPekerjaan().getPekerjaan());
    }
}
