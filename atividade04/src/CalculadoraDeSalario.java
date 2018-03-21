class CalculadoraDeSalario {

    double calcula(Funcionario funcionario) {
        return funcionario.getCargo().calcula(funcionario.getSalario());
    }
    
}
