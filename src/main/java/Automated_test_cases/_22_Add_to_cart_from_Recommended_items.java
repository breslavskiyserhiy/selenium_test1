package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class _22_Add_to_cart_from_Recommended_items {
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

        //3. Scroll to bottom of page
        WebElement recomendedItems = driver.findElement(By.id("recommended-item-carousel"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        //4. Verify 'RECOMMENDED ITEMS' are visible
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", recomendedItems);
        Thread.sleep(1000);

        if (recomendedItems.isDisplayed()) {
            System.out.println("'Recomended Items' are displayed");
        } else {System.out.println("'Recomended Items' are not displayed");}

        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("//div[@class='recommended_items']//a[contains(@class, 'add-to-cart')]")).click();
        Thread.sleep(2000);


        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("//p/a[@href='/view_cart']")).click();
        Thread.sleep(2000);

        //7. Verify that product is displayed in cart page
        WebElement cartInfo = driver.findElement(By.id("cart_info"));
        if (cartInfo.isDisplayed()) {
            System.out.println("'Cart Info' are displayed");
        } else {System.out.println("'Cart Info' are not displayed");}

        //quit
        Thread.sleep(2000);
        driver.quit();
    }
}