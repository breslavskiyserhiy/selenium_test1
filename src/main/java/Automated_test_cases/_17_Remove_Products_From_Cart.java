package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _17_Remove_Products_From_Cart {
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

        //4. Add products to cart
        WebElement view6Product  = driver.findElement(By.xpath("//a[@href='/product_details/6']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view6Product);
        view6Product.click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button.btn.btn-default.cart")).click();

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

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.cssSelector(".cart_quantity_delete")).click();

        //8. Verify that product is removed from the cart
        WebElement emptyCartMessage = driver.findElement(By.xpath("//*[contains(text(), 'Cart is empty!')]"));
        if (emptyCartMessage.getText().equals("Cart is empty!")) {
            System.out.println("Cart is empty!");
        } else {System.out.println("Cart is not empty!");}

        driver.quit();


    }
}
