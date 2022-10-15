public class Main {
    public static void main(String[] args) {
        Cliente juca = new Cliente();
        juca.setNome("Juarez");
        
        Conta cc = new ContaCorrente(juca);
        cc.depositar(120.50);

        Conta cp = new ContaPoupança(juca);
        cp.depositar(130.40);

        cc.simularEmprestimo(2000, 24);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}