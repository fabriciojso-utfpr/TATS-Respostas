/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabriciojso
 */
public class Validador {
 
    public static void validaCliente(Cliente cliente) throws IllegalArgumentException{
        if (cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio");
        }
        if (cliente.getSalario() <= 0) {
            throw new IllegalArgumentException("O salario deve ser maior que zero");
        }
        if (cliente.getIdade() < 18 || cliente.getIdade() > 70) {
            throw new IllegalArgumentException("A idade deve ser entre 18 e 70");
        }
    }
}
