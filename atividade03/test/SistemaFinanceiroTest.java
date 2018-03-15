
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaFinanceiroTest {

    private void testaProposta(Proposta proposta, double fator, double valorDoEmprestimo, int numeroDeParcelas) {
        double valorTotal = valorDoEmprestimo * fator;
        assertEquals(valorTotal, proposta.getValorTotal(), 0.0001);
        assertEquals(numeroDeParcelas, proposta.getNumeroDeParcelas());
        assertEquals(valorTotal / numeroDeParcelas, proposta.getValorDaParcela(), 0.0001);
    }

    @Test
    public void testeFaixa1() {
        Cliente cliente = new Cliente("Fabricio", 500.00, 22);
        SistemaFinanceiro sist = new SistemaFinanceiro();
        ArrayList<Proposta> propostas = sist.gerarPropostas(cliente, 1000.0);
        assertEquals(2, propostas.size());

        this.testaProposta(propostas.get(0), 2, 1000.00, 2);
        this.testaProposta(propostas.get(1), 2, 1000.00, 3);
    }

    @Test
    public void testeFaixaAte5000reais() {
        Cliente cliente = new Cliente("Fabricio", 5000.00, 22);
        SistemaFinanceiro sist = new SistemaFinanceiro();
        ArrayList<Proposta> propostas = sist.gerarPropostas(cliente, 1000.0);
        assertEquals(3, propostas.size());

        this.testaProposta(propostas.get(0), 1.3, 1000.00, 2);
        this.testaProposta(propostas.get(1), 1.5, 1000.00, 4);
        this.testaProposta(propostas.get(2), 1.5, 1000.00, 10);
    }
    
    @Test
    public void testeFaixaAcimaDe5000reais() {
        Cliente cliente = new Cliente("Fabricio", 7000.00, 22);
        SistemaFinanceiro sist = new SistemaFinanceiro();
        ArrayList<Proposta> propostas = sist.gerarPropostas(cliente, 1000.0);
        assertEquals(4, propostas.size());

        this.testaProposta(propostas.get(0), 1.1, 1000.00, 2);
        this.testaProposta(propostas.get(1), 1.3, 1000.00, 4);
        this.testaProposta(propostas.get(2), 1.3, 1000.00, 10);
        this.testaProposta(propostas.get(3), 1.4, 1000.00, 20);
    }
    
}
