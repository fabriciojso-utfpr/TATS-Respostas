
import org.junit.Test;
import static org.junit.Assert.*;

public class FuncionarioTest {
    
    @Test
    public void testaFuncionarioComNomeEmailEsalarioBaseECargo(){
        Funcionario funcionario = new Funcionario(
            "nome", "email", 1200.00, Cargo.DESENVOLVEDOR
        );
        
        assertEquals("nome", funcionario.getNome());
        assertEquals("email", funcionario.getEmail());
        assertEquals(1200.00, funcionario.getSalario(), 0.0001);
        assertEquals(Cargo.DESENVOLVEDOR, funcionario.getCargo());
        
    }
}
