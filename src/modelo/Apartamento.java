package modelo;

public class Apartamento extends Financiamento {
    //Atributos
    double taxaJurosMensal;
    int meses;

    Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() { //Amortização PRICE
        double fator = Math.pow(1 + taxaJurosMensal, meses);
        return valorImovel * taxaJurosMensal * fator / (fator - 1);
    }
}