package P4_1;

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
        // 1. Configuración y apertura de página
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
            driver.manage().window().maximize();
            System.out.println("Página abierta correctamente.");

            // 2. Ingresar información en campos de texto
            // Usamos ID donde es posible
            WebElement textInput = driver.findElement(By.id("my-text-id"));
            textInput.sendKeys("Usuario de Prueba");

            // Password y Textarea no tienen ID, usamos name
            WebElement passwordInput =
                    driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("Password123");

            WebElement textArea = driver.findElement(By.name("my-textarea"));
            textArea.sendKeys("Esta es una prueba de automatizació con Selenium.");

            // 3. Seleccionar opción en Dropdown
            WebElement dropdown = driver.findElement(By.name("my-select"));
            Select selectMenu = new Select(dropdown);
            selectMenu.selectByValue("2"); // Selecciona "Two"
            System.out.println("Dropdown seleccionado.");

            Thread.sleep(1000); //Es como un delay que es lo que se hace en selenium


            // 4. Interactuar con Checkbox y Radio Button
            // Usamos ID para el Checkbox 1 y Radio 1
            WebElement checkbox = driver.findElement(By.id("my-check-2"));
            if(!checkbox.isSelected()) {
                checkbox.click();
            }

            WebElement radioButton = driver.findElement(By.id("my-radio-2"));
            radioButton.click();

            // Interacción con Date Picker (enviando texto directamente)
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys("05/28/2026");

            System.out.println("Interacciones de selección completadas.");

            // 5. Presionar el botón Submit
            // Usamos un selector de CSS para el botón
            WebElement submitBtn =
                    driver.findElement(By.cssSelector("button[type='submit']"));
            submitBtn.click();

            Thread.sleep(1000); //Es como un delay que es lo que se hace en selenium

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}