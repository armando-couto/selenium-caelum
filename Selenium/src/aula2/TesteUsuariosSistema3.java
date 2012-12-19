package aula2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteUsuariosSistema3 {

	@Test
	public void deveAdicionarUmUsuario() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/leiloes/usuarios/new");

		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		email.sendKeys("axavier@empresa.com.br");
		nome.submit();

		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

		driver.close();
	}
}