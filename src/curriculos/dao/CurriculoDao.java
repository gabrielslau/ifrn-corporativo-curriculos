package curriculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import curriculos.negocio.Curriculo;
import curriculos.util.Conexao;

public class CurriculoDao {
	private Connection connection;
	
    public CurriculoDao() {
        connection = Conexao.getConnection();
    }
    public void addCurriculo(Curriculo curriculo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into curriculo(objetivo,qualificacoes,idiomas,link1,link2) values (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, curriculo.getObjetivo());
            preparedStatement.setString(2, curriculo.getQualificacoes());
            preparedStatement.setString(3, curriculo.getIdiomas());
            preparedStatement.setString(4, curriculo.getLink1());
            preparedStatement.setString(5, curriculo.getLink2());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCurriculo(int curriculoId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from curriculo where curriculoId=?");

            preparedStatement.setInt(1, curriculoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Curriculo> getAllCurriculo() {
        List<Curriculo> curriculos = new ArrayList<Curriculo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from curriculo");
            while (rs.next()) {
            	Curriculo curriculo = new Curriculo();
            	curriculo.setObjetivo(rs.getString("objetivo"));
            	curriculo.setQualificacoes(rs.getString("qualificacoes"));
            	curriculo.setIdiomas(rs.getString("idiomas"));
            	curriculo.setLink1(rs.getString("link1"));
            	curriculo.setLink2(rs.getString("link2"));
   
            	curriculos.add(curriculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return curriculos;
    }
}
