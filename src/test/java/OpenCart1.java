import dataprovider.SignUpData;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.reporters.jq.Main;
import pageObjects.MainPO;
import pageObjects.SignUpPO;

public class OpenCart1 extends Base{
    private MainPO MainPO;
    private SignUpPO SignUpPO;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        MainPO = new MainPO(driver);
        SignUpPO = new SignUpPO(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://demo.opencart.com");
        MainPO.goToRegistrationPage();
    }

    @Test(dataProvider = "correct data", dataProviderClass =SignUpData.class)
    public void testSuccess(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        SignUpPO.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        SignUpPO.continueRegistration();
        Assert.assertTrue(SignUpPO.successMessage());
    }

    @Test(dataProvider = "missing data", dataProviderClass =SignUpData.class)
    public void testMissingError(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        SignUpPO.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        SignUpPO.continueRegistration();
        Assert.assertTrue(SignUpPO.missingFieldsError() );
    }

    @Test(dataProvider = "invalid email", dataProviderClass =SignUpData.class)
    public void testInvalidEmail(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        SignUpPO.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        SignUpPO.continueRegistration();
        Assert.assertTrue(SignUpPO.missingFieldsError());
    }
    @Test(dataProvider = "duplicated email", dataProviderClass =SignUpData.class)
    public void testDuplicatedEmail(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        SignUpPO.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        SignUpPO.continueRegistration();
        Assert.assertTrue(SignUpPO.duplicatedEmailError());
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}