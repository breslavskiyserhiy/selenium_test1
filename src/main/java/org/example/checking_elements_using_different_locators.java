package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checking_elements_using_different_locators {    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/AQA/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.wikipedia.org");
    /*
Поле вводу пошуку за ID.
Кнопку пошуку за CSS класом.
Логотип Wikipedia за XPath.
    */

    // Поле вводу пошуку за ID
    try {
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        System.out.println("searchBox is present");
    } catch (NoSuchElementException e) {
        System.out.println("searchBox is not present");
    }
    // Кнопка пошуку за CSS класом
    try {
        WebElement searchButton = driver.findElement(By.cssSelector(".pure-button-primary-progressive"));
        System.out.println("searchButton is present");
    } catch (NoSuchElementException e) {
        System.out.println("searchButton is not present");
    }
    // Логотип Wikipedia за XPath
    try {
        WebElement logoWiki = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']"));
        System.out.println("logoWiki is present");
    } catch (NoSuchElementException e) {
        System.out.println("logoWiki is not present");
    }


    driver.quit();
    }
}
