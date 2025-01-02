package Automated_test_cases;
//https://automationexercise.com/test_cases

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class _1_Register_User {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //2. Navigate to url 'http://automationexercise.com'
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        //!!!!Accept
        WebElement acceptButton = driver.findElement(By.cssSelector(".fc-primary-button"));
        acceptButton.click();

        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if (currentUrl.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }

        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement signUpButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
        if (signUpButton.isDisplayed()) {
            System.out.println("New user SignUp is displayed");
        } else {
            System.out.println("New user SignUp is not displayed");
        }

        //6. Enter name and email address
            Thread.sleep(1000);
            WebElement nameField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
            nameField.sendKeys("Serhii Test16");
            Thread.sleep(1000);
            WebElement emailField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
            emailField.sendKeys("serhii.test16test@gmail.com");
            Thread.sleep(1000);

            //7. Click 'Signup' button
            signUpButton.click();
            Thread.sleep(2000);

            //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            WebElement text1 = driver.findElement(By.xpath("//h2/b[text()='Enter Account Information']"));
            if (text1.isDisplayed()) {
                System.out.println("ENTER ACCOUNT INFORMATION is visible");
            } else {
                System.out.println("ERROR");
            }

            //9. Fill details: Title, Name, Email, Password, Date of birth
            WebElement radioButton = driver.findElement(By.id("id_gender1"));
            radioButton.click();

            WebElement passwordField = driver.findElement(By.cssSelector("[data-qa='password']"));
            passwordField.sendKeys("Test12345!");

            WebElement dayDropDown = driver.findElement(By.cssSelector("[data-qa='days']"));
            Select day = new Select(dayDropDown);
            day.selectByVisibleText("3");

            WebElement monthDropDown = driver.findElement(By.cssSelector("[data-qa='months']"));
            Select month = new Select(monthDropDown);
            month.selectByVisibleText("June");

            WebElement yearDropDown = driver.findElement(By.cssSelector("[data-qa='years']"));
            Select year = new Select(yearDropDown);
            year.selectByVisibleText("1991");

            //10. Select checkbox 'Sign up for our newsletter!'
            WebElement checkbox1 = driver.findElement(By.id("newsletter"));
            checkbox1.click();

            //11. Select checkbox 'Receive special offers from our partners!'
            WebElement checkbox2 = driver.findElement(By.id("optin"));
            checkbox2.click();

            //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            WebElement firstNameField = driver.findElement(By.cssSelector("[data-qa='first_name']"));
            firstNameField.sendKeys("Serhii");
            WebElement lastNameField = driver.findElement(By.cssSelector("[data-qa='last_name']"));
            lastNameField.sendKeys("Breslavskiy");
            WebElement companyField = driver.findElement(By.cssSelector("[data-qa='company']"));
            companyField.sendKeys("Sweet Home");
            WebElement addressField = driver.findElement(By.cssSelector("[data-qa='address']"));
            addressField.sendKeys("Sweet Street 12/2");
            WebElement countryDropDown = driver.findElement(By.cssSelector("[data-qa='country']"));
            Select country = new Select(countryDropDown);
            country.selectByVisibleText("United States");
            WebElement stateField = driver.findElement(By.cssSelector("[data-qa='state']"));
            stateField.sendKeys("Pensylvania");
            WebElement cityField = driver.findElement(By.cssSelector("[data-qa='city']"));
            cityField.sendKeys("Scranton");
            WebElement zipCodeField = driver.findElement(By.cssSelector("[data-qa='zipcode']"));
            zipCodeField.sendKeys("77340");
            WebElement phoneField = driver.findElement(By.cssSelector("[data-qa='mobile_number']"));
            phoneField.sendKeys("+7 987654321");

            //13. Click 'Create Account button'
            WebElement createAccountButton = driver.findElement(By.cssSelector("[data-qa='create-account']"));
            createAccountButton.click();
            Thread.sleep(2000);

            //14. Verify that 'ACCOUNT CREATED!' is visible
            WebElement text2 = driver.findElement(By.cssSelector("[data-qa='account-created']"));
            if (text2.isDisplayed()) {
                System.out.println("ACCOUNT CREATED! is visible");
            } else {
                System.out.println("ERROR");
            }

            //15. Click 'Continue' button
            WebElement continueButton = driver.findElement(By.cssSelector("[data-qa='continue-button']"));
            continueButton.click();
            Thread.sleep(2000);

            //16. Verify that 'Logged in as username' is visible
            WebElement loggedInUser = driver.findElement(By.xpath("//li/a/b[contains(text(), 'Serhii Test1')]"));
            if (loggedInUser.toString().contains("Serhii Test1")) {
                System.out.println("Logged in as " + loggedInUser.getText());
            } else {
                System.out.println("ERROR");
            }

        //17. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("//li/a[contains(text(), 'Delete Account')]"));
        deleteAccountButton.click();
        Thread.sleep(3000);

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deletedAccount = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        if (deletedAccount.isDisplayed()) {
            System.out.println("ACCOUNT DELETED! is visible");
        } else {
            System.out.println("ERROR");
        }

        Thread.sleep(2000);
        WebElement continueButton2 = driver.findElement(By.cssSelector("[data-qa='continue-button']"));
        continueButton2.click();
        Thread.sleep(2000);

        // Закриття браузера
        driver.quit();
    }
}
