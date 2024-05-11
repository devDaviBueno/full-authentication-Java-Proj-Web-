package br.com.zonamods.zonaMods.controller;

import br.com.zonamods.zonaMods.repositories.IUsuario;
import br.com.zonamods.zonaMods.entities.Usuario;
import br.com.zonamods.zonaMods.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class                                                                                                                    userController {
    @Autowired

    private UsuarioService repository;

    public userController(UsuarioService repository){
        this.repository = repository;
    }

    @GetMapping
    public Object mostrar(){
        return repository.mostrarDb();
    }

    @PostMapping("/register")
    public Object register (@Valid @RequestBody Usuario user){
       return repository.InserirUser(user);
    }

    @PostMapping("/login")
    public Object login (@RequestBody Usuario user) {
        return repository.LoginUser(user);
    }

    @GetMapping("/Fivem/{numPolice}/{GetNumPlayerIndices}")
    public ResponseEntity<Integer> receberDados(@PathVariable Integer numPolice, @PathVariable Integer GetNumPlayerIndices) {
        System.out.println("Policiais onlines: " + numPolice + " e pessoas onlines: " + GetNumPlayerIndices);
        return ResponseEntity.ok(numPolice);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName, errorMessage);
        });
        return erros;
    }
}
