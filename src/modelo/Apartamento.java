package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private double taxaJurosMensal;
    private int meses;
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                       int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.taxaJurosMensal = taxaJurosAnual / 100.0 / 12.0;
        this.meses = prazoFinanciamento * 12;
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double fator = Math.pow(1 + taxaJurosMensal, meses);
        pagamentoMensal = valorImovel * taxaJurosMensal * fator / (fator - 1);
        totalPagamento = pagamentoMensal * meses;
        return pagamentoMensal;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- Financiamento de Apartamento ---");
        System.out.println(super.toString());
        System.out.println("Vagas de garagem: " + vagasGaragem);
        System.out.println("Número do andar: " + numeroAndar);
    }

    @Override
    public String toTexto() {
        return "Apartamento;" + id + ";" + valorImovel + ";" + calcularPagamentoTotal() + ";" +
                prazoFinanciamento + ";" + taxaJurosAnual + ";" + vagasGaragem + ";" + numeroAndar;
    }
}
