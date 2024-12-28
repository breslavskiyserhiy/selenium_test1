package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class checkbox {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    driver.get("https://the-internet.herokuapp.com/checkboxes");
/*
Перевіряє, чи всі чекбокси на сторінці вже встановлені.
Якщо ні, встановлює всі чекбокси.
Потім знімає вибір із другого чекбоксу.
*/
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

    //перевірка наявності чекбоксів на сторінці
    for (WebElement checkbox : checkboxes) {
        if (checkbox.isDisplayed()) {
            System.out.println("Checkbox is displayed");
            System.out.println("Selected: " + checkbox.isSelected());
        } else {
            System.out.println("Checkbox is not selected");
        }
    // якщо не вибраний чекбокс то вибрати його
        Thread.sleep(2000);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Selected - expected true// - actual - " + checkbox.isSelected());
    }

    //зняти вибір другого чекбокса
        Thread.sleep(2000);
        if(checkboxes.size() > 0){
            WebElement secondCheckbox = checkboxes.get(1);
            if (secondCheckbox.isSelected()) {}
            secondCheckbox.click();
            System.out.println("Second checkbox is deselected");
        }
        Thread.sleep(2000);
    driver.quit();
 }
}
