package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _7_Verify_Test_Cases_Page {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //2. Navigate to url 'http://automationexercise.com'
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        Thread.sleep(3000);


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

        //4. Click on 'Test Cases' button
        WebElement testCasesButton = driver.findElement(By.xpath("//li/a[contains(text(),' Test Cases')]"));
        testCasesButton.click();
        Thread.sleep(3000);

        //5. Verify user is navigated to test cases page successfully
        String currentTestCasesUrl = driver.getCurrentUrl();
        if (currentTestCasesUrl.equals("https://automationexercise.com/test_cases")) {
            System.out.println("Test cases page is opened");
        } else {
            System.out.println("Test cases page is not opened");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}