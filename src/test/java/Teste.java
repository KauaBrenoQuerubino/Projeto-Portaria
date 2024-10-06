
import ControleAcesso.Repository.BancoDeDados;
import ControleAcesso.service.CadastroVisitantes;


import java.sql.SQLException;


public class Teste {
    public static void main(String[] args) throws SQLException {
        CadastroVisitantes cdt = new CadastroVisitantes();
        cdt.Cadastro("Nome", "1234", "Motivo");



    }
}
