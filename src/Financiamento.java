public class Financiamento {
    //Atributos
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;
    double pagamentoMensal;
    double totalPagamento;

    //Métodos

    public Financiamento (double valorImovel, int prazoFinanciamento, double taxaJurosAnual) { //Método Construtor
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    double calcularPagamentoMensal(){
        pagamentoMensal = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
        System.out.printf(" O valor da parcela mensal desse financiamento é de R$%.2f." ,pagamentoMensal);
        return pagamentoMensal;

    }
    double calcularPagamentoTotal(){
        totalPagamento = (pagamentoMensal * prazoFinanciamento * 12);
                return totalPagamento;
    }


}
