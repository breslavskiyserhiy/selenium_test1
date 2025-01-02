package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//"serhii.test16@gmail.com" "Test12345!"
public class _16_Place_Order_Login_before_Checkout {
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

        //4. Click 'Signup / Login' button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Fill email, password and click 'Login' button
        driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys("serhii.test16@gmail.com");
        driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys("Test12345!");

        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

        //6. Verify 'Logged in as username' at top
        WebElement loggedInUser = driver.findElement(By.xpath("//li/a/b[contains(text(), 'Serhii Test')]"));
        if (loggedInUser.toString().contains("Serhii Test")) {
            System.out.println("Logged in as " + loggedInUser.getText());
        } else {
            System.out.println("ERROR");
        }

        //7. Add products to cart
        WebElement view6Product  = driver.findElement(By.xpath("//a[@href='/product_details/6']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view6Product);
        view6Product.click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button.btn.btn-default.cart")).click();

        //8. Click 'Cart' button
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();

        //9. Verify that cart page is displayed
        Thread.sleep(1000);
        String cartUrl = driver.getCurrentUrl();
        if (cartUrl.equals("https://automationexercise.com/view_cart")) {
            System.out.println("Cart page is opened");
        } else {
            System.out.println("Cart page is not opened");}

        //10. Click Proceed To Checkout
        driver.findElement(By.cssSelector("a.btn.btn-default.check_out")).click();

        //11. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("//h2[@class='heading' and text()='Address Details']"));
        WebElement reviewOrder = driver.findElement(By.xpath("//h2[@class='heading' and text()='Review Your Order']"));
        if (addressDetails.isDisplayed() && reviewOrder.isDisplayed()) {
            System.out.println("Address Details and Review Your Order is visible");
        } else { System.out.println("ERROR"); }

        //12. Enter description in comment text area and click 'Place Order'
        WebElement textArea =driver.findElement(By.cssSelector("textarea.form-control"));
        textArea.sendKeys("This is a test comment for testing purposes test case 16");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();


        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.cssSelector("[data-qa='name-on-card']")).sendKeys("Serhii Test1");
        driver.findElement(By.cssSelector("[data-qa='card-number']")).sendKeys("1111111111111111");
        driver.findElement(By.cssSelector("[data-qa='cvc']")).sendKeys("111");
        driver.findElement(By.cssSelector("[data-qa='expiry-month']")).sendKeys("12");
        driver.findElement(By.cssSelector("[data-qa='expiry-year']")).sendKeys("2026");
        Thread.sleep(1000);

        //14. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("[data-qa='pay-button']")).click();
        Thread.sleep(1000);
        driver.navigate().back();

        //15. Verify success message 'Your order has been placed successfully!'
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

        //16. Click 'Delete Account' button
        //driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //WebElement accountDeleted = driver.findElement(By.cssSelector("[data-qa='account-deleted']"));
        //if (accountDeleted.getText().equals("ACCOUNT DELETED!")) {
        //    System.out.println("Account Deleted is visible");
        //} else {System.out.println("Account Deleted is not visible");}

        //driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

        driver.quit();

    }
}
