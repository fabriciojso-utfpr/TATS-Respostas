package complementares.questao3;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TurmaControllerTest {

    @Test
    public void cadastrarTurmaCodigoDisciplinaInvalidoTest() {
        TurmaDAO turmaDAO = mock(TurmaDAO.class);
        VerificadorDeCodigos vf = mock(VerificadorDeCodigos.class);
        when(vf.verificarCodigoDisciplina("")).thenReturn(false);

        TurmaController tc = new TurmaController(turmaDAO);
        tc.setVerificador(vf);

        Turma turma = new Turma();
        turma.setCodDisciplina("");
        turma.setCodTurma("ABC");
        turma.setMaximoAlunos(100);
        String result = tc.cadastrarTurma(turma);

        assertEquals("codigo disciplina invalido", result);
    }

    @Test
    public void cadastrarTurmaCodigoTurmaInvalidoTest() {
        TurmaDAO turmaDAO = mock(TurmaDAO.class);
        VerificadorDeCodigos vf = mock(VerificadorDeCodigos.class);
        when(vf.verificarCodigoDisciplina("abc")).thenReturn(true);
        when(vf.verificarCodigoTurma("")).thenReturn(false);

        TurmaController tc = new TurmaController(turmaDAO);
        tc.setVerificador(vf);

        Turma turma = new Turma();
        turma.setCodDisciplina("abc");
        turma.setCodTurma("");
        turma.setMaximoAlunos(100);
        String result = tc.cadastrarTurma(turma);

        assertEquals("codigo turma invalido", result);
    }

    @Test
    public void cadastrarTurmaExistenteTest() {
        TurmaDAO turmaDAO = mock(TurmaDAO.class);
        VerificadorDeCodigos vf = mock(VerificadorDeCodigos.class);

        when(vf.verificarCodigoDisciplina("abc")).thenReturn(true);
        when(vf.verificarCodigoTurma("turma")).thenReturn(true);

        TurmaController tc = new TurmaController(turmaDAO);
        tc.setVerificador(vf);

        Turma turma = new Turma();
        when(turmaDAO.existe(turma)).thenReturn(true);

        turma.setCodDisciplina("abc");
        turma.setCodTurma("turma");
        turma.setMaximoAlunos(100);
        String result = tc.cadastrarTurma(turma);

        assertEquals("turma ja existe", result);
    }

    @Test
    public void cadastrarTurmaSalvoComSucessoTest() {
        TurmaDAO turmaDAO = mock(TurmaDAO.class);
        VerificadorDeCodigos vf = mock(VerificadorDeCodigos.class);

        when(vf.verificarCodigoDisciplina("abc")).thenReturn(true);
        when(vf.verificarCodigoTurma("turma")).thenReturn(true);

        TurmaController tc = new TurmaController(turmaDAO);
        tc.setVerificador(vf);

        Turma turma = new Turma();
        when(turmaDAO.existe(turma)).thenReturn(false);
        when(turmaDAO.salvar(turma)).thenReturn(true);

        turma.setCodDisciplina("abc");
        turma.setCodTurma("turma");
        turma.setMaximoAlunos(100);
        String result = tc.cadastrarTurma(turma);

        assertEquals("turma salva com sucesso", result);
    }

    @Test
    public void cadastrarTurmaSalvoSemSucessoTest() {
        TurmaDAO turmaDAO = mock(TurmaDAO.class);
        VerificadorDeCodigos vf = mock(VerificadorDeCodigos.class);

        when(vf.verificarCodigoDisciplina("abc")).thenReturn(true);
        when(vf.verificarCodigoTurma("turma")).thenReturn(true);

        TurmaController tc = new TurmaController(turmaDAO);
        tc.setVerificador(vf);

        Turma turma = new Turma();
        when(turmaDAO.existe(turma)).thenReturn(false);
        when(turmaDAO.salvar(turma)).thenReturn(false);

        turma.setCodDisciplina("abc");
        turma.setCodTurma("turma");
        turma.setMaximoAlunos(100);
        String result = tc.cadastrarTurma(turma);

        assertEquals("turma nao salva. Erro no BD", result);
    }
}
