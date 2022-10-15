package operacoesBancarias;

import usuarios.Cliente;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Conta implements IConta{

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar data = Calendar.getInstance();

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
                JUROS = 1.02;
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
    public void simularEmprestimo(double valor, int parcelas){

        if(saldo < 1200){
            JUROS = 1.04;
        }
        else if(saldo < 0){
            JUROS = 1.10;
        }

        double valorParcelas = valor / parcelas;
        double valorParcelasAtual = valorParcelas;
        double valorTotal;
        double soma = 0;

        for(int i = 0; i < parcelas; i++){
            valorTotal = valorParcelasAtual * Math.pow(JUROS, i);
            soma += valorTotal;
            if(i == 0){
                System.out.println("INFO: Primeira Parcela sem Juros!");
                System.out.println();
            }
            System.out.printf("Parcela: %d - Valor R$ %.2f %n", i + 1, valorTotal);
        }
        System.out.println();
        System.out.printf("Valor Total a Pagar: %.2f %n", soma);
    }
    @Override
    public void simularInvestimento(double valor, int meses){
        if(valor > 3000){
            JUROS = 1.04;
        }
        else if(valor < 5000){
            JUROS = 1.10;
        }

        double valorTotal = 0;
        double soma = 0;

        for(int i = 1; i < meses; i++){
            valorTotal += (valor * Math.pow(JUROS - 1, i));
            soma += valorTotal;
            }
        double rendimentoJuros = valor - soma;
        double valorFinal = soma + valor;
        System.out.printf("Rendimentos em juros no período: %.2f ", rendimentoJuros);
        System.out.println();
        System.out.printf("Valor Total a Pagar: %.2f %n", valorFinal);
    }

    protected void imprimirInfosConta() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
