public abstract class Conta implements IConta{

    protected static int AGENCIA_PADRAO = 1;

    protected static int SEQUENCIAL = 1;

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
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
        else{
            System.out.println("Você não possui saldo suficiente para fazer essa operação.");
        }
    }

    protected void imprimirInfosConta() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
