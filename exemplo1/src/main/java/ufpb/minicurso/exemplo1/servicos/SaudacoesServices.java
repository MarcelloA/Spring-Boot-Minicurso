package ufpb.minicurso.exemplo1.servicos;

import org.springframework.stereotype.Service;
import ufpb.minicurso.exemplo1.entidades.Saudacao;
import ufpb.minicurso.exemplo1.entidades.SaudacaoTemporalFactory;

import javax.xml.parsers.SAXParser;

@Service
public class SaudacoesServices {
    private Saudacao saudacao = new Saudacao();
    private Saudacao saudacaoAlternativa = new Saudacao();

    public Saudacao getSaudacao(String nome){
        Saudacao saudacao = new Saudacao();
        saudacao.setNome(nome);
        return saudacao;
    }

    public Saudacao getSaudacaoTemporal(String nome){
        return SaudacaoTemporalFactory.getSaudacaoTemporal(nome);
    }

    public Saudacao setNovaSaudacao(Saudacao novaSaudacao){
        saudacaoAlternativa = novaSaudacao;
        return saudacaoAlternativa;
    }

    public Saudacao getNovaSaudacao(String nome){
        saudacaoAlternativa.setNome(nome);
        return saudacaoAlternativa;
    }
}
