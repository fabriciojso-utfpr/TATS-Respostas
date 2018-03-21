import org.junit.Test;
import static org.junit.Assert.*;


public class CalculadoraDeSalarioDBATest {
    
   
    @Test
    public void testComSalarioMaiorOuIgualQue2000(){
        Funcionario dba = new Funcionario(
            "Fabricio",
            "fabricio.jhonata@gmail.com",
            3000.00,
            Cargo.DBA
        );
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2250, calc.calcula(dba), 0.0001);
    }
    
    @Test
    public void testComSalarioMenorQue2000(){
        Funcionario dba = new Funcionario(
            "Fabricio",
            "fabricio.jhonata@gmail.com",
            1000.00,
            Cargo.DBA
        );
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(850, calc.calcula(dba), 0.0001);
    }

   
}
