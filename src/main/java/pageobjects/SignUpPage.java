package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private final WebDriver driver;

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(name = "agree")
    WebElement privacyCheckBox;

    @FindBy(xpath = "//div[@class='pull-right']//input[@class='btn btn-primary']")
    WebElement continueBtn;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement successMessage;

    @FindBy(xpath = "//div[@class='form-group required has-error']")
    WebElement fieldErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    WebElement duplicatedEmailErrorMessage;


    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public boolean successMessage(){
        return successMessage.isDisplayed();
    }

    public boolean missingFieldsError(){
        return fieldErrorMessage.isDisplayed();
    }

    public boolean duplicatedEmailError(){
        return duplicatedEmailErrorMessage.isDisplayed();
    }

    public void insertFields(String firstNameData, String lastNameData, String emailData, String telephoneData, String passwordData, String confirmPasswordData){
        if (firstNameData != null) {
            firstName.sendKeys(firstNameData);
        }
        if (lastNameData != null) {
            lastName.sendKeys(lastNameData);
        }
        if (emailData != null) {
            email.sendKeys(emailData);
        }
        if (telephoneData != null) {
            telephone.sendKeys(telephoneData);
        }
        if (passwordData != null) {
            password.sendKeys(passwordData);
        }
        if (confirmPasswordData != null) {
            confirmPassword.sendKeys(confirmPasswordData);
        }
        privacyCheckBox.click();
        continueBtn.click();
    }

}
