enum Cargo {
    DESENVOLVEDOR(new Encargos(3000.00, 20, 10)),
    DBA(new Encargos(2000.00, 25, 15)),
    TESTADOR(new Encargos(2000.00, 25, 15)), 
    GERENTE(new Encargos(5000.00, 30, 20));
    
    private final Encargos encargos;
    
    private Cargo(Encargos encargos){
        this.encargos = encargos;
    }
    
    public double calcula(double salario){
        return this.encargos.calcula(salario);
    }
}
