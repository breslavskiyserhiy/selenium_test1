package Automated_test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//"serhii.test123123122@gmail.com" "Test12345!"
public class _2_Login_User_with_correct_email_and_password {
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

        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (loginText.getText().equals("Login to your account")) {
            System.out.println("Login to your account is visible");
        } else {
            System.out.println("Login to your account is not visible");
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

        //9. Click 'Delete Account' button
        /*WebElement deleteAccountButton = driver.findElement(By.xpath("//li/a[contains(text(), 'Delete Account')]"));
        deleteAccountButton.click();

        Thread.sleep(3000);
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deletedAccount = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        if (deletedAccount.isDisplayed()) {
            System.out.println("ACCOUNT DELETED! is visible");
        } else {
            System.out.println("ERROR");
        }*/

        driver.quit();
    }
}