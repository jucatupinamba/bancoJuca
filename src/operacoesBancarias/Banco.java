package operacoesBancarias;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;

    private Conta contaAdm;

    private List<Conta> admConta = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> addConta(Conta contaAdd) {
        admConta.add(contaAdd);
        return admConta;
    }


    public void listarContas(Conta contaRecebida) {    //método em teste - provavel erro na lógica
        try {
            int numeroConta = contaRecebida.getNumeroConta();
            for (Conta c : admConta) {
                if (numeroConta == c.getNumeroConta()) {
                    System.out.println("Conta encontrada!");
                    c.imprimirInfosConta();
                }
                if (numeroConta != c.getNumeroConta()) {
                    System.out.println("Conta não encontrada!");
                }
            }
        }
        catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
    }
}
