package br.com.utfpr.dominio;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.utfpr.dominio.Usuario;

public class UsuarioTest {

	@Test
	public void criaUmUsuarioVerificandoSeusAtributos() {
		Usuario usuario = new Usuario();
		usuario.setNome("Fabricio");
		usuario.setSenha("123senha");
		usuario.setSenhaConfirmada("123senha");
		
		assertEquals("Fabricio", usuario.getNome());
		assertEquals("123senha", usuario.getSenha());
		assertEquals("123senha", usuario.getSenhaConfirmada());
	}

}