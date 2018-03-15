package atividade02;

import static org.junit.Assert.*;

import org.junit.Test;

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
