package ufpb.minicurso.lab1.servicos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "DISCIPLINA DUPLICADA")
public class ExceptionHandler extends IllegalArgumentException {
    public ExceptionHandler(){
        super();
    }
}
