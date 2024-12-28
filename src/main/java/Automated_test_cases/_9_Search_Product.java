package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _9_Search_Product {
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
        System.out.println(currentUrl);
        if (currentUrl.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }

        //4. Click on 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//li/a[contains(text(),'Products')]"));
        productsButton.click();
        Thread.sleep(2000);

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String productsUrl = driver.getCurrentUrl();
        if (productsUrl.equals("https://automationexercise.com/products")) {
            System.out.println("ALL PRODUCTS is opened");
        } else { System.out.println("ALL PRODUCTS is not opened"); }

        //6. Enter product name in search input and click search button
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys("Madame Top For Women");
        WebElement searchButton = driver.findElement(By.id("submit_search"));
        searchButton.click();
        Thread.sleep(3000);

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchResultsTitle = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));
        if (searchResultsTitle.getText().equals("Searched Products")) {
            System.out.println("Searched Products is visible");
        } else { System.out.println("Searched Products is not visible"); }

        //8. Verify all the products related to search are visible
        WebElement searchResults = driver.findElement(By.xpath("//p[contains(text(),'Madame Top For Women')]"));
        if (searchResults.getText().equals("Madame Top For Women")) {
            System.out.println("Correct product is visible");
        } else { System.out.println("Correct product is not visible"); }

        Thread.sleep(3000);
        driver.quit();
    }
}