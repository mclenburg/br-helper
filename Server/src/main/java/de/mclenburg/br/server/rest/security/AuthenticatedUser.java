package de.mclenburg.br.server.rest.security;

import de.mclenburg.br.server.jpa.catalogues.Rolle;
import de.mclenburg.br.server.jpa.dataobjects.Benutzer;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class AuthenticatedUser implements UserDetails {
    private final String username;
    private final String passwort;
    private final Benutzer benutzer;

    public AuthenticatedUser(Benutzer nutzer) {
        this.username = nutzer.getUsername();
        this.passwort = nutzer.getPasswort();
        this.benutzer = nutzer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String auth = "";
        for(Rolle rolle : this.benutzer.getRollen()) {
            if(auth.length() == 0)
                auth += rolle.getBezeichnung();
            else
                auth += ","+rolle.getBezeichnung();
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(auth);
    }

    @Override
    public String getPassword() {
        return this.passwort;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
