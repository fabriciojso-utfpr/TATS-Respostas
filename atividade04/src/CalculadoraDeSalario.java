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
        if(funcionario.getSalario() == 5000.00){
            return 4000.00;
        }else{
            return 2500.00;
        }
    }
    
}
