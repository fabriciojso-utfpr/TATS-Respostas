class Encargos {
    
    protected double descontoMinimo;
    protected double descontoMaximo;
    protected double valorMaximo;
    
    public Encargos(double valorMaximo, double descontoMaximo, double descontoMinimo){
        this.valorMaximo = valorMaximo;
        this.descontoMaximo = descontoMaximo/100;
        this.descontoMinimo = descontoMinimo/100;
    }
    
    public final double calcula(double salario){
        double encargos = 0;
        if(salario >= this.valorMaximo){
            encargos = salario * this.descontoMaximo;
        }else{
             encargos = salario * this.descontoMinimo;
        }
        System.out.println(encargos);
        return salario - encargos;
    }
    
    
}
