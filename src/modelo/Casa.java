package modelo;

import util.AcrescimoMaiorDoQueJurosException;
import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double base = super.calcularPagamentoMensal();
        double aumento = 80;

        if (aumento > base * 0.5) {
            throw new AcrescimoMaiorDoQueJurosException(
                    "Acréscimo maior do que metade do valor dos juros da mensalidade!"
            );
        }

        pagamentoMensal = base + aumento;
        totalPagamento = pagamentoMensal * prazoFinanciamento * 12;
        return pagamentoMensal;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- Financiamento de Casa ---");
        System.out.println(super.toString());
        System.out.println("Área construída: " + areaConstruida + " m²");
        System.out.println("Área do terreno: " + areaTerreno + " m²");
    }

    @Override
    public String toTexto() {
        return "Casa;" + id + ";" + valorImovel + ";" + calcularPagamentoTotal() + ";" +
                prazoFinanciamento + ";" + taxaJurosAnual + ";" + areaConstruida + ";" + areaTerreno;
    }
}
