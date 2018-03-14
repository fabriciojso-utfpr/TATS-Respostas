package complementares.questao4;

import java.util.ArrayList;

public class RelatorioDeFuncionarios {

    FuncionarioDAO funcDao;
    ReceitaFederal rf;

    public RelatorioDeFuncionarios(FuncionarioDAO funcDao) {
        this.funcDao = funcDao;
    }

    public void setRf(ReceitaFederal rf) {
        this.rf = rf;
    }

    public int getFuncComCPFBloqueado(String categoria) {
        int numeroDeFuncionarios = 0;

        ArrayList<Funcionario> funcCategoria = funcDao.getFuncionariosBy(categoria);

        for (Funcionario f : funcCategoria) {
            if (rf.isCPFBloqueado(f.getCpf())) {
                numeroDeFuncionarios++;
            }
        }

        return numeroDeFuncionarios;
    }
}
