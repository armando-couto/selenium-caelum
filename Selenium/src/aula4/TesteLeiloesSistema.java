package aula4;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteLeiloesSistema {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		this.driver = new FirefoxDriver();
		leiloes = new LeiloesPage(driver);
		
		// Para garantir o teste deve se criar sempre um usuário no momento do teste de leilão,
		// pois ele depende de um usuário cadastrado.
		aula3.UsuariosPage usuarios = new aula3.UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
	}

	@Test
	public void deveCadastrarUmLeilao() {
		
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);
		
		assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));
		
		driver.close();
	}
}