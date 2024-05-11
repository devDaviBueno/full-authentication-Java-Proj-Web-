package br.com.zonamods.zonaMods.repositories;

import br.com.zonamods.zonaMods.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(final String email);
    Usuario findByName(final String name);
    Usuario findByIdPlayer(final String idPlayer);
}
