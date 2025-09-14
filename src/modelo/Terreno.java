package modelo;

public class Terreno extends Financiamento {

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() {
        double base = super.calcularPagamentoMensal();
        pagamentoMensal = base * 1.02;  // atualiza o atributo herdado
        totalPagamento = pagamentoMensal * prazoFinanciamento * 12;
        return pagamentoMensal; //Adicionado um acrésimo de 2% no financiamento de terreno
    }

    public String toString() {
        return "\nFinaciamento do tipo TERRENO\n" + super.toString();
    }
}




