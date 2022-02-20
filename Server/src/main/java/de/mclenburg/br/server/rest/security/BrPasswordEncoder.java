package de.mclenburg.br.server.rest.security;

import de.mclenburg.br.server.jpa.dataobjects.Benutzer;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
public class BrPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("Passwortencode: " + charSequence.toString() + "  --->  " + Benutzer.encryptString(charSequence.toString()));
        return Benutzer.encryptString(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println("Passwortvergleich: " + encode(charSequence) +"  --->  " + s);
        return Benutzer.encryptString(charSequence.toString()).equals(s);
    }
}
