package Automated_test_cases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _6_Contact_Us_Form {
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
    //4. Click on 'Contact Us' button
        WebElement contactUsButton = driver.findElement(By.xpath("//li/a[text()=' Contact us']"));
        contactUsButton.click();

    //5. Verify 'GET IN TOUCH' is visible
        Thread.sleep(2000);
        WebElement getInTouch = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        if (getInTouch.isDisplayed()) {
            System.out.println("'GET IN TOUCH' is visible");
        } else {
            System.out.println("'GET IN TOUCH' is not visible");
        }
    //6. Enter name, email, subject and message
        WebElement nameField = driver.findElement(By.cssSelector("[data-qa='name']"));
        nameField.sendKeys("Serhii");
        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='email']"));
        emailField.sendKeys("serhii.test123123122@gmail.com");
        WebElement subjectField = driver.findElement(By.cssSelector("[data-qa='subject']"));
        subjectField.sendKeys("Field subject test");
        WebElement messageField = driver.findElement(By.cssSelector("[data-qa='message']"));
        messageField.sendKeys("My Message test is heer");

        //7. Upload file
        WebElement uploadButton = driver.findElement(By.xpath("//input[@name='upload_file']"));
        uploadButton.sendKeys("C:\\Users\\serhii.breslavskyi\\Pictures\\1645014814_pasport.jpg");

        //8. Click 'Submit' button
        Thread.sleep(3000);
        WebElement submitButton = driver.findElement(By.cssSelector("[data-qa='submit-button']"));
        submitButton.click();

        //9. Click OK button
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Thread.sleep(2000);
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]"));
        System.out.println(successMessage.getText());

        if (successMessage.getText().contains("Success")) {
            System.out.println("Success message is visible");
        } else {
            System.out.println("Success message is not visible");
        }

        //11. Click 'Home' button and verify that landed to home page successfully
        Thread.sleep(2000);
        WebElement homeButton = driver.findElement(By.cssSelector("a.btn.btn-success[href='/']"));
        homeButton.click();


        String currentUrl2 = driver.getCurrentUrl();
        if (currentUrl2.equals("https://automationexercise.com/")) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page is not opened");
        }

        driver.quit();
    }


}