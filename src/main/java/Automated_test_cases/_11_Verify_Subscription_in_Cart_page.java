package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _11_Verify_Subscription_in_Cart_page {
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

        //4. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//li/a[contains(text(),'Cart')]"));
        cartButton.click();
        Thread.sleep(2000);

        //5. Scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        //6. Verify text 'SUBSCRIPTION'
        WebElement subscriptionText = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        if (subscriptionText.getText().equals("SUBSCRIPTION")) {
            System.out.println("Text 'Subscription' is displayed");
        } else { System.out.println("Text 'Subscription' is not displayed"); }

        //7. Enter email address in input and click arrow button
        WebElement subscriptionEmailInput = driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
        subscriptionEmailInput.sendKeys("serhii.test123123122@gmail.com");
        WebElement arrowButton = driver.findElement(By.id("subscribe"));
        arrowButton.click();

        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement subscriptionSuccess = driver.findElement(By.xpath("//*[@id='success-subscribe']"));
        if (subscriptionSuccess.getText().equals("You have been successfully subscribed!")) {
            System.out.println("Text 'You have been successfully subscribed!' is displayed");
        } else { System.out.println("Text 'You have been successfully subscribed!' is not displayed"); }

        driver.quit();
    }
}
