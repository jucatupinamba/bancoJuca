import usuarios.Cliente;
import operacoesBancarias.ContaCorrente;
import operacoesBancarias.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        ContaCorrente contaCC = null;
        ContaPoupanca contaPP = null;

        System.out.println(" ==== Banco Juca - Um Banco Por Você =====");
        System.out.println();
        System.out.println("Cadastre um cliente: ");
        System.out.println();
        System.out.println("Digite 1 - Conta Corrente" + '\n' + "Digite 2 - Conta Poupança" +
                '\n' + "Digite 0 - Encerrar Operação");
        int num = sc.nextInt();
        sc.nextLine();
        while(num != 0) {
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
                System.out.println("Conta criada com sucesso!");
                contaCC.imprimirExtrato();
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
                System.out.println();
                System.out.println("===Conta criada com sucesso!===");
                System.out.println();
                contaPP.imprimirExtrato();
            }
            System.out.println();
            System.out.println("Deseja cadastrar outro cliente? ");
            System.out.println("Digite 1 - Conta Corrente" + '\n' + "Digite 2 - Conta Poupança" +
                    '\n' + "Digite 0 - Encerrar Operação");
            num = sc.nextInt();
            sc.nextLine();
        }

        System.out.println();

        System.out.println("Qual operação deseja realizar? ");
        System.out.printf("Digite %n1 - Saque %n2 - Deposito %n3 - Transferência" +
                "%n4 - Simular Empréstimo %n5 - Simular Financiamento ");
        int operacao = sc.nextInt();

        if (cliente.ativarContaCorrente() || cliente.ativarContaPoupanca()) {

            int opcao = 0;

            if(operacao >= 1 && operacao <= 3) {
                System.out.printf("Digite: %n1 - Conta Corrente %n2 - Conta");
                opcao = sc.nextInt();
            }

            switch (operacao) {

                case 1:
                    if (opcao == 1 && cliente.ativarContaCorrente()) {
                        System.out.print("Digite o valor de saque: R$ ");
                        double valor = sc.nextDouble();
                        contaCC.sacar(valor);
                    }
                    if (opcao == 2 && cliente.ativarContaPoupanca()) {
                        System.out.print("Digite o valor de saque: R$ ");
                        double valor = sc.nextDouble();
                        contaPP.sacar(valor);
                    } else {
                        System.out.println("Cliente não possui conta ativa.");
                    }
                    break;

                case 2:
                    System.out.printf("Digite: %n1 - Conta Corrente %n2 - Conta");
                    if (opcao == 1 && cliente.ativarContaCorrente()) {
                        System.out.print("Digite o valor de depósito: R$ ");
                        double valor = sc.nextDouble();
                        contaCC.depositar(valor);
                    }
                    if (opcao == 2 && cliente.ativarContaPoupanca()) {
                        System.out.print("Digite o valor de depósito: R$ ");
                        double valor = sc.nextDouble();
                        contaPP.depositar(valor);
                    } else {
                        System.out.println("Cliente não possui conta ativa.");
                    }
                    break;

                case 3:
                    System.out.printf("Digite: %n1 - Conta Corrente %n2 - Conta");
                    if (opcao == 1 && cliente.ativarContaCorrente()) {
                        System.out.print("Digite o valor e a conta que deseja transferir");
                        System.out.print("Valor: R$ ");
                        double valor = sc.nextDouble();
                        System.out.print("Dados da conta à transferir: ");

                        //parei aqui

                    }
                    if (opcao == 2 && cliente.ativarContaPoupanca()) {
                        System.out.print("Digite o valor de depósito: R$ ");
                        double valor = sc.nextDouble();
                        contaPP.depositar(valor);
                    } else {
                        System.out.println("Cliente não possui conta ativa.");
                    }
                    break;



            }
        }
    }
}