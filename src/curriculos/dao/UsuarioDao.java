package curriculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import curriculos.negocio.Usuario;
import curriculos.util.Conexao;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		connection = Conexao.getConnection();
	}

	public boolean addUsuario(Usuario usuario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into usuario(nome,username,senha,idade,email,estadocivil) values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getUsername());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setString(4, usuario.getIdade());
			preparedStatement.setString(5, usuario.getEmail());
			preparedStatement.setString(6, usuario.getEstadoCivil());

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUsuario(int usuarioId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from usuario where nome=?");

			preparedStatement.setInt(1, usuarioId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from usuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuarioId(rs.getInt("usuarioId"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdade(rs.getString("idade"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEstadoCivil(rs.getString("estadocivil"));

				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	/**
	 * Retorna um usuário dado o seu ID
	 *
	 * @param usuarioId
	 * @return Usuario | null
	 */
	public Usuario getUsuario(int usuarioId) {
		Usuario usuario = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from usuario where usuarioId = ? limit 1");
			preparedStatement.setInt(1, usuarioId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.first();

			usuario = new Usuario(rs.getInt("usuarioId"),
					rs.getString("nome"), rs.getString("username"),
					rs.getString("senha"), rs.getString("idade"),
					rs.getString("email"), rs.getString("estadoCivil"));

			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
