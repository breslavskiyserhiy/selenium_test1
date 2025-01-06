package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _12_Add_Products_in_Cart {
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

        //4. Click on 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//li/a[contains(text(),'Products')]"));
        productsButton.click();
        Thread.sleep(2000);

        //5.Hover over first product and click 'Add to cart'
        WebElement hover1Product = driver.findElement(By.cssSelector("a[data-product-id='1']"));
        Actions action = new Actions(driver);
        action.moveToElement(hover1Product).perform();
        hover1Product.click();

        //6. Click 'Continue Shopping' button
        Thread.sleep(2000);
        WebElement continueShoppingButton = driver.findElement(By.xpath("//div[@class='modal-footer']//button[contains(@class, 'close-modal')]"));
        continueShoppingButton.click();

        //7. Hover over second product and click 'Add to cart'
        WebElement hover2Product = driver.findElement(By.cssSelector("a[data-product-id='2']"));
        action.moveToElement(hover2Product).perform();
        hover2Product.click();

        //8. Click 'View Cart' button
        WebElement viewCartButton = driver.findElement(By.cssSelector("a[href='/view_cart']"));
        viewCartButton.click();

        //9. Verify both products are added to Cart
        Thread.sleep(2000);
        //WebElement productsCartList  = driver.findElement(By.id("cart_info_table"));
        List<WebElement> products = driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr"));
        int productsCount = products.size();
        if (productsCount == 2) {
            System.out.println("Both products are added to the cart");
        } else { System.out.println("Error");
        }

        //10. Verify their prices, quantity and total price
        Thread.sleep(2000);
        List<WebElement> productPrices = driver.findElements(By.xpath("//table[@id='cart_info_table']//td[@class='cart_price']/p"));
        String product1 = productPrices.get(0).getText();
        String product2 = productPrices.get(1).getText();
        if (product1.equals("Rs. 500") && product2.equals("Rs. 400")) {
            System.out.println("Product price are correct");
        } else { System.out.println("Product price are incorrect");}

        List<WebElement> productQuantity = driver.findElements(By.xpath("//table[@id='cart_info_table']//td[@class='cart_quantity']/button"));
        String productQuantity1 = productQuantity.get(0).getText();
        String productQuantity2 = productQuantity.get(1).getText();
        if (productQuantity1.equals("1") && productQuantity2.equals("1")) {
            System.out.println("Product quantity are correct");
        } else { System.out.println("Product quantity are incorrect");}

        List<WebElement> productTotalPrice = driver.findElements(By.xpath("//table[@id='cart_info_table']//td[@class='cart_total']/p"));
        String productTotalPrice1 = productTotalPrice.get(0).getText();
        String productTotalPrice2 = productTotalPrice.get(1).getText();
        if (productTotalPrice1.equals("Rs. 500") && productTotalPrice2.equals("Rs. 400")) {
            System.out.println("Product total price are correct");
        } else { System.out.println("Product total price are incorrect");}

        Thread.sleep(2000);
        driver.quit();
    }
}