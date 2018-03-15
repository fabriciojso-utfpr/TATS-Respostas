
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabriciojso
 */
class SistemaFinanceiroController {

    ArrayList<Proposta> propostas(Cliente cliente, double valorEmprestimo) {
        Validador.validaCliente(cliente);
        return new SistemaFinanceiro().gerarPropostas(cliente, valorEmprestimo);
    }
    
}
