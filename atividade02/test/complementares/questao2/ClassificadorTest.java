package complementares.questao2;


import org.junit.Test;
import static org.junit.Assert.*;


public class ClassificadorTest {
    
    private final Classificador classificador = new Classificador();
    
    @Test
    public void definirFaixaEtariaTestIdadeInvalida(){
        try{
            this.classificador.definirFaixaEtaria(new Pessoa("Fabricio", -1));
            fail();
        }catch(RuntimeException e){
            assertEquals("idade invalida", e.getMessage());
        }
    }
    
    @Test
    public void definirFaixaEtariaTestCrianca(){
        Pessoa pessoa = new Pessoa("Fabricio", 11);
        String resultado = this.classificador.definirFaixaEtaria(
                pessoa
        );
        assertEquals(pessoa.getNome()+" eh crianca", resultado);
    }
    
    @Test
    public void definirFaixaEtariaTestAdolecente(){
        Pessoa pessoa = new Pessoa("Fabricio", 18);
        String resultado = this.classificador.definirFaixaEtaria(
                pessoa
        );
        assertEquals(pessoa.getNome()+" eh adolescente", resultado);
    }
    
    @Test
    public void definirFaixaEtariaTestAdulto(){
        Pessoa pessoa = new Pessoa("Fabricio", 59);
        String resultado = this.classificador.definirFaixaEtaria(
                pessoa
        );
        assertEquals(pessoa.getNome()+" eh adulto", resultado);
    }
    
    @Test
    public void definirFaixaEtariaTestIdoso(){
        Pessoa pessoa = new Pessoa("Fabricio", 80);
        String resultado = this.classificador.definirFaixaEtaria(
                pessoa
        );
        assertEquals(pessoa.getNome()+" eh idoso", resultado);
    }
}
