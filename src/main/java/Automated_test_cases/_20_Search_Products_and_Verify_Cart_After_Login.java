package Automated_test_cases;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;
import java.util.List;

public class _20_Search_Products_and_Verify_Cart_After_Login {
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
        Actions action = new Actions(driver);

        driver.manage().window().maximize();


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //!!!!Accept
        driver.findElement(By.cssSelector(".fc-primary-button")).click();

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
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".features_items .btn.btn-default.add-to-cart"));

        for (int i = 0; i < addToCartButtons.size(); i++) {
            WebElement button = addToCartButtons.get(i);

            if (button.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']//button[contains(@class, 'close-modal')]")));
                closeButton.click();

                Thread.sleep(1000);
            }
        }

        //9. Click 'Cart' button and verify that products are visible in cart
        WebElement cartButton = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartButton);

        List<WebElement> addToCartProducts = driver.findElements(By.cssSelector("tbody .cart_description h4"));

        for ( WebElement product : addToCartProducts) {
            String productText = product.getText();

            if (productText.contains("Green")) {
                System.out.println("Product: " + productText + " is visible");
            }  else {System.out.println("Product is not visible");}

        }


        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys("serhii.test16@gmail.com");
        driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys("Test12345!");
        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();
        Thread.sleep(1000);

        //11. Again, go to Cart page
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        //12. Verify that those products are visible in cart after login as well
        List<WebElement> addToCartProducts1 = driver.findElements(By.cssSelector("tbody .cart_description h4"));

        for ( WebElement product1 : addToCartProducts1) {
            String productText1 = product1.getText();

            if (productText1.contains("Green")) {
                System.out.println("After Login - Product: " + productText1 + " is visible");
            }  else {System.out.println("After Login - Product is not visible");}

        }

        //Logout
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        System.out.println("Successfull");
    }
}