package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _5_Register_User_with_existing_email {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //2. Navigate to url 'http://automationexercise.com'
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

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

        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement signUpButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
        if (signUpButton.isDisplayed()) {
            System.out.println("New user SignUp is displayed");
        } else {
            System.out.println("New user SignUp is not displayed");
        }

        //6. Enter name and email address
        Thread.sleep(1000);
        WebElement nameField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
        nameField.sendKeys("Serhii Test11");
        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        emailField.sendKeys("serhii.test123123122@gmail.com");
        Thread.sleep(1000);

        //7. Click 'Signup' button
        signUpButton.click();
        Thread.sleep(2000);

        //8. Verify error 'Email Address already exist!' is visible
        WebElement incorrectEmailMessage = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        System.out.println("Message '" + incorrectEmailMessage.getText() + "' is displayed");
        Thread.sleep(2000);

        driver.quit();
    }
}
