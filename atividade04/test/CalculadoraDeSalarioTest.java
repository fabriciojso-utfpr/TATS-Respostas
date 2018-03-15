/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fabriciojso
 */
public class CalculadoraDeSalarioTest {
    
    @Test
    public void testaFuncionarioComNomeEmailEsalarioBaseECargo(){
        Funcionario funcionario = new Funcionario(
            "nome", "email", 1200.00, "cargo"
        );
    }
}
