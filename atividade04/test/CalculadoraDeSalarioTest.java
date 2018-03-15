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
    
    @Test
    public void testaDesenvolvedorComSalarioMaiorQue3000(){
        Funcionario desenvolvedor = new Funcionario(
            "Fabricio",
            "fabricio.jhonata@gmail.com",
            5000.00,
            "desenvolvedor"
        );
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(4000, calc.calcula(desenvolvedor), 0.0001);
    }
    
    @Test
    public void testaDesenvolvedorComSalarioMenorQue3000(){
        Funcionario desenvolvedor = new Funcionario(
            "Fabricio",
            "fabricio.jhonata@gmail.com",
            2500.00,
            "desenvolvedor"
        );
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2250, calc.calcula(desenvolvedor), 0.0001);
    }
   
}
