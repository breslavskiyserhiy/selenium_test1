package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _15_Place_Order_Register_before_Checkout {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-site-isolation-trials");
        options.addArguments("--disable-features=InterestCohort");
        options.addArguments("--disable-ads");
        WebDriver driver = new ChromeDriver(options);

        //2. Navigate to url 'http://automationexercise.com'
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        Thread.sleep(1000);

        //!!!!Accept
        WebElement acceptButton = driver.findElement(By.cssSelector(".fc-primary-button"));
        acceptButton.click();

        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }

        //4. Click 'Signup / Login' button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Fill all details in Signup and create account
        Thread.sleep(1000);
        WebElement nameField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
        nameField.sendKeys("Serhii Test111");
        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        emailField.sendKeys("serhii.test1231231223@gmail.com");

        WebElement signUpButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
        signUpButton.click();
        Thread.sleep(1000);

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

        WebElement checkbox1 = driver.findElement(By.id("newsletter"));
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.id("optin"));
        checkbox2.click();

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

        WebElement createAccountButton = driver.findElement(By.cssSelector("[data-qa='create-account']"));
        createAccountButton.click();
        Thread.sleep(1000);

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement text2 = driver.findElement(By.cssSelector("[data-qa='account-created']"));
        if (text2.isDisplayed()) {
            System.out.println("ACCOUNT CREATED! is visible");
        } else {
            System.out.println("ERROR");
        }

        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
        Thread.sleep(1000);

        //7. Verify ' Logged in as username' at top
        WebElement loggedInUser = driver.findElement(By.xpath("//li/a/b[contains(text(), 'Serhii Test1')]"));
        if (loggedInUser.toString().contains("Serhii Test1")) {
            System.out.println("Logged in as " + loggedInUser.getText());
        } else {
            System.out.println("ERROR");
        }

        //8. Add products to cart
        WebElement view6Product  = driver.findElement(By.xpath("//a[@href='/product_details/6']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view6Product);
        view6Product.click();

        Thread.sleep(1000);

        WebElement addToCartButton = driver.findElement(By.cssSelector("button.btn.btn-default.cart"));
        addToCartButton.click();

        //9. Click 'Cart' button
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();

        //10. Verify that cart page is displayed
        Thread.sleep(1000);
        String cartUrl = driver.getCurrentUrl();
        if (cartUrl.equals("https://automationexercise.com/view_cart")) {
            System.out.println("Cart page is opened");
        } else {
            System.out.println("Cart page is not opened");}

        //11. Click Proceed To Checkout
        driver.findElement(By.cssSelector("a.btn.btn-default.check_out")).click();

        //12. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("//h2[@class='heading' and text()='Address Details']"));
        WebElement reviewOrder = driver.findElement(By.xpath("//h2[@class='heading' and text()='Review Your Order']"));
        if (addressDetails.isDisplayed() && reviewOrder.isDisplayed()) {
            System.out.println("Address Details and Review Your Order is visible");
        } else { System.out.println("ERROR"); }

        //13. Enter description in comment text area and click 'Place Order'
        WebElement textArea =driver.findElement(By.cssSelector("textarea.form-control"));
        textArea.sendKeys("This is a test comment for testing purposes");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.cssSelector("[data-qa='name-on-card']")).sendKeys("Serhii Test1");
        driver.findElement(By.cssSelector("[data-qa='card-number']")).sendKeys("1111111111111111");
        driver.findElement(By.cssSelector("[data-qa='cvc']")).sendKeys("111");
        driver.findElement(By.cssSelector("[data-qa='expiry-month']")).sendKeys("12");
        driver.findElement(By.cssSelector("[data-qa='expiry-year']")).sendKeys("2026");
        Thread.sleep(1000);

        //15. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("[data-qa='pay-button']")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        //16. Verify success message 'Your order has been placed successfully!'
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='success_message']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String messageText = (String) js.executeScript(
                "return document.evaluate(\"//div[@id='success_message']//div[contains(text(), 'Your order has been placed successfully!')]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue?.innerText;"
        );
        if (messageText.equals("Your order has been placed successfully!")) {
            System.out.println("Success Message is visible");
        } else {System.out.println("Success Message is not visible");}

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[data-qa='pay-button']")).click();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.cssSelector("[data-qa='account-deleted']"));
        if (accountDeleted.getText().equals("ACCOUNT DELETED!")) {
            System.out.println("Account Deleted is visible");
        } else {System.out.println("Account Deleted is not visible");}

        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

        driver.quit();
    }
}
