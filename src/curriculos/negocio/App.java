package curriculos.negocio;

import java.util.ArrayList;
import java.util.List;

public class App {
	private static App instancia;
	private List<Usuario> usuarios;
	private List<Curriculo> curriculos;

	public App(){
		super();
		usuarios = new ArrayList<Usuario>();
		curriculos = new ArrayList<Curriculo>();
	}

	/**
	 * Padrão Singleton
	 * @return instancia única de App
	 */
	public static App getInstancia() {
		if (instancia == null) {
			instancia = new App();
		}
		return instancia;
	}

	public List<Curriculo> getCurriculos() {
		return this.curriculos;
	}

	/**
	 * Insere um novo usuário
	 *
	 * @param usuario
	 * @return boolean
	 */
	public boolean adicionaUsuario(Usuario usuario) {
		if (usuario != null && !this.usuarios.contains(usuario)) {
			this.usuarios.add(usuario);
			return true;
		}
		return false;
	}

	/**
	 * Insere um novo currículo
	 *
	 * @param curriculo
	 * @return boolean
	 */
	public boolean adicionaCurriculo(Curriculo curriculo) {
		if (curriculo != null && !this.curriculos.contains(curriculo)) {
			this.curriculos.add(curriculo);
			return true;
		}
		return false;
	}

	/**
	 * Verifica se o usuário existe pelo username
	 *
	 * @param username
	 * @return boolean
	 */
	public boolean hasLogin(String username) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Autentica o usuário na aplicação
	 *
	 * @param username
	 * @param senha
	 * @return mixed null or Usuario
	 */
	public Usuario autenticar(String username, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsername().equals(username)
					&& usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}
}
