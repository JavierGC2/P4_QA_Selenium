package P4_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class P4_Selenium {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Driver inicializado.");
    }

    @Test
    public void fullFormTest() {
        try {
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
            System.out.println("Página abierta correctamente.");

            // 1. Campo de texto (ID)
            WebElement textInput = driver.findElement(By.id("my-text-id"));
            textInput.sendKeys("Usuario de Prueba");

            // 2. Password y textarea utilizamos name
            WebElement passwordInput = driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("Password123");

            WebElement textArea = driver.findElement(By.name("my-textarea"));
            textArea.sendKeys("Prueba sin Healenium.");

            // 3. Dropdown utilizamos name
            WebElement dropdown = driver.findElement(By.name("my-select"));
            Select selectMenu = new Select(dropdown);
            selectMenu.selectByValue("2");

            Thread.sleep(1000);

            // 4. Checkbox y radio utilizando ID
            WebElement checkbox = driver.findElement(By.id("my-check-2"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            WebElement radioButton = driver.findElement(By.id("my-radio-2"));
            radioButton.click();

            // 5. Date
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys("05/25/2026");

            // 6. Submit
            WebElement submitBtn =
                    driver.findElement(By.cssSelector("button[type='submit']"));
            submitBtn.click();

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver cerrado correctamente.");
        }
    }
}