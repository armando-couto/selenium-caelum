package aula3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteUsuariosSistema {

	private WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void inicializa() {
		this.driver = new FirefoxDriver();
		this.usuarios = new UsuariosPage(driver);

		// visitamos a pagina de usuarios
		usuarios.visita();
	}

	@Test
	public void deveAdicionarUmUsuario() {

		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque",
				"ronaldo2009@terra.com.br");

		assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque",
				"ronaldo2009@terra.com.br"));

	}

	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {

		NovoUsuarioPage form = usuarios.novo();

		form.cadastra("", "ronaldo2009@terra.com.br");

		form.validacaoDeNomeObrigatorio();

		driver.close();
	}
	
	@Test
    public void deveAlterarUmUsuario() {
  
        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
        usuarios.altera(1).para("José da Silva", "jose@silva.com");
         
        assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
        assertTrue(usuarios.existeNaListagem("José da Silva", "jose@silva.com"));
    }

	@Test
	public void deveDeletarUmUsuario() {

		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
		assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));

		usuarios.deletaUsuarioNaPosicao(1);

		assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
	}

	@After
	public void encerra() {
		driver.close();
	}
}