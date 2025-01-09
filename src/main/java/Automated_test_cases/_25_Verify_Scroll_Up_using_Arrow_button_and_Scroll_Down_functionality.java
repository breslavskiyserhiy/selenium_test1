package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class _25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality {
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

        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }

        //4. Scroll down page to bottom
        WebElement recomendedItems = driver.findElement(By.id("recommended-item-carousel"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);


        //5. Verify 'SUBSCRIPTION' is visible
        if (driver.findElement(By.cssSelector(".col-sm-3.col-sm-offset-1")).isDisplayed()) {
            System.out.println("SUBSCRIPTION is visible");
        } else { System.out.println("SUBSCRIPTION is not visible"); }

        //6. Click on arrow at bottom right side to move upward
        driver.findElement(By.id("scrollUp")).click();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen


        if (driver.findElement(By.xpath("//h2[contains(text(), 'Full-Fledged practice website')]")).isDisplayed()) {
            System.out.println("Full Fledged practice website is visible");
        } else {System.out.println("Full Fledged practice website is not visible"); }

        //quit
        driver.quit();
    }
}