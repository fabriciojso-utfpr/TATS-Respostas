/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabriciojso
 */
class CalculadoraDeSalario {

    double calcula(Funcionario funcionario) {
        double porcentagem = 100;
        if(funcionario.getCargo().equals("desenvolvedor") && funcionario.getSalario() >= 3000.00){
            porcentagem = 20;
        }else{
            porcentagem = 10;
        }
        
        double desconto = funcionario.getSalario()  * (porcentagem / 100);
        return funcionario.getSalario() - desconto;
    }
    
}
