package org.example;

/*
 Відкриваємо веб-сторінку.
Шукаємо елемент, який містить текст, або перевіряємо всю сторінку на наявність конкретного тексту.
Порівнюємо текст на сторінці з очікуваним значенням.
Виводимо результат (чи містить сторінка текст чи ні).
*/

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class find_text_on_page {
    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    driver.get("https://www.wikipedia.org");

    String pageSource = driver.getPageSource();

    if (pageSource.contains("Wikipedia")) {
        System.out.println("Wikipedia found");
    } else {
        System.out.println("Text not found");
    }

    // Закриття браузера
    driver.quit();
}
}
