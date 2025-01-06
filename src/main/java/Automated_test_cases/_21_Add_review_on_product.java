package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class _21_Add_review_on_product {
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

        //5. Click on 'View Product' button "Frozen Tops For Kids /product_details/13"
        WebElement view13Product = driver.findElement(By.xpath("//li/a[@href='/product_details/13']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view13Product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view13Product);

        //6. Verify 'Write Your Review' is visible
        Thread.sleep(2000);
        WebElement writeYourReview = driver.findElement(By.cssSelector(".category-tab.shop-details-tab"));
        if (writeYourReview.isDisplayed()) {
            System.out.println("'Write Your Review' is visible");
        } else {System.out.println("'Write Your Review' is not visible");}

        //7. Enter name, email and review
        Thread.sleep(5000);
        driver.findElement(By.id("name")).sendKeys("Serhii Test16");
        driver.findElement(By.id("email")).sendKeys("serhii.test16@gmail.com");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("review")));
        driver.findElement(By.id("review")).sendKeys("this is a review for your product");


        //8. Click 'Submit' button
        driver.findElement(By.id("button-review")).click();

        //9. Verify success message 'Thank you for your review.'
        WebElement message = driver.findElement(By.cssSelector(".alert-success.alert"));
        if (message.isDisplayed()) {
            System.out.println("'Message' is visible");
        } else {System.out.println("'Message' is not visible");}

        //quit
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Successfull case");
    }
}