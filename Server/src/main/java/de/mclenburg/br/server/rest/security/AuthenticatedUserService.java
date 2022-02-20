package de.mclenburg.br.server.rest.security;

import de.mclenburg.br.server.jpa.dataobjects.Benutzer;
import de.mclenburg.br.server.jpa.repository.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedUserService implements UserDetailsService {

    @Autowired
    BenutzerRepository benutzerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Benutzer nutzer = benutzerRepository.findByUsername(s);
        if(nutzer == null) {
            throw new UsernameNotFoundException("Benutzer oder Passwort falsch");
        }
        return new AuthenticatedUser(nutzer);
    }
}
