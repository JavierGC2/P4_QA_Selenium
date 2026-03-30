package P4_1;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class P4_Healenium {

    @Test
    public void fullFormTest() {
        // Se elimina WebDriverManager, Selenium 4 lo maneja nativamente.
        WebDriver original = new ChromeDriver();
        SelfHealingDriver driver = SelfHealingDriver.create(original);

        // Inicializamos WebDriverWait con un tiempo máximo de 10 segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
            driver.manage().window().maximize();
            System.out.println("Página abierta correctamente.");

            // 2. Campos de texto con esperas explícitas
            WebElement textInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id")));
            textInput.sendKeys("Usuario de Prueba");

            WebElement passwordInput = driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("Password123");

            WebElement textArea = driver.findElement(By.name("my-textarea"));
            textArea.sendKeys("Esta es una prueba de automatización con Healenium.");

            // 3. Dropdown
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.name("my-select")));
            Select selectMenu = new Select(dropdown);
            selectMenu.selectByValue("2");
            System.out.println("Dropdown seleccionado.");

            // 4. Checkbox y Radio
            // Reemplazamos el Thread.sleep asegurándonos de que el checkbox interactuable
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("my-check-2")));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("my-radio-2")));
            radioButton.click();

            // Date picker
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys("05/28/2026");

            System.out.println("Interacciones completadas.");

            // 5. Submit
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            submitBtn.click();

            // Si necesitas validar que el submit fue exitoso, usa otra espera explícita en lugar de un sleep final.
            // Ejemplo: wait.until(ExpectedConditions.urlContains("submitted"));

        } finally {
            // El finally siempre se ejecuta, garantizando el cierre. Se elimina el catch de InterruptedException.
            if (driver != null) {
                driver.quit();
            }
        }
    }
}