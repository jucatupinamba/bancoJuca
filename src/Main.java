public class Main {
    public static void main(String[] args) {

        Conta cc = new ContaCorrente();
        cc.depositar(120.50);

        Conta cp = new ContaPoupança();
        cp.depositar(130.40);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}