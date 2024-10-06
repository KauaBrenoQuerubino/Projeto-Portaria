package ControleAcesso.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
public class BancoDeDados {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/portaria";
    private final String username = "root";
    private final String password = "";
    private Connection conexao = null;

    public void conexaoComDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(jdbcURL, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não localizado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    public void cadastrarVisitante(String nome, String identificacao, Date horario, String motivo) throws SQLException {
        String sql = "INSERT INTO visitantes (nome, identificacao, horario, situacao, motivo) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }

        statement = conexao.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, identificacao);
        statement.setTimestamp(3, new Timestamp(horario.getTime()));
        statement.setString(4,"entrou" );
        statement.setString(5, motivo);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Um novo registro foi inserido com sucesso!");
        }
        statement.close();
        conexao.close();


    }



}
