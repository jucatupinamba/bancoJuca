import operacoesBancarias.Banco;
import operacoesBancarias.Conta;
import usuarios.Cliente;
import operacoesBancarias.ContaCorrente;
import operacoesBancarias.ContaPoupanca;

import java.util.Scanner;

/* Desafio de Projeto Quebec Java Digital
   Juarez Martins
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        ContaCorrente contaCC = null;
        ContaPoupanca contaPP = null;
        Banco admContas = new Banco();


        System.out.println(" ==== Banco Juca - Um Banco Por Você =====");
        System.out.println("  ****************   **************");
        System.out.println(" ==== Seja Bem-Vindo Adm Bancário =====");
        System.out.println();
        System.out.println("  === Operação Cadastro de cliente ===");
        System.out.println();
        System.out.println("Digite 1 - Conta Corrente" + '\n' + "Digite 2 - Conta Poupança" +
                '\n' + "Digite 0 - Encerrar Operação");
        int num = sc.nextInt();
        sc.nextLine();
        while (num != 0) {
            if (num == 1) {
                System.out.println("Digite o nome: ");
                String nome = sc.nextLine();
                System.out.println("Digite o CPF: ");
                String cpf = sc.nextLine();
                System.out.println("Digite o telefone: ");
                String telefone = sc.nextLine();
                cliente = new Cliente(nome, cpf, telefone);
                cliente.ativarContaCorrente();
                contaCC = new ContaCorrente(cliente);
                admContas.addConta(contaCC);

                System.out.println("Digite o valor do depósito inicial: R$ ");
                double depoInit = sc.nextDouble();
                contaCC.depositar(depoInit);

                System.out.println("Conta criada com sucesso!");
                contaCC.imprimirExtrato();
                System.out.println("Digite ENTER para continuar");
                sc.nextLine();
                sc.nextLine();
            }
            if (num == 2) {
                System.out.println("Digite o nome: ");
                String nome = sc.nextLine();
                System.out.println("Digite o CPF: ");
                String cpf = sc.nextLine();
                System.out.println("Digite o telefone: ");
                String telefone = sc.nextLine();
                cliente = new Cliente(nome, cpf, telefone);
                cliente.ativarContaPoupanca();
                contaPP = new ContaPoupanca(cliente);

                System.out.println("Digite o valor do depósito inicial: R$ ");
                double depoInit = sc.nextDouble();
                contaPP.depositar(depoInit);

                System.out.println();
                System.out.println("===Conta criada com sucesso!===");
                System.out.println();
                contaPP.imprimirExtrato();
                System.out.println("Digite ENTER para continuar");
                sc.nextLine();
                sc.nextLine();
            }

            System.out.println();
            System.out.println("Deseja cadastrar outro cliente? ");
            System.out.println("Digite 1 - Conta Corrente" + '\n' + "Digite 2 - Conta Poupança" +
                    '\n' + "Digite 0 - Encerrar Operação");
            num = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();
        System.out.println(" === Operação Manutenção das Contas Bancárias ===");
        System.out.println();
        System.out.println(" Digite ENTER para continuar ");
        sc.nextLine();

        System.out.println("Qual operação deseja realizar? ");
        System.out.printf("Digite %n1 - Saque %n2 - Deposito %n3 - Transferência" +
                "%n4 - Simular Empréstimo %n5 - Simular Investimento " +
                "%n0 - Finalizar Aplicação %n");
        int operacao = sc.nextInt();

        while (operacao != 0) {

            if (cliente.ativarContaCorrente() || cliente.ativarContaPoupanca()) {

                System.out.println("Digite o número da conta que deseja realizar a operação: ");
                int numConta = sc.nextInt();

                switch (operacao) {

                    case 1:
                        if (contaCC.getNumeroConta() == numConta) {
                            System.out.println("Digite o valor de saque: R$ ");
                            double valor = sc.nextDouble();
                            contaCC.sacar(valor);
                            contaCC.imprimirExtrato();
                            System.out.println("Digite ENTER para continuar");
                            sc.nextLine();
                            sc.nextLine();
                        }
                        if (contaPP.getNumeroConta() == numConta) {
                            System.out.println("Digite o valor de saque: R$ ");
                            double valor = sc.nextDouble();
                            contaPP.sacar(valor);
                            contaPP.imprimirExtrato();
                            System.out.println("Digite ENTER para continuar");
                            sc.nextLine();
                            sc.nextLine();
                        }
                        break;

                    case 2:
                        if (contaCC.getNumeroConta() == numConta) {
                            System.out.println("Digite o valor de depósito: R$ ");
                            double valor = sc.nextDouble();
                            contaCC.depositar(valor);
                            contaCC.imprimirExtrato();
                            System.out.println("Digite ENTER para continuar");
                            sc.nextLine();
                            sc.nextLine();
                        }
                        if (contaPP.getNumeroConta() == numConta) {
                            System.out.println("Digite o valor de depósito: R$ ");
                            double valor = sc.nextDouble();
                            contaPP.depositar(valor);
                            contaPP.imprimirExtrato();
                            System.out.println("Digite ENTER para continuar");
                            sc.nextLine();
                            sc.nextLine();
                        }
                        break;

                    case 3:
                        if (contaCC.getNumeroConta() == numConta) {
                            System.out.println("Digite o valor da transferência R$ ");
                            double valor = sc.nextDouble();
                            contaCC.sacar(valor);
                            System.out.println("Digite o numero da conta a receber  a tranferência: ");
                            int contaReceberDepo = sc.nextInt();

                            if (contaCC.getNumeroConta() == contaReceberDepo) {
                                contaCC.depositar(valor);
                                System.out.println("Depósito realizado com sucesso em Conta Corrente.");
                                contaCC.imprimirExtrato();
                                System.out.println("Digite ENTER para continuar");
                                sc.nextLine();
                                sc.nextLine();
                            }
                            if (contaPP.getNumeroConta() == contaReceberDepo) {
                                contaPP.depositar(valor);
                                System.out.println("Depósito realizado com sucesso em Conta Poupança.");
                                contaPP.imprimirExtrato();
                                System.out.println("Digite ENTER para continuar");
                                sc.nextLine();
                                sc.nextLine();
                            }
                            break;
                        }
                        if (contaPP.getNumeroConta() == numConta) {
                            System.out.println("Digite o valor da transferência R$ ");
                            double valor = sc.nextDouble();
                            contaPP.sacar(valor);
                            System.out.println("Digite o numero da conta a receber  a tranferência: ");
                            int contaReceberDepo = sc.nextInt();
                            if (contaCC.getNumeroConta() == contaReceberDepo) {
                                contaCC.depositar(valor);
                                System.out.println("Depósito realizado com sucesso em Conta Corrente.");
                                System.out.println();
                                contaCC.imprimirExtrato();
                                System.out.println("Digite ENTER para continuar");
                                sc.nextLine();
                                sc.nextLine();
                            }
                            if (contaPP.getNumeroConta() == contaReceberDepo) {
                                contaPP.depositar(valor);
                                System.out.println("Depósito realizado com sucesso em Conta Poupança.");
                                System.out.println();
                                contaPP.imprimirExtrato();
                                System.out.println("Digite ENTER para continuar");
                                sc.nextLine();
                                sc.nextLine();
                            }
                            break;
                        }
                    case 4:
                        System.out.print("Digite o valor que deseja simular o empréstimo: R$ ");
                        double valorEmprestimo = sc.nextDouble();
                        System.out.println("Digite quantas parcelas deseja pagar: ");
                        int parcelas = sc.nextInt();
                        contaCC.simularEmprestimo(valorEmprestimo, parcelas);
                        System.out.println("Digite ENTER para continuar");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    case 5:
                        System.out.print("Digite o valor que deseja simular em investimento: R$ ");
                        double valorInvestimento = sc.nextDouble();
                        System.out.println("Digite a quantidade de meses que deseja deixar o dinheiro investindo: ");
                        int meses = sc.nextInt();
                        contaCC.simularInvestimento(valorInvestimento, meses);
                        System.out.println("Digite ENTER para continuar");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    case 6: System.out.println("Digite o numero da conta que deseja pesquisar: ");
                        contaCC.setNumeroConta(sc.nextInt());
                        contaCC.getNumeroConta();
                        admContas.listarContas(contaCC);
                        System.out.println("Digite ENTER para continuar");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    case 0:
                        operacao = 0;
                        break;
                }
            }
            else{
                System.out.println("Conta inativa.");
            }
            System.out.println("Deseja realizar outra operação? ");
            System.out.printf("Digite %n1 - Saque %n2 - Deposito %n3 - Transferência" +
                    "%n4 - Simular Empréstimo %n5 - Simular Financiamento" +
                    "%n0 - Finalizar Aplicação %n");
            operacao = sc.nextInt();
        }

        System.out.println("Obrigado por utilizar nossos serviços!");
        System.out.println("**************************************");
        System.out.println();
        System.out.println(" ==== Banco Juca - Um Banco Por Você =====");
    }
}