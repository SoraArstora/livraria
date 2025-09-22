package br.com.livraria;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class RegisterTest {
  private static WebDriver driver;
  private static Map<String, Object> vars;
  static JavascriptExecutor js;
  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
  @Test
  public void registerTest() {
    driver.get("http://localhost:8080/register");
    driver.manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Teste");
    driver.findElement(By.id("birthDate")).click();
    driver.findElement(By.id("birthDate")).click();
    driver.findElement(By.id("birthDate")).sendKeys("03-09-2025");
    driver.findElement(By.id("cpf")).click();
    driver.findElement(By.id("cpf")).sendKeys("123.456.789-00");
    WebElement password = driver.findElement(By.id("password"));
    new Actions(driver)
            .scrollToElement(password)
            .perform();
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("11223333456");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("Email@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    WebElement neighbor = driver.findElement(By.id("neighbor"));
    new Actions(driver)
            .scrollToElement(neighbor)
            .perform();
    driver.findElement(By.id("street")).click();
    driver.findElement(By.id("street")).sendKeys("Santa Cruz");
    driver.findElement(By.id("number")).click();
    driver.findElement(By.id("number")).sendKeys("22");
    driver.findElement(By.id("neighbor")).click();
    driver.findElement(By.id("neighbor")).sendKeys("Perracini");
    WebElement state = driver.findElement(By.id("state"));
    new Actions(driver)
            .scrollToElement(state)
            .perform();
    driver.findElement(By.id("cep")).click();
    driver.findElement(By.id("cep")).sendKeys("12345678");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Poá");
    driver.findElement(By.id("state")).click();
    driver.findElement(By.id("state")).sendKeys("SP");
    WebElement delivery = driver.findElement(By.id("delivery"));
    new Actions(driver)
            .scrollToElement(delivery)
            .perform();
    driver.findElement(By.id("country")).click();
    driver.findElement(By.id("country")).sendKeys("Brasil");
    driver.findElement(By.id("delivery")).click();
    WebElement button = driver.findElement(By.cssSelector(".btn-block"));
    new Actions(driver)
            .scrollToElement(button)
            .perform();
    driver.findElement(By.cssSelector(".btn-block")).click();
  }
}
