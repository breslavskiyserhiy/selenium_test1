package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _20_Search_Products_and_Verify_Cart_After_Login {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/edgedriver_win64/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-popup-blocking"); // Вимкнути спливаючі вікна
        options.addArguments("--disable-blink-features=AutomationControlled"); // Зробити браузер менш помітним для скриптів
        options.addArguments("--disable-extensions"); // Вимкнути розширення
        options.addArguments("--disable-infobars"); // Прибрати інформаційну панель
        options.addArguments("--block-new-web-contents"); // Блокувати нові вкладки/вікна

        WebDriver driver = new EdgeDriver(options);

        driver.manage().window().maximize();


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //!!!!Accept
        //driver.findElement(By.cssSelector(".fc-primary-button")).click();

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//li/a[@href='/products']")).click();

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        String allProductUrl = driver.getCurrentUrl();
        if (allProductUrl.contains("products")) {
            System.out.println("The Product URL is correct: " + allProductUrl);
        } else {System.out.println("ERROR: The Product URL is incorrect: " + allProductUrl);}

        //5. Enter product name "green" in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("green");
        driver.findElement(By.id("submit_search")).click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchText = driver.findElement(By.xpath("//div/h2[contains(text(),'Searched Products')]"));
        if (searchText.getText().contains("SEARCHED PRODUCTS")) {
            System.out.println("'Searched Products' is visible");
        } else {System.out.println("'Searched Products' is not visible");}

        //7. Verify all the products related to search are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'productinfo')]")));

        // Find products containing 'green'
        List<WebElement> greenProducts = driver.findElements(By.xpath("//div[contains(@class, 'productinfo') and .//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'green')]]"));

        // Print the number of products found
        System.out.println("Number of products found: " + greenProducts.size());

        // Print each product's text
        for (WebElement product : greenProducts) {
            String productText = product.getText();
            System.out.println("Product: " + productText);
        }

        //8. Add those products to cart
        List<WebElement> addGreenToCart = driver.findElements(By.cssSelector("a.btn.btn-default.add-to-cart"));
        for (WebElement clickProd : addGreenToCart) {
            clickProd.click();
            driver.findElement(By.xpath("//div[@class='modal-footer']//button[contains(@class, 'close-modal')]")).click();
            break;
        }

        //9. Click 'Cart' button and verify that products are visible in cart

        //10. Click 'Signup / Login' button and submit login details

        //11. Again, go to Cart page

        //12. Verify that those products are visible in cart after login as well
    }
}