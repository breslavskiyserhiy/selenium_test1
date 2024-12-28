package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _3_Login_User_with_incorrect_email_and_password {
    public static void main(String[] args) {
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

        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.cssSelector("[data-qa='login-email']"));
        email.sendKeys("1serhii.1test123123122@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("[data-qa='login-password']"));
        password.sendKeys("1@Test12345!");


        //7. Click 'login' button
        WebElement loginButton = driver.findElement(By.cssSelector("[data-qa='login-button']"));
        loginButton.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrectMessage = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        System.out.println(incorrectMessage.getText());

        driver.quit();
    }
}
