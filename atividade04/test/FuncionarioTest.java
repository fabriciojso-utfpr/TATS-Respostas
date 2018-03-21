
import org.junit.Test;


public class FuncionarioTest {
    
    @Test
    public void testaFuncionarioComNomeEmailEsalarioBaseECargo(){
        Funcionario funcionario = new Funcionario(
            "nome", "email", 1200.00, "cargo"
        );
    }
}
