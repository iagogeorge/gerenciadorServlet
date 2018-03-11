package br.com.estudos.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.estudos.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("iagogeorge20@gmail.com", new Usuario("iagogeorge20@gmail.com","123456"));
		
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
