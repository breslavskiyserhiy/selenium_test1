package org.example;
/*
1. Перевірка правильності заголовку веб-сторінки
Опис кейсу:
Відкрити веб-сторінку (наприклад, Google).
еревірити, чи відповідає заголовок сторінки очікуваному.
Кроки:
Відкрийте браузер за допомогою Selenium WebDriver.
Перейдіть на сторінку (наприклад, https://www.google.com).
Перевірте, чи заголовок сторінки дорівнює очікуваному, наприклад, "Google".
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class check_title_on_page {
    public static void main(String[] args) {
        // Вкажіть правильний шлях до ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Створення об'єкта ChromeOptions
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        // Відкриття веб-сторінки
        driver.get("https://www.wikipedia.org");

        // Виведення заголовку сторінки
        String title = driver.getTitle();
        String correctTitle = "Wikipedia";
        if (title.equals(correctTitle)) {
            System.out.println("Test Passed: Title is Correct");
        } else {
            System.out.println("Test Failed: Title is not Correct. Expected Title: " + correctTitle + ", Actual Title: " + title);
        }

        // Закриття браузера
        driver.quit();
    }
}
