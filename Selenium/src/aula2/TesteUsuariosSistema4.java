package aula2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteUsuariosSistema4 {

	@Test
	public void deveAdicionarUmUsuario() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/leiloes/usuarios/new");

		WebElement email = driver.findElement(By.name("usuario.email"));
		email.submit();

		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

		driver.close();
	}
}