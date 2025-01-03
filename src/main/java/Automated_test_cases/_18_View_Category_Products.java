package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _18_View_Category_Products {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //!!!!Accept
        driver.findElement(By.cssSelector(".fc-primary-button")).click();

        //3. Verify that categories are visible on left side bar
        WebElement categories = driver.findElement(By.id("accordian"));
        if (categories.isDisplayed()) {
            System.out.println("Category are visible");
        } else {System.out.println("Category aren't ");}

        //4. Click on 'Women' category
        driver.findElement(By.xpath("//h4/a[@href='#Women']")).click();
        Thread.sleep(1000);

        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//li/a[@href='/category_products/1']")).click();
        Thread.sleep(1000);

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement dressProducts = driver.findElement(By.cssSelector("h2.title.text-center"));
        if (dressProducts.isDisplayed() && dressProducts.getText().equals("WOMEN - DRESS PRODUCTS")) {
            System.out.println("Dress product are visible");
        } else {System.out.println("Dress product are not visible");}

        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//h4/a[@href='#Men']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li/a[@href='/category_products/6']")).click();
        Thread.sleep(1000);

        //8. Verify that user is navigated to that category page
        WebElement jeansProducts = driver.findElement(By.cssSelector("h2.title.text-center"));
        if (jeansProducts.isDisplayed() && jeansProducts.getText().equals("MEN - JEANS PRODUCTS")) {
            System.out.println("Jeans product are visible");
        } else {System.out.println("Jeans product are not visible");}

        driver.quit();
    }
}
