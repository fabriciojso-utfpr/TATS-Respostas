package complementares.questao1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class acharExtremosTest {

    private Utilitario utilitario;

    @Before
    public void inicializa() {
        this.utilitario = new Utilitario();
    }

    @Test
    public void acharExtremosComVetor01() throws Exception {
        int vetor[] = {1, 2, 3, 4, 5, 6};
        Extremos extremos = this.utilitario.acharExtremos(vetor);

        assertEquals(extremos.getMenor(), vetor[0]);
        assertEquals(extremos.getMaior(), vetor[5]);
        assertEquals(extremos.getIndiceMenor(), 0);
        assertEquals(extremos.getIndiceMaior(), 5);
    }

    @Test
    public void acharExtremosComVetor02() throws Exception {
        int vetor[] = {1, 99, 3, -5, 8};
        Extremos extremos = this.utilitario.acharExtremos(vetor);

        assertEquals(extremos.getMenor(), vetor[3]);
        assertEquals(extremos.getMaior(), vetor[1]);
        assertEquals(extremos.getIndiceMenor(), 3);
        assertEquals(extremos.getIndiceMaior(), 1);
    }

    @Test
    public void acharExtremosComVetorVazio() {
        int vetor[] = {};
        try {
            Extremos extremos = this.utilitario.acharExtremos(vetor);
            fail();
        } catch (Exception e) {
            assertEquals("vetor com zero elementos", e.getMessage());
        }
    }

    @Test
    public void acharExtremosComVetorNulo() {
        int vetor[] = null;
        try {
            Extremos extremos = this.utilitario.acharExtremos(vetor);
            fail();
        } catch (Exception e) {
            assertEquals("vetor nao pode ser nulo", e.getMessage());
        }
    }
}
