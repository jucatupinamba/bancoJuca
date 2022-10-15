import java.text.DateFormat;
import java.time.LocalDateTime;

public abstract class Conta implements IConta{

    LocalDateTime data = 

    protected static int AGENCIA_PADRAO = 1;

    protected static int SEQUENCIAL = 1;

    protected static double JUROS = 1.02;


    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(saldo > valor) {
            if(valor > 1000) {
                JUROS = 1.03;
            }
            saldo -= JUROS;
            saldo -= valor;
        }
        else{
            System.out.println("Você não possui saldo suficiente para fazer essa operação.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(saldo > valor && contaDestino != null) {
            if(valor > 1000){
                JUROS = 1.03;
            }
            saldo -= (valor * JUROS);
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
        else{
            System.out.println("Você não possui saldo suficiente para fazer essa operação.");
        }
    }
    @Override
    public void emprestimo(double valor, int parcelas){
        if(saldo > 1200){

        }
    }

    protected void imprimirInfosConta() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
