
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteValidadorTest {

    @Test
    public void testeUsuarioComNomeVazio() {
        try {
            Cliente cliente = new Cliente("", 7000.00, 22);
            Validador.validaCliente(cliente);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O nome do usuário não pode ser vazio", e.getMessage());
        }
    }

    @Test
    public void testeUsuarioComSalarioMenorOuIgualAzero() {
        try {
            Cliente cliente = new Cliente("Fabricio", 0, 22);
            Validador.validaCliente(cliente);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O salario deve ser maior que zero", e.getMessage());
        }
    }

    @Test
    public void testeUsuarioComIdadeMenorQue18() {
        try {
            Cliente cliente = new Cliente("Fabricio", 17, 17);
            Validador.validaCliente(cliente);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A idade deve ser entre 18 e 70", e.getMessage());
        }
    }

    @Test
    public void testeUsuarioComIdadeMaiorQue70() {
        try {
            Cliente cliente = new Cliente("Fabricio", 71, 71);
            Validador.validaCliente(cliente);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A idade deve ser entre 18 e 70", e.getMessage());
        }
    }

}
