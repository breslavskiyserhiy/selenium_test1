package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class _8_Verify_All_Products_and_product_detail_page {
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
        } else {
            System.out.println("ALL PRODUCTS is not opened");
        }

        //6. The products list is visible
        WebElement productsList  = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
        List<WebElement> products = productsList.findElements(By.xpath("//div[@class='single-products']"));
        int productsCount = products.size();
        if (productsCount > 0) {
            System.out.println("All products is visible, count is " + productsCount );
        } else { System.out.println("All products is not visible");
        }

        //7. Click on 'View Product' of first product
        WebElement view1Product  = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", view1Product);
        view1Product.click();
        Thread.sleep(2000);

        //8. User is landed to product detail page
        String product1Url = driver.getCurrentUrl();
        if (product1Url.equals("https://automationexercise.com/product_details/1")) {
            System.out.println("Product 1 page is opened");
        } else {
            System.out.println("Product 1 page is not opened");
        }

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement productNameDetail = driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]"));
        if  (!productNameDetail.getText().isBlank()) {
            System.out.println("Product name is visible");
        } else { System.out.println("Product name is not visible"); }

        WebElement categoryDetail = driver.findElement(By.xpath("//p[contains(text(),'Category')]"));
        if  (!categoryDetail.getText().isBlank()) {
            System.out.println("Product category is visible");
        } else { System.out.println("Product category is not visible"); }

        WebElement priceDetail = driver.findElement(By.xpath("//span[contains(text(),'Rs')]"));
        if  (!priceDetail.getText().isBlank()) {
            System.out.println("Product price is visible");
        } else { System.out.println("Product price is not visible"); }

        WebElement availabilityDetail = driver.findElement(By.xpath("//p/b[contains(text(),'Availability')]"));
        if  (!availabilityDetail.getText().isBlank()) {
            System.out.println("Product availability is visible");
        } else { System.out.println("Product availability is not visible"); }

        WebElement conditionDetail = driver.findElement(By.xpath("//p/b[contains(text(),'Condition')]"));
        if  (!conditionDetail.getText().isBlank()) {
            System.out.println("Product condition is visible");
        } else { System.out.println("Product condition is not visible"); }

        WebElement brandDetail = driver.findElement(By.xpath("//p/b[contains(text(),'Brand')]"));
        if  (!brandDetail.getText().isBlank()) {
            System.out.println("Product brand is visible");
        } else { System.out.println("Product brand is not visible"); }

        Thread.sleep(2000);
        driver.quit();
    }
}