package de.mclenburg.br.server.rest;

import de.mclenburg.br.server.jpa.repository.BenutzerRepository;
import de.mclenburg.br.server.jpa.repository.KollegeRepository;
import de.mclenburg.br.server.rest.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Role;
import org.springframework.expression.AccessException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BenutzerRestController {

    @Autowired
    private BenutzerRepository benutzerRepository;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping(path = Benutzer.ENDPOINT+"/{username}")
    public BrResponse<Benutzer> getByUsername(@PathVariable String username) {
        return new BrResponse<>(mapToApi(benutzerRepository.findByUsername(username)), null);
    }

    @PostMapping(path = Benutzer.ENDPOINT)
    @RolesAllowed(value = {"ROLE_ADMIN"})
    public BrResponse<Benutzer> addKollege(@RequestBody Benutzer benutzer) {
        if(benutzer.getNachname() == null) return null;
        if(benutzer.getVorname() == null) return null;
        benutzerRepository.save(mapToJpa(benutzer));
        return new BrResponse<>(mapToApi(benutzerRepository.findByUsername(benutzer.getBenutzername())), null);
    }

    @GetMapping(path = Benutzer.ENDPOINT)
    public void getWithoutParam() throws AccessException {
        throw new AccessException("not allowed");
    }

    private Benutzer mapToApi(de.mclenburg.br.server.jpa.dataobjects.Benutzer benutzer) {
        String host = InetAddress.getLoopbackAddress().getHostName()+":"+serverPort;
            Benutzer apiBenutzer = new Benutzer();
            apiBenutzer.setId(benutzer.getId());
            apiBenutzer.setNachname(benutzer.getNachname());
            apiBenutzer.setVorname(benutzer.getVorname());
            apiBenutzer.setBenutzername(benutzer.getUsername());
            apiBenutzer.setPasswort("[PASSWORD IS HIDDEN]");
            List<String> rollen = new ArrayList<>();
            if(benutzer.getRollen() != null && benutzer.getRollen().size() > 0) {
                benutzer.getRollen().parallelStream().forEach(rolle -> {
                    rollen.add("http://" + host + "/" + Rolle.ENDPOINT + "/" + rolle.getId());
                });
            }
        return apiBenutzer;
    }

    private de.mclenburg.br.server.jpa.dataobjects.Benutzer mapToJpa(Benutzer benutzer) {
        de.mclenburg.br.server.jpa.dataobjects.Benutzer nutzer = new de.mclenburg.br.server.jpa.dataobjects.Benutzer();
        nutzer.setNachname(benutzer.getNachname());
        nutzer.setVorname(benutzer.getVorname());
        nutzer.setUsername(benutzer.getBenutzername());
        nutzer.setPasswort(de.mclenburg.br.server.jpa.dataobjects.Benutzer.encryptString(benutzer.getPasswort()));
        return nutzer;
    }
}
