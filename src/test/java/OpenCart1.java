import dataprovider.SignUpData;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.MainPage;
import pageobjects.SignUpPage;

public class OpenCart1 extends Base{
    private MainPage mainPage;
    private SignUpPage signUpPage;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        mainPage = new MainPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://demo.opencart.com");
        mainPage.goToRegistrationPage();
    }

    @Test(dataProvider = "correct data", dataProviderClass = SignUpData.class)
    public void testSuccess(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        signUpPage.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        Assert.assertTrue(signUpPage.successMessage());
    }

    @Test(dataProvider = "missing data", dataProviderClass = SignUpData.class)
    public void testMissingError(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        signUpPage.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        Assert.assertTrue(signUpPage.missingFieldsError() );
    }

    @Test(dataProvider = "invalid email", dataProviderClass = SignUpData.class)
    public void testInvalidEmail(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        signUpPage.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        Assert.assertTrue(signUpPage.missingFieldsError());
    }

    @Test(dataProvider = "duplicated email", dataProviderClass = SignUpData.class)
    public void testDuplicatedEmail(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        signUpPage.insertFields(firstName, lastName, email, telephone, password, confirmPassword);
        Assert.assertTrue(signUpPage.duplicatedEmailError());
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}