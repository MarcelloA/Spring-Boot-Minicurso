package ufpb.minicurso.exemplo1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpb.minicurso.exemplo1.entidades.Saudacao;
import ufpb.minicurso.exemplo1.servicos.SaudacoesServices;

@RestController
public class ExampleSaudacoes {
    @Autowired
    private SaudacoesServices saudacoesService;

    @GetMapping("/v1/api/saudacoes")
    public ResponseEntity<Saudacao> getSaudacoes(@RequestParam(value="nome", defaultValue ="Ser Humano")String nome){
        return new ResponseEntity<Saudacao>(saudacoesService.getSaudacao(nome),HttpStatus.OK);
    }

    @GetMapping("/v1/api/saudacoes/hora")
    public ResponseEntity<Saudacao> getSaudacaoTemporal(@RequestParam(value = "nome", defaultValue = "Ser Humano") String nome){
        return new ResponseEntity<Saudacao>(saudacoesService.getSaudacaoTemporal(nome), HttpStatus.OK);
    }

    @PostMapping("v1/api/saudacoes/alternativa")
    public ResponseEntity<Saudacao> setNovaSaudacao(@RequestBody Saudacao novaSaudacao){
        return new ResponseEntity<Saudacao>(saudacoesService.setNovaSaudacao(novaSaudacao),HttpStatus.CREATED);
    }

    @GetMapping("v1/api/saudacoes/alternativa")
    public ResponseEntity<Saudacao> getNovaSaudacao(@RequestParam (value="nome", defaultValue="Ser Humano") String nome){
        return new ResponseEntity<Saudacao>(saudacoesService.getNovaSaudacao(nome),HttpStatus.OK);
    }


}
