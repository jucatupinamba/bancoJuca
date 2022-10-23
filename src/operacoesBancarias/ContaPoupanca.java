package operacoesBancarias;

import usuarios.Cliente;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public ContaPoupanca() {

    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato operacoesBancarias.Conta Poupança ===");
        super.imprimirInfosConta();
    }
}
