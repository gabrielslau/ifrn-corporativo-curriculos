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
    
    public void addUsario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into usuario(nome,username,senha,idade,email,estadocivil) values (?, ?, ? )");

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getUsername());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getIdade());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setString(6, usuario.getEstadoCivil());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUsario(String nome) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from usuario where nome=?");

            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Usuario> getAllUsaruios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuario");
            while (rs.next()) {
            	Usuario usuario = new Usuario();
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
}
