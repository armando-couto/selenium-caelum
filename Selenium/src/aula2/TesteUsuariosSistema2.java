package aula2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteUsuariosSistema2 {

	@Test
	public void deveAdicionarUmUsuario() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/usuarios/new");

		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		nome.sendKeys("Adriano Xavier");
		email.sendKeys("axavier@empresa.com.br");
		nome.submit();

		boolean achouNome = driver.getPageSource().contains("Adriano Xavier");
		boolean achouEmail = driver.getPageSource().contains("axavier@empresa.com.br");

		assertTrue(achouNome);
		assertTrue(achouEmail);

		driver.close();
	}
}