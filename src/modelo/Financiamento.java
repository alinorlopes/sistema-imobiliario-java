package modelo;
public class Financiamento {

    //Atributos

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    protected double pagamentoMensal;
    protected double totalPagamento;
    public int id;
    private static int contador = 1;

    //Métodos Getters:

    public double getValorImovel() {
        return this.valorImovel;
    }
    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }
    public double getPagamentoMensal() {
        return this.pagamentoMensal;
    }
    public double getTotalPagamento() {
        return this.totalPagamento;
    }

    //Método Construtor:

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.id = contador++;
    }

    //Métodos

    public String toString(){
        if(totalPagamento == 0){
            calcularPagamentoTotal();
        }
        String valorImovelFormatado = String.format("%.2f", valorImovel).replace('.', ',');
        String totalPagamentoFormatado = String.format("%.2f", totalPagamento).replace('.', ',');
        String pagamentoMensalFormatado = String.format("%.2f", pagamentoMensal).replace('.', ',');

        return  "Financiamento  "  + id +
        "\n Valor do imóvel: R$" + valorImovelFormatado +
        "\n Valor total do Financiamento: R$" + totalPagamentoFormatado +
        "\n Prazo: " + prazoFinanciamento + " anos" +
        "\n Taxa de juros anual: " + taxaJurosAnual +"%" +
        "\n Pagamento Mensal: " + "R$" + pagamentoMensalFormatado;
    }

    public double calcularPagamentoMensal() {
        pagamentoMensal = (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual /100 /12));
        System.out.printf(" O valor da parcela mensal desse financiamento é de R$%.2f.\n", pagamentoMensal);
        return pagamentoMensal;
    }

    public double calcularPagamentoTotal() {
        if (pagamentoMensal == 0) {
            calcularPagamentoMensal();
        }
        totalPagamento = (pagamentoMensal * prazoFinanciamento * 12);
        return totalPagamento;
    }
}