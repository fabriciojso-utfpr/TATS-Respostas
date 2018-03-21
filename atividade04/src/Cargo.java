enum Cargo {
    DESENVOLVEDOR(new Encargos(3000.00, 20, 10)),
    DBA(new Encargos(2000.00, 25, 15));
    
    private Encargos encargos;
    
    private Cargo(Encargos encargos){
        this.encargos = encargos;
    }
    
    public double calcula(double salario){
        return this.encargos.calcula(salario);
    }
}
