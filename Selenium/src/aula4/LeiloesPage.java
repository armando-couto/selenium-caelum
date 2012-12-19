package aula4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import aula5.*;

public class LeiloesPage {

	private WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public class URLDaAplicacao {
		public String getUrlBase() { return "http://localhost:8080/leiloes"; }
	}
	
	public void visita() {
		 driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
		  // antigo: driver.get("http://localhost:8080/leiloes/usuarios");
	}

	public NovoLeilaoPage novo() {

		// clica no link de novo leilao
		driver.findElement(By.linkText("Novo Leilão")).click();
		// retorna a classe que representa a nova pagina
		return new NovoLeilaoPage(driver);
	}

	public boolean existe(String produto, double valor, String usuario,
			boolean usado) {

		return driver.getPageSource().contains(produto)
				&& driver.getPageSource().contains(String.valueOf(valor))
				&& driver.getPageSource().contains(usado ? "Sim" : "Não");
	}

	public DetalhesDoLeilaoPage detalhes(int posicao) {
		List<WebElement> elementos = driver.findElements(By.linkText("exibir"));
		elementos.get(posicao - 1).click();
		return new DetalhesDoLeilaoPage(driver);
	}
}