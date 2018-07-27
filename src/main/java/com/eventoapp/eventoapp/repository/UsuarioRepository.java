package com.eventoapp.eventoapp.repository;

import com.eventoapp.eventoapp.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findByLogin(String login);

}
