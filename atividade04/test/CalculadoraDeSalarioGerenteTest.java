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
public class CalculadoraDeSalarioGerenteTest {
    
   
    @Test
    public void testComSalarioMaiorOuIgualQue5000(){
        Funcionario dba = new Funcionario(
            "Fabricio",
            "fabricio.jhonata@gmail.com",
            6000.00,
            Cargo.GERENTE
        );
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(4200, calc.calcula(dba), 0.0001);
    }
    
    @Test
    public void testComSalarioMenorQue5000(){
        Funcionario dba = new Funcionario(
            "Fabricio",
            "fabricio.jhonata@gmail.com",
            3000.00,
            Cargo.GERENTE
        );
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2400, calc.calcula(dba), 0.0001);
    }

   
}
