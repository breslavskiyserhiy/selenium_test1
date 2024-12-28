package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    driver.get("https://the-internet.herokuapp.com/dropdown");
/*
Відкрити сторінку з випадаючим списком.
Перевірити, чи випадаючий список доступний.
Обрати значення в списку за:
    Текстом.
    Індексом.
    Значенням атрибута value.
*/
    WebElement dropdown = driver.findElement(By.id("dropdown"));
    System.out.println("Present " + dropdown.getText());

    Thread.sleep(2000);

    //вибираємо другу опціюв селекторі
    Select dropdownSelect = new Select(dropdown);
    dropdownSelect.selectByIndex(2);

    Thread.sleep(2000);

    //відображення тексту вибраної опції
    WebElement selectedOption = dropdownSelect.getFirstSelectedOption();
    String selectedOptionText = selectedOption.getText();
    System.out.println("Selected item" + selectedOptionText);


    Thread.sleep(20000);
    // Закриття браузера
    driver.quit();
    }
}
