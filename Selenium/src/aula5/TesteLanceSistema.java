package aula5;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import aula4.LeiloesPage;

public class TesteLanceSistema {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		this.driver = new FirefoxDriver();
		driver.get("http://localhost:8080/apenas-teste/limpa");
		
		new CriadorDeCenarios(driver)
	        .umUsuario("Paulo Henrique", "paulo@henrique.com")
	        .umUsuario("José Alberto", "jose@alberto.com")
	        .umLeilao("Paulo Henrique", "Geladeira", 100, false);
		
		/* Antes era assim ai no exercício 2 criamos a classe CriadorDeCenarios.java
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
		usuarios.novo().cadastra("José Alberto", "jose@alberto.com");
		
		leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
		*/
	}

	@Test
	public void deveFazerUmLance() {
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
		
		lances.lance("José Alberto", 150);
		
		assertTrue(lances.existeLance("José Alberto", 150));
		
		driver.close();
	}
}