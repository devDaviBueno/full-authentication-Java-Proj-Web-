package br.com.zonamods.zonaMods.service;

import br.com.zonamods.zonaMods.entities.Usuario;
import br.com.zonamods.zonaMods.repositories.IUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public ResponseEntity<Object> InserirUser(Usuario user){
        try {
            Usuario userEmailExist = repository.findByEmail(user.getEmail());
            Usuario userNameExist = repository.findByName(user.getName());
            if(userEmailExist != null) {
                return ResponseEntity.status(404).body("O email inserido já existe");
            }
            if(userNameExist != null) {
                return ResponseEntity.status(404).body("O nome inserido já existe");
            }
            String encoder = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(encoder);
            user.setPending(true);
            Usuario addUser = repository.save(user);
            return ResponseEntity.ok(addUser);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body("Erro no servidor");
        }
    }

    public ResponseEntity<Object> mostrarDb(){
        return ResponseEntity.status(202).body(repository.findAll());
    }

    public ResponseEntity<Object> LoginUser(Usuario user){
        Usuario IdPlayerExist = repository.findByIdPlayer(user.getIdPlayer());
        System.out.println(user.getIdPlayer());
        System.out.println(user.getPassword());
        if(IdPlayerExist == null) {
            return ResponseEntity.status(404).body("ID não encontrado.");
        }
        String senha = IdPlayerExist.getPassword();
        boolean decode = passwordEncoder.matches(user.getPassword(),senha);

        if(!decode) {
            return ResponseEntity.status(401).body("Senha invalida.");
        }

        Boolean pending = IdPlayerExist.getPending();

        if (pending == Boolean.TRUE) {
            return ResponseEntity.status(401).body("Usuario ainda não aprovado");
        }

        return ResponseEntity.ok(IdPlayerExist);
    }


}
