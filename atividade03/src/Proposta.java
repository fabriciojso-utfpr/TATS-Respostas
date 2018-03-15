
class Proposta {

    double valorTotal;
    double valorDaParcela;
    int numeroDeParcelas;

    public Proposta(double fator, double valorDoEmprestimo, int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
        this.valorTotal = fator * valorDoEmprestimo;
        this.valorDaParcela = this.valorTotal / numeroDeParcelas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDaParcela() {
        return valorDaParcela;
    }

    public void setValorDaParcela(double valorDaParcela) {
        this.valorDaParcela = valorDaParcela;
    }

    public int getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
