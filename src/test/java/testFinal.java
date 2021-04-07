import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testFinal extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
    }

    @Test
    public void test1() {

    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}
