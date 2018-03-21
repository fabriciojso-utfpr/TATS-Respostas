import org.junit.Test;
import static org.junit.Assert.*;


public class CalculadoraDeSalarioDesenvolvedorTest {
    
   
    @Test
    public void testComSalarioMaiorQue3000(){
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
    public void testComSalarioMenorQue3000(){
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
