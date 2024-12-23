package org.example;

/*
2. Тестування пошуку на веб-сторінці
Опис кейсу:
Відкрити веб-сторінку, наприклад, Wikipedia.
Знайти елемент введення для пошуку.
Ввести запит у поле пошуку.
Перевірити, чи було перенаправлення на відповідну сторінку.
Кроки:
Відкрийте браузер за допомогою Selenium WebDriver.
Перейдіть на сторінку https://www.wikipedia.org.
Знайдіть поле для пошуку та введіть слово, наприклад, "Selenium".
Клікніть на кнопку пошуку.
Перевірте, чи перенаправило на сторінку з очікуваним заголовком (наприклад, "Selenium — Вікіпедія").
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test_find_field {
    public static void main(String[] args) {
        // Вкажіть правильний шлях до ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Створення об'єкта ChromeOptions
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        // Відкриття веб-сторінки
        driver.get("https://www.wikipedia.org");

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Selenium");

        //searchBox.submit();
        WebElement searchButton = driver.findElement((By.xpath("//*[@id=\"search-form\"]/fieldset/button")));
        searchButton.click();


        // Виведення заголовку сторінки
        String title = driver.getTitle();
        String expectedTitle = "Selenium — Вікіпедія";
        if (title.equals(expectedTitle)) {
            System.out.println("Test Passed: Title is Correct");
        } else {
            System.out.println("Test Failed: Title is not Correct. Expected Title: " + expectedTitle + ", Actual Title: " + title);
        }


        // Закриття браузера
        driver.quit();
    }
}
