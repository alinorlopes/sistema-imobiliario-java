package modelo;

public class Casa extends Financiamento{
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() {
        double base = super.calcularPagamentoMensal();
        pagamentoMensal = base + 80;  // atualiza o atributo herdado
        totalPagamento = pagamentoMensal * prazoFinanciamento * 12;
        return pagamentoMensal;
    }
    public String toString(){
        return "\nFinaciamento do tipo CASA\n" + super.toString();

    }
}

