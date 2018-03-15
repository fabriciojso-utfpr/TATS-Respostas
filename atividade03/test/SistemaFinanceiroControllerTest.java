import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class SistemaFinanceiroControllerTest {
    
    @Test
    public void testaValidacaoDoCliente(){
        Cliente cliente = new Cliente("Fabricio", 500.00, 22);
        SistemaFinanceiroController controller = new SistemaFinanceiroController();
        ArrayList<Proposta> propostas = controller.propostas(cliente, 1000);
        assertEquals(2, propostas.size());
    }
}
