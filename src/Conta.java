import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public abstract class Conta implements IConta{

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date data;

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
        if(saldo < 1200){
            JUROS = 1.04;
        }
        double valorParcelas = valor / parcelas;
        double valorParcelasAtual;
        double valorAtualizado;
        for(int i = 0; i < parcelas; i++){
            valorParcelasAtual =  (valorParcelas * JUROS) + valorParcelas ;
            System.out.println("Parcela: " + (i + 1) + " - Valor R$ " + valorParcelasAtual);
        }
    }

    protected void imprimirInfosConta() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
