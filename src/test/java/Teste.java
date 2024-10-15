
import com.controleacesso.Model.Morador;
import com.controleacesso.Model.Visitantes;
import com.controleacesso.service.CadastroMoradores;
import com.controleacesso.service.CadastroVisitantes;
import com.controleacesso.service.ControleEntradaSaida;


import java.sql.SQLException;
import java.time.LocalDate;


public class Teste {
    public static void main(String[] args) throws SQLException {
        //Aqui vamos chamar criar o metodo que vai cadastrar o visitante
        CadastroVisitantes cadastroVisitantes = new CadastroVisitantes();


        //Aqui vamos criar um visitante pra teste
        Visitantes visitantes1 = new Visitantes("Pedro Sampaio", "321.123.908-90", "1512C");
        cadastroVisitantes.CadastroVisitante(/*Aqui vamos adicionar o visitante e o motivo da visita*/ visitantes1, "Ir no casa da namorada");

        //--------------------------Novo visitante--------------------------------------------

        //Aqui vamos criar um visitante pra teste
        Visitantes visitantes2 = new Visitantes("Samantha Alencar", "543.987.688-10", "103A");
        cadastroVisitantes.CadastroVisitante(/*Aqui vamos adicionar o visitante e o motivo da visita*/ visitantes2, "Ir na casa da Mae");


        //-----------------------AREA MORADORES------------------------------------------------

        CadastroMoradores cadastroMoradores = new CadastroMoradores();
        LocalDate Aniversario;//AniversarioPadrao

        Aniversario = LocalDate.of(2001, 2, 11);
        Morador morador1 = new Morador("Gabriel Santana", "450.210.688-50", Aniversario ,"101C", "PAC1021");
        cadastroMoradores.CadastroMorador(morador1);

        //--------------------------Novo Morador--------------------------------------------

        Aniversario = LocalDate.of(2001, 2, 11);
        Morador morador2 = new Morador("David Breno", "809.110.668-10", Aniversario ,"1012C", "BUC2021");
        cadastroMoradores.CadastroMorador(morador2);




    }
}
