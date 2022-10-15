package operacoesBancarias;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();

    void simularEmprestimo(double valor, int parcelas);

    void simularInvestimento(double valor, int meses);


}
