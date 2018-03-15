
import java.util.ArrayList;

class SistemaFinanceiro {

    private ArrayList<Proposta> propostas = new ArrayList<>();
    private double valorDoEmprestimo;

    ArrayList<Proposta> gerarPropostas(Cliente cliente, double valorDoEmprestimo) {
        Validador.validaCliente(cliente);
        this.valorDoEmprestimo = valorDoEmprestimo;
        if (cliente.getSalario() <= 1000.0) {
            this.criaPropostasParaFaixa1();
        } else if (cliente.getSalario() <= 5000.0) {
            this.criaPropostasParaFaixa2();
        } else {
            this.criaPropostasParaFaixa3();
        }
        return this.propostas;
    }
    
 

    private void criaPropostasParaFaixa1() {
        propostas.add(new Proposta(2, valorDoEmprestimo, 2));
        propostas.add(new Proposta(2, valorDoEmprestimo, 3));
    }

    private void criaPropostasParaFaixa2() {
        propostas.add(new Proposta(1.3, valorDoEmprestimo, 2));
        propostas.add(new Proposta(1.5, valorDoEmprestimo, 4));
        propostas.add(new Proposta(1.5, valorDoEmprestimo, 10));
    }

    private void criaPropostasParaFaixa3() {
        propostas.add(new Proposta(1.1, valorDoEmprestimo, 2));
        propostas.add(new Proposta(1.3, valorDoEmprestimo, 4));
        propostas.add(new Proposta(1.3, valorDoEmprestimo, 10));
        propostas.add(new Proposta(1.4, valorDoEmprestimo, 20));
    }

}
