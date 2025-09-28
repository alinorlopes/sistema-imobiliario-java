package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                   String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double base = super.calcularPagamentoMensal();
        pagamentoMensal = base * 1.02;  // acréscimo de 2%
        totalPagamento = pagamentoMensal * prazoFinanciamento * 12;
        return pagamentoMensal;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- Financiamento de Terreno ---");
        System.out.println(super.toString());
        System.out.println("Tipo de zona: " + tipoZona);
    }
}
