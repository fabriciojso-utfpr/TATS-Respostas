package br.com.utfpr.DAO;

import br.com.utfpr.dominio.Usuario;

public interface UsuarioDAO {
	public Usuario getByName(String nomeDoUsuario);
}
