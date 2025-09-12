package modelo;

public class Casa extends Financiamento{
    Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() + 80;
    }
}

