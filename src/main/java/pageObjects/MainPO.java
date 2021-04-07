package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPO {

    private final WebDriver driver;

    //web elements using @FindBy
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement register;


    //Constructor
    public MainPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Methods to apply
    public void goToRegistrationPage(){
        myAccount.click();
        register.click();
    }
}
