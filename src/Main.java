public class Main {


    public static void main(String[] args) {
        InterfaceUsuario intuser1 = new InterfaceUsuario(); //Instânciamos objeto da classe de interface
        intuser1.pedirValorImovel();
        intuser1.pedirPrazoFinanciamento();
        intuser1.pedirTaxaJurosAnual();



        Financiamento financa1 = new Financiamento(intuser1.valorImovel, intuser1.prazoFinanciamento, intuser1.taxaJurosAnual);
        financa1.calcularPagamentoMensal();




    }
}