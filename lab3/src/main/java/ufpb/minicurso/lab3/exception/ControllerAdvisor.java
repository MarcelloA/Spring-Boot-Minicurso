package ufpb.minicurso.lab3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerAdvisor {
//--------------------------------EXEMPLO------------------------------------------------------------
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    ResponseEntity<String> handleRuntimeException(RuntimeException e){
//        return new ResponseEntity<>(e.getMessage() + "\n"+ e.getStackTrace()[0].toString(),HttpStatus.BAD_REQUEST);
//    }
//----------------------------------------------------------------------------------------------------
}
