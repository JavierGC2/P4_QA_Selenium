package P4_1;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class P4_Healenium {

    @Test
    public void fullFormTest() {

        WebDriverManager.chromedriver().setup();

        // Driver original
        WebDriver original = new ChromeDriver();

        // Driver con Healenium
        SelfHealingDriver driver = SelfHealingDriver.create(original);

        try {
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
            driver.manage().window().maximize();
            System.out.println("Página abierta correctamente.");

            // 2. Campos de texto
            WebElement textInput = driver.findElement(By.id("my-text-id"));
            textInput.sendKeys("Usuario de Prueba");

            WebElement passwordInput =
                    driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("Password123");

            WebElement textArea =
                    driver.findElement(By.name("my-textarea"));
            textArea.sendKeys("Esta es una prueba de automatización con Healenium.");

            // 3. Dropdown
            WebElement dropdown = driver.findElement(By.name("my-select"));
            Select selectMenu = new Select(dropdown);
            selectMenu.selectByValue("2");
            System.out.println("Dropdown seleccionado.");

            Thread.sleep(1000);

            // 4. Checkbox y Radio
            WebElement checkbox = driver.findElement(By.id("my-check-2"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            WebElement radioButton = driver.findElement(By.id("my-radio-2"));
            radioButton.click();

            // Date picker
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys("05/28/2026");

            System.out.println("Interacciones completadas.");

            // 5. Submit
            WebElement submitBtn =
                    driver.findElement(By.cssSelector("button[type='submit']"));
            submitBtn.click();

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}