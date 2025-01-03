package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class _20_Search_Products_and_Verify_Cart_After_Login {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
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


        //8. Add those products to cart


        //9. Click 'Cart' button and verify that products are visible in cart
        //10. Click 'Signup / Login' button and submit login details
        //11. Again, go to Cart page
        //12. Verify that those products are visible in cart after login as well
    }
}