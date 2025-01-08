package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class _24_Download_Invoice_after_purchase_order {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/edgedriver_win64/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--block-new-web-contents");

        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        Thread.sleep(1000);

        //!!!!Accept
        driver.findElement(By.cssSelector(".fc-primary-button")).click();
        Thread.sleep(3000);

        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }

        //4. Add products to cart
        WebElement view6Product  = driver.findElement(By.xpath("//a[@href='/product_details/6']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view6Product);
        view6Product.click();

        Thread.sleep(5000);

        WebElement addToCartButton = driver.findElement(By.cssSelector("button.btn.btn-default.cart"));
        addToCartButton.click();

        //5. Click 'Cart' button
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();

        //6. Verify that cart page is displayed
        Thread.sleep(1000);
        String cartUrl = driver.getCurrentUrl();
        if (cartUrl.equals("https://automationexercise.com/view_cart")) {
            System.out.println("Cart page is opened");
        } else {
            System.out.println("Cart page is not opened");}

        //7. Click Proceed To Checkout
        driver.findElement(By.cssSelector("a.btn.btn-default.check_out")).click();

        //8. Click 'Register / Login' button
        Thread.sleep(1000);
        WebElement regLogButton = driver.findElement(By.xpath("//p/a[@href='/login']"));
        regLogButton.click();

        //9. Fill all details in Signup and create account
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

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement text2 = driver.findElement(By.cssSelector("[data-qa='account-created']"));
        if (text2.isDisplayed()) {
            System.out.println("ACCOUNT CREATED! is visible");
        } else {System.out.println("ERROR");}

        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
        Thread.sleep(3000);

        //11. Verify ' Logged in as username' at top
        WebElement loggedInUser = driver.findElement(By.xpath("//li/a/b[contains(text(), 'Serhii Test1')]"));
        if (loggedInUser.toString().contains("Serhii Test1")) {
            System.out.println("Logged in as " + loggedInUser.getText());
        } else {
            System.out.println("ERROR");
        }

        //12.Click 'Cart' button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.cssSelector("a.btn.btn-default.check_out")).click();
        Thread.sleep(1000);

        //14. Verify Address Details and Review Your Order
        if (driver.findElement(By.cssSelector("[data-qa='checkout-info']")).isDisplayed() && driver.findElement(By.id("cart_info")).isDisplayed()) {
            System.out.println("Address Details and Review Your Order are VISIBLE");
        } else {System.out.println("ERROR");}

        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.cssSelector(".form-control")).sendKeys("If you would like to add a comment about your order, please write it in the field below.");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[data-qa='name-on-card']")).sendKeys("Serhii Test1");
        driver.findElement(By.cssSelector("[data-qa='card-number']")).sendKeys("1111111111111111");
        driver.findElement(By.cssSelector("[data-qa='cvc']")).sendKeys("111");
        driver.findElement(By.cssSelector("[data-qa='expiry-month']")).sendKeys("12");
        driver.findElement(By.cssSelector("[data-qa='expiry-year']")).sendKeys("2026");
        Thread.sleep(1000);

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("[data-qa='pay-button']")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        //18. Verify success message 'Your order has been placed successfully!'
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

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/download_invoice/0']")).click();

        Thread.sleep(5000);
        String downloadPath = "C:/Users/serhii.breslavskyi/Downloads";
        File folder = new File(downloadPath);
        File[] listOfFiles = folder.listFiles();
        boolean isFileDownloaded = false;

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains("invoice")) {
                isFileDownloaded = true;
                break;
            }
        }

        if (isFileDownloaded) {
            System.out.println("File downloaded successfully.");
        } else {
            System.out.println("File download failed.");
        }


        //20. Click 'Continue' button
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
        Thread.sleep(1000);

        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.cssSelector("[data-qa='account-deleted']"));
        if (accountDeleted.getText().equals("ACCOUNT DELETED!")) {
            System.out.println("Account Deleted is visible");
        } else {System.out.println("Account Deleted is not visible");}

        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

        //delete file
        Thread.sleep(1000);
        String filePath = "C:/Users/serhii.breslavskyi/Downloads/invoice.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted after test.");
            } else {
                System.out.println("Failed to delete the file after test.");
            }
        } else {
            System.out.println("File not found for cleanup.");
        }

        driver.quit();

    }
}