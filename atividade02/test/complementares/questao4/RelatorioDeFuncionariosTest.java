package complementares.questao4;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RelatorioDeFuncionariosTest {

    @Test
    public void getFuncComCPFBloqueadoComDoisTecnicosComOCPFnaoBloqueado() {

        FuncionarioDAO funcDao = mock(FuncionarioDAO.class);
        ArrayList<Funcionario> tecnicos = new ArrayList<>();
        tecnicos.add(new Funcionario(1, "Fabricio", "1234"));
        tecnicos.add(new Funcionario(2, "Fabricio", "1234"));
        when(funcDao.getFuncionariosBy("tecnico")).thenReturn(tecnicos);

        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(funcDao);

        ReceitaFederal rf = mock(ReceitaFederal.class);
        when(rf.isCPFBloqueado("1234")).thenReturn(false);

        relatorio.setRf(rf);

        assertEquals(0, relatorio.getFuncComCPFBloqueado("tecnico"));
    }

    @Test
    public void getFuncComCPFBloqueadoComUmAnalistaComCPFBloqueado() {

        FuncionarioDAO funcDao = mock(FuncionarioDAO.class);
        ArrayList<Funcionario> analista = new ArrayList<>();
        analista.add(new Funcionario(1, "Gerente 1", "1234"));
        when(funcDao.getFuncionariosBy("analista")).thenReturn(analista);

        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(funcDao);

        ReceitaFederal rf = mock(ReceitaFederal.class);
        when(rf.isCPFBloqueado("1234")).thenReturn(true);

        relatorio.setRf(rf);

        assertEquals(1, relatorio.getFuncComCPFBloqueado("analista"));
    }

    @Test
    public void getFuncComCPFBloqueadoComQuatroGerentesEComDoisComOCPFBloqueado() {

        FuncionarioDAO funcDao = mock(FuncionarioDAO.class);
        ArrayList<Funcionario> gerentes = new ArrayList<>();
        gerentes.add(new Funcionario(1, "Gerente 1", "123456789-00"));
        gerentes.add(new Funcionario(1, "Gerente 2", "111222333-44"));
        gerentes.add(new Funcionario(1, "Gerente 3", "654321987-23"));
        gerentes.add(new Funcionario(1, "Gerente 4", "098876654-99"));
        when(funcDao.getFuncionariosBy("gerente")).thenReturn(gerentes);

        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(funcDao);

        ReceitaFederal rf = mock(ReceitaFederal.class);
        when(rf.isCPFBloqueado(anyString())).thenReturn(false);
        when(rf.isCPFBloqueado("111222333-44")).thenReturn(true);
        when(rf.isCPFBloqueado("098876654-99")).thenReturn(true);

        relatorio.setRf(rf);

        assertEquals(2, relatorio.getFuncComCPFBloqueado("gerente"));
    }
}
