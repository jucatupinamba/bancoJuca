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


    public List<Conta> listarContas(Conta contaRecebida) {    //método desativado - provavel erro na lógica
        Conta controle = null;
        try {
            int numeroConta = contaRecebida.getNumeroConta();
            for (Conta c : admConta) {
                if (numeroConta == c.getNumeroConta()) {
                    System.out.println("Conta encontrada!");
                    controle = contaRecebida;
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
        return Collections.singletonList(controle);
    }
}
