package Automated_test_cases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register_User_Test {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //2. Navigate to url 'http://automationexercise.com'
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        //!!!!Accept
        //WebElement acceptButton = driver.findElement(By.cssSelector(".fc-primary-button"));
        //acceptButton.click();
    }

    @Test(priority = 1)
    public void homePageVisible() {
        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if (currentUrl.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }
    }

    @Test(priority = 2)
    public void registerNewUser() throws InterruptedException {
        registerUser("Serhii Test1", "serhii.test1231231@gmail.com", "Test12345!", "3", "June", "1991",
                "Serhii", "Breslavskiy", "Sweet Home", "Sweet Street 12/2", "United States",
                "Pensylvania", "Scranton", "77340", "+7 987654321");

    }

    private void registerUser(String name, String email, String password, String day, String month, String year,
                              String firstName, String lastName, String company, String address, String country,
                              String state, String city, String zipCode, String mobileNumber) throws InterruptedException {
        // 4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLoginButton.click();

        // 5. Verify 'New User Signup!' is visible
        WebElement signUpButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
        Assert.assertTrue(signUpButton.isDisplayed(), "New user SignUp is not displayed");

        // 6. Enter name and email address
        driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(email);

        // 7. Click 'Signup' button
        signUpButton.click();
        Thread.sleep(2000);

        // 8. Verify 'ENTER ACCOUNT INFORMATION' is visible
        WebElement text1 = driver.findElement(By.xpath("//h2/b[text()='Enter Account Information']"));
        Assert.assertTrue(text1.isDisplayed(), "'Enter Account Information' is not visible");

        // 9. Fill details: Title, Password, Date of Birth
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.cssSelector("[data-qa='password']")).sendKeys(password);

        Select dayDropDown = new Select(driver.findElement(By.cssSelector("[data-qa='days']")));
        dayDropDown.selectByVisibleText(day);

        Select monthDropDown = new Select(driver.findElement(By.cssSelector("[data-qa='months']")));
        monthDropDown.selectByVisibleText(month);

        Select yearDropDown = new Select(driver.findElement(By.cssSelector("[data-qa='years']")));
        yearDropDown.selectByVisibleText(year);

        // 10. Select checkboxes
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        // 11. Fill additional details
        driver.findElement(By.cssSelector("[data-qa='first_name']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[data-qa='last_name']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-qa='company']")).sendKeys(company);
        driver.findElement(By.cssSelector("[data-qa='address']")).sendKeys(address);

        Select countryDropDown = new Select(driver.findElement(By.cssSelector("[data-qa='country']")));
        countryDropDown.selectByVisibleText(country);

        driver.findElement(By.cssSelector("[data-qa='state']")).sendKeys(state);
        driver.findElement(By.cssSelector("[data-qa='city']")).sendKeys(city);
        driver.findElement(By.cssSelector("[data-qa='zipcode']")).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[data-qa='mobile_number']")).sendKeys(mobileNumber);

        // 12. Click 'Create Account' button
        driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
        Thread.sleep(2000);

        // 13. Verify 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedMessage = driver.findElement(By.cssSelector("[data-qa='account-created']"));
        Assert.assertTrue(accountCreatedMessage.isDisplayed(), "'ACCOUNT CREATED!' message is not visible");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}