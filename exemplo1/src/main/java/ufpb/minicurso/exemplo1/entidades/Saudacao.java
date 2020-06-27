package ufpb.minicurso.exemplo1.entidades;

public class Saudacao {
    private String nome;
    private String saudacao;

    public Saudacao(){
        this.saudacao = "Oi";
    }

    public Saudacao(String nome, String saudacao){
        super();
        this.nome = nome;
        this.saudacao = saudacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSaudacao() {
        return saudacao;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }
}
