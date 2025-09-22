package br.com.livraria;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class UpdateTest {
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
  public void updateTest() {
    driver.get("http://localhost:8080/perfil");
    driver.manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Lucas Silva");
    driver.findElement(By.id("cpf")).click();
    driver.findElement(By.id("cpf")).clear();
    driver.findElement(By.id("cpf")).sendKeys("321.564.897-44");
    WebElement button = driver.findElement(By.cssSelector(".btn-block"));
    new Actions(driver)
            .scrollToElement(button)
            .perform();
    driver.findElement(By.cssSelector(".btn-block")).click();
  }
}
