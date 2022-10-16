package operacoesBancarias;

import java.util.Collections;
import java.util.List;

public class Banco {
    private String nome;

    private Conta contaAdm;

    private List<Conta> admConta;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> addConta(Conta contaAdd) {
         admConta.add(contaAdm);
        return admConta;
    }


    public List<Conta> listarContas(Conta contaRecebida) {
        Conta controle = null;
        int numeroConta = contaRecebida.getNumeroConta();
        for (Conta c : admConta) {
            if(numeroConta == c.getNumeroConta()){
                System.out.println("Conta encontrada!");
                controle = contaRecebida;
                c.imprimirInfosConta();
            }
            if(numeroConta != c.getNumeroConta()){
                System.out.println("Conta não encontrada!");
            }
        }
        return Collections.singletonList(controle);
    }
}
