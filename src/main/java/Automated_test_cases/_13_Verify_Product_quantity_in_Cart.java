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

public class _13_Verify_Product_quantity_in_Cart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //2. Navigate to url 'http://automationexercise.com'
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        Thread.sleep(2000);

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

        //4. Click 'View Product' for any product on home page
        WebElement view6Product  = driver.findElement(By.xpath("//a[@href='/product_details/6']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view6Product);
        view6Product.click();
        Thread.sleep(2000);

        //5. Verify product detail is opened
        String product6Url = driver.getCurrentUrl();
        if (product6Url.equals("https://automationexercise.com/product_details/6")) {
            System.out.println("Product 6 page is opened");
        } else {
            System.out.println("Product 6 page is not opened");
        }

        //6. Increase quantity to 4
        WebElement quantityInput = driver.findElement(By.id("quantity"));
        quantityInput.clear();
        quantityInput.sendKeys("4");

        //7. Click 'Add to cart' button
        Thread.sleep(1000);
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.btn.btn-default.cart"));
        System.out.println(addToCartButton.getText());
        addToCartButton.click();
        Thread.sleep(2000);

        //8. Click 'View Cart' button
        WebElement viewCartButton = driver.findElement(By.xpath("//a[u[text()='View Cart']]"));
        viewCartButton.click();


        //9. Verify that product is displayed in cart page with exact quantity
        WebElement product6IsDisplayed = driver.findElement(By.xpath("//a[text()='Summer White Top']"));
        WebElement productQuantityInCart = driver.findElement(By.xpath("//td[@class='cart_quantity']/button[text()='4']"));
        if (product6IsDisplayed.getText().equals("Summer White Top") && productQuantityInCart.getText().equals("4")) {
            System.out.println("Product 6 is displayed, quantity in cart is correct");
        } else {System.out.println("Product 6 is not displayed, quantity in cart is incorrect");}
        Thread.sleep(2000);

        driver.quit();
    }
}