package br.com.utfpr.servicos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.com.utfpr.DAO.UsuarioDAO;
import br.com.utfpr.dominio.Usuario;

public class UsuarioValidatorTest {

    private UsuarioDAO usuarioDaoFalso;
    private UsuarioValidator usuarioValidator;

    private void criaUsuarioDaoFalso() {
        usuarioDaoFalso = mock(UsuarioDAO.class);
        when(usuarioDaoFalso.getByName("Josefina")).thenReturn(new Usuario());
    }

    private void criaUsuarioValidator() {
        SenhaValidator senhaValidatorFalso = mock(SenhaValidator.class);
        when(senhaValidatorFalso.verificar("minhasenha")).thenReturn(true);
        when(senhaValidatorFalso.verificar("123senha")).thenReturn(false);

        this.usuarioValidator = new UsuarioValidator(usuarioDaoFalso);
        this.usuarioValidator.setSenhaValidator(senhaValidatorFalso);

    }

    @Before
    public void inicializa() {
        this.criaUsuarioDaoFalso();
        this.criaUsuarioValidator();
    }

    @Test
    public void validaUsuarioNormal() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Fabricio");
        usuario.setSenha("123senha");
        usuario.setSenhaConfirmada("123senha");
        assertTrue(this.usuarioValidator.ehUsuarioValido(usuario));
    }

    @Test(expected = Exception.class)
    public void validaUsuarioComNomeMenorQueCinco() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("fabi");
        usuario.setSenha("123senha");
        usuario.setSenhaConfirmada("123senha");
        this.usuarioValidator.ehUsuarioValido(usuario);
    }

    @Test(expected = Exception.class)
    public void validaUsuarioComSenhasDiferentes() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Fabricio");
        usuario.setSenha("123senha");
        usuario.setSenhaConfirmada("minha342senha");
        this.usuarioValidator.ehUsuarioValido(usuario);
    }

    @Test(expected = Exception.class)
    public void validaUsuarioComSenhasDiferentesDoValidator() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Fabricio");
        usuario.setSenha("minhasenha");
        usuario.setSenhaConfirmada("minhasenha");
        this.usuarioValidator.ehUsuarioValido(usuario);
    }

    @Test
    public void validaUsuarioComCaracteresEspeciaisEmNome() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome(" .!$%####@@");
        usuario.setSenha("123senha");
        usuario.setSenhaConfirmada("123senha");
        assertFalse(this.usuarioValidator.ehUsuarioValido(usuario));
    }
    
    @Test
    public void validaUsuarioComDigitosEmNome() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("123456");
        usuario.setSenha("123senha");
        usuario.setSenhaConfirmada("123senha");
        assertTrue(this.usuarioValidator.ehUsuarioValido(usuario));
    }

    @Test
    public void validaUsuarioComNomeIgualDeOutroUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Josefina");
        usuario.setSenha("123senha");
        usuario.setSenhaConfirmada("123senha");
        try {
            this.usuarioValidator.ehUsuarioValido(usuario);
            fail();
        } catch (Exception e) {
            assertEquals("usuario ja existe", e.getMessage());
        }
    }

}
