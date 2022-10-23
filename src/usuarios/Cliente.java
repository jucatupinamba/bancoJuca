package usuarios;

import operacoesBancarias.Conta;
import operacoesBancarias.ContaCorrente;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    private Conta conta;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Cliente() {

    }

    public boolean ativarContaCorrente(){
        return true;
    }

    public boolean ativarContaPoupanca(){
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
