package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class _19_View_Cart_BrandProducts {
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

        //4. Verify that Brands are visible on left side bar
        WebElement brands = driver.findElement(By.cssSelector(".brands-name"));
        if (brands.isDisplayed()) {
            System.out.println("Brands Displayed");
        } else {System.out.println("Brands Not Displayed");}

        //5. Click on any brand name("BABYHUG")
        WebElement babyHugButton = driver.findElement(By.xpath("//li/a[@href='/brand_products/Babyhug']"));
        action.moveToElement(babyHugButton).perform();
        babyHugButton.click();


        //6. Verify that user is navigated to BABYHUG brand page and brand products are displayed
        String babyhugUrl = driver.getCurrentUrl();
        WebElement babyhugText = driver.findElement(By.xpath("//div/h2[contains(text(),'Babyhug')]"));
        if (babyhugUrl.equals("https://automationexercise.com/brand_products/Babyhug") && babyhugText.isDisplayed()) {
            System.out.println("Babyhug Displayed");
        } else {System.out.println("Babyhug Not Displayed");}

        //7. On left side bar, click on any other brand link "BIBA"
        WebElement bibaButton = driver.findElement(By.xpath("//li/a[@href='/brand_products/Biba']"));
        action.moveToElement(bibaButton).perform();
        bibaButton.click();

        //8. Verify that user is navigated to that brand page and can see products
        String bibaUrl = driver.getCurrentUrl();
        WebElement bibaText = driver.findElement(By.xpath("//div/h2[contains(text(),'Biba')]"));
        if (bibaUrl.equals("https://automationexercise.com/brand_products/Biba") && bibaText.isDisplayed()) {
            System.out.println("Biba Displayed");
        } else {System.out.println("Biba Not Displayed");}

        driver.quit();
    }
}