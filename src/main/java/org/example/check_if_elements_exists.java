package org.example;

/*
Перевірка наявності елементів на сторінці
Опис кейсу:
Відкрити веб-сторінку.
Перевірити наявність певних елементів на сторінці (наприклад, кнопок або текстових блоків).
Кроки:
Відкрийте браузер.
Перейдіть на сторінку.
Використовуючи findElement, перевірте наявність певного елементу на сторінці (наприклад, кнопку чи посилання).
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;

public class check_if_elements_exists {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.wikipedia.org");

        // Перевірка наявності елементів
        try {
            WebElement searchBox = driver.findElement(By.name("search"));
            System.out.println("searchBox is present");
        } catch (NoSuchElementException e) {
            System.out.println("searchBox is not present");
        }

        try {
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button"));
            System.out.println("searchButton is present");
        } catch (NoSuchElementException e) {
            System.out.println("searchButton is not present");
        }

        // Закриття браузера
        driver.quit();
    }
}

