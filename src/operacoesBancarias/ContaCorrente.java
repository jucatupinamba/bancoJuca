package operacoesBancarias;

import usuarios.Cliente;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Operacoes Bancarias Conta Corrente ===");
        super.imprimirInfosConta();
    }

}
