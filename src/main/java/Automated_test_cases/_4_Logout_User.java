package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _4_Logout_User { public static void main(String[] args) {
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
    email.sendKeys("serhii.test123123122@gmail.com");
    WebElement password = driver.findElement(By.cssSelector("[data-qa='login-password']"));
    password.sendKeys("Test12345!");


    //7. Click 'login' button
    WebElement loginButton = driver.findElement(By.cssSelector("[data-qa='login-button']"));
    loginButton.click();

    //8. Verify that 'Logged in as username' is visible
    WebElement loggedInUser = driver.findElement(By.xpath("//li/a/b[contains(text(), 'Serhii Test11')]"));
    if (loggedInUser.toString().contains("Serhii Test11")) {
        System.out.println("Logged in as " + loggedInUser.getText());
    } else {
        System.out.println("ERROR");
    }

    //9. Click 'Logout' button
    WebElement logoutButton = driver.findElement(By.xpath("//li/a[contains(text(), 'Logout')]"));
    logoutButton.click();

    //10. Verify that user is navigated to login page
    driver.getCurrentUrl();
    System.out.println("Current url is: " + driver.getCurrentUrl());

    driver.quit();
}
}
