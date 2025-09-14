package modelo;

public class Apartamento extends Financiamento {
    private double taxaJurosMensal;
    private int meses;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaJurosMensal = taxaJurosAnual / 100.0 / 12.0; // converte pra mensal
        this.meses = prazoFinanciamento * 12; // converte anos em meses
    }

    public double calcularPagamentoMensal() {
        double fator = Math.pow(1 + taxaJurosMensal, meses);
        pagamentoMensal = valorImovel * taxaJurosMensal * fator / (fator - 1); // atualiza atributo da super
        totalPagamento = pagamentoMensal * meses; // atualiza total também
        return pagamentoMensal;
    }

    public String toString() {
        return "\nFinanciamento do tipo APARTAMENTO\n" + super.toString();
    }
}
