package com.eventoapp.eventoapp.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Usuario implements UserDetails {

    @Id
    private String login;

    private String nomeCompleto;

    private String senha;

    @ManyToMany
    @JoinTable(name = "usuarios_regras",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"),
            inverseJoinColumns = @JoinColumn(name = "regra_id", referencedColumnName = "nomeRegra")
    )
    private List<Regra> regras;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) this.regras;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
